package com.cnluminous.musicbot.controller;

import cn.enaium.kook.spring.boot.starter.annotation.event.Event;
import cn.enaium.kook.spring.boot.starter.annotation.event.Register;
import cn.enaium.kook.spring.boot.starter.api.MessageAPI;
import cn.enaium.kook.spring.boot.starter.model.sign.data.EventData;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message.KMarkdownMessage;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.user.MessageBtnClickUser;
import com.cnluminous.musicbot.GeneralManager;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 搜索歌曲功能
 * @author CNLuminous
 */
@Slf4j
@Register
public class SearchMusicController {
    public static final String COMMAND = "搜索";
    @Event(KMarkdownMessage.class)
    public void kMarkdownMessageEvent(EventData<KMarkdownMessage> kMarkdownMessageEventData) {
        Map<Object, Object> e = kMarkdownMessageEventData.extra.kmarkdown;
        Object rawContent = e.get("raw_content");
        String[] content = rawContent.toString().split(" ");
        if (content.length >= 1) {
            if (COMMAND.equals(content[0])){
                if (content.length!=1){
                    GeneralManager.getAsyncService().search(rawContent.toString().substring(3),kMarkdownMessageEventData.msg_id,kMarkdownMessageEventData.author_id);
                }else{
                    GeneralManager.getHttpUtil().send(MessageAPI.MESSAGE_CREATE.setBody(
                            Map.of(
                                    "type", KMarkdownMessage.TYPE,
                                    "target_id", GeneralManager.textChannel,
                                    "quote",kMarkdownMessageEventData.msg_id,
                                    "content", "使用方法:\n`"+COMMAND+" <歌曲名称> <作者>`"
                            )
                    ));
                }
            }
        }
    }

    //卡片消息点歌功能
    @Event(MessageBtnClickUser.class)
    public void messageBtnClickEvent(EventData<MessageBtnClickUser> messageBtnClickUserEventData) {
        String id = messageBtnClickUserEventData.extra.body.get("value").toString();
        String userId = messageBtnClickUserEventData.extra.body.get("user_id").toString();
        String msgId = messageBtnClickUserEventData.extra.body.get("msg_id").toString();
        GeneralManager.getAsyncService().add(id,userId,msgId);
    }
}
