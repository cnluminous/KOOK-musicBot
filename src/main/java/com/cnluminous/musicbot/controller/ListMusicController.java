package com.cnluminous.musicbot.controller;

import cn.enaium.kook.spring.boot.starter.annotation.event.Event;
import cn.enaium.kook.spring.boot.starter.annotation.event.Register;
import cn.enaium.kook.spring.boot.starter.model.sign.data.EventData;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message.KMarkdownMessage;
import com.cnluminous.musicbot.GeneralManager;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author CNLuminous
 */
@Slf4j
@Register
public class ListMusicController {
    public static final String COMMAND = "列表";

    @Event(KMarkdownMessage.class)
    public void kMarkdownMessageEvent(EventData<KMarkdownMessage> kMarkdownMessageEventData) {
        Map<Object, Object> e = kMarkdownMessageEventData.extra.kmarkdown;
        Object rawContent = e.get("raw_content");
            if (COMMAND.equals(rawContent)){
                GeneralManager.getAsyncService().nowPlay();
                GeneralManager.getAsyncService().list();
        }
    }
}
