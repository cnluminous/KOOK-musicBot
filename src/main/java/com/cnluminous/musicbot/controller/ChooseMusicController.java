package com.cnluminous.musicbot.controller;

import cn.enaium.kook.spring.boot.starter.annotation.event.Event;
import cn.enaium.kook.spring.boot.starter.annotation.event.Register;
import cn.enaium.kook.spring.boot.starter.api.MessageAPI;
import cn.enaium.kook.spring.boot.starter.model.sign.data.EventData;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message.KMarkdownMessage;
import com.cnluminous.musicbot.GeneralManager;
import com.cnluminous.musicbot.entity.MusicInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author CNLuminous
 */
@Slf4j
@Register
public class ChooseMusicController {

    public static final String COMMAND = "点歌";
    @Event(KMarkdownMessage.class)
    public void kMarkdownMessageEvent(EventData<KMarkdownMessage> kMarkdownMessageEventData) {
        Map<Object, Object> kmarkdown = kMarkdownMessageEventData.extra.kmarkdown;
        Object rawContent = kmarkdown.get("raw_content");
        String[] content = rawContent.toString().split(" ");
        if (content.length >= 1) {
            if (COMMAND.equals(content[0])){
                if (content.length!=1){
                    GeneralManager.getAsyncService().search(rawContent.toString().substring(3),kMarkdownMessageEventData.author_id, kMarkdownMessageEventData.msg_id,true);
                }else{
                    GeneralManager.getHttpUtil().send(MessageAPI.MESSAGE_CREATE.setBody(
                            Map.of(
                                    "type", KMarkdownMessage.TYPE,
                                    "target_id", kMarkdownMessageEventData.target_id,
                                    "quote",kMarkdownMessageEventData.msg_id,
                                    "content", "使用方法:\n`"+COMMAND+" <歌曲名称> <作者>`"
                            )
                    ));
                }
            }
        }
    }
}
