package com.cnluminous.musicbot.async.asyncs;

import cn.enaium.kook.spring.boot.starter.api.MessageAPI;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message.CardMessage;
import com.cnluminous.musicbot.GeneralManager;
import com.cnluminous.musicbot.entity.MusicInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author CNLuminous
 */
@Slf4j
public class List {
    public void list() {
        StringBuilder builder = new StringBuilder();
        int i =0;
        for (MusicInfo musicInfo : GeneralManager.getMusicList()){
            builder.append(",{\"type\":\"section\",\"text\":{\"type\":\"kmarkdown\",\"content\":\"(").append(++i).append(")").append(musicInfo.getName()).append(" - ").append(musicInfo.getAuthor()).append(" - 歌曲ID:").append(musicInfo.getId()).append("\\n添加者:(met)").append(musicInfo.getAddUserId()).append("(met)\"}},{\"type\":\"divider\"}");
        }
        GeneralManager.getHttpUtil().send(MessageAPI.MESSAGE_CREATE.setBody(
                Map.of(
                        "type", CardMessage.TYPE,
                        "target_id", GeneralManager.textChannel,
                        "content", "[{\"type\":\"card\",\"theme\":\"secondary\",\"size\":\"lg\",\"modules\":[{\"type\":\"header\",\"text\":{\"type\":\"plain-text\",\"content\":\":musical_note: 当前待播放列表 共"+GeneralManager.getMusicList().size()+"首\"}},{\"type\":\"divider\"}"+builder+"]}]"
                )
        ));
    }
}
