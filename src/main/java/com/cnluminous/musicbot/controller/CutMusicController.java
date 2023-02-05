package com.cnluminous.musicbot.controller;


import cn.enaium.kook.spring.boot.starter.annotation.event.Event;
import cn.enaium.kook.spring.boot.starter.annotation.event.Register;
import cn.enaium.kook.spring.boot.starter.api.MessageAPI;
import cn.enaium.kook.spring.boot.starter.model.sign.data.EventData;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message.CardMessage;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message.KMarkdownMessage;
import com.cnluminous.musicbot.GeneralManager;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author CNLuminous
 */
@Slf4j
@Register
public class CutMusicController {
    public static final String COMMAND = "切歌";

    @Event(KMarkdownMessage.class)
    public void kMarkdownMessageEvent(EventData<KMarkdownMessage> kMarkdownMessageEventData) {
        Map<Object, Object> e = kMarkdownMessageEventData.extra.kmarkdown;
        Object rawContent = e.get("raw_content");
        if (COMMAND.equals(rawContent)){
            GeneralManager.setCutMusic(true);
            if (GeneralManager.getMusicList().size()==0){
                GeneralManager.getHttpUtil().send(MessageAPI.MESSAGE_CREATE.setBody(
                        Map.of(
                                "type", CardMessage.TYPE,
                                "target_id", GeneralManager.textChannel,
                                "content", "[{\"type\":\"card\",\"theme\":\"secondary\",\"size\":\"lg\",\"modules\":[{\"type\":\"divider\"},{\"type\":\"header\",\"text\":{\"type\":\"plain-text\",\"content\":\":musical_note: 当前队列中无歌曲可用于切换,请重新点歌\"}},{\"type\":\"divider\"}]}]"
                        )
                ));
            }
        }
    }
}
