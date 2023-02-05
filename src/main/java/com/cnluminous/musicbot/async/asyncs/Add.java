package com.cnluminous.musicbot.async.asyncs;

import cn.enaium.kook.spring.boot.starter.api.MessageAPI;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message.CardMessage;
import cn.enaium.kook.spring.boot.starter.util.HttpUtil;
import com.cnluminous.musicbot.GeneralManager;
import com.cnluminous.musicbot.async.AsyncService;
import com.cnluminous.musicbot.entity.MusicInfo;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

/**
 * @author CNLuminous
 */
@Slf4j
public class Add {
    public void add(String info,String userid,String msgId){
        HttpUtil httpUtil = GeneralManager.getHttpUtil();
        MusicInfo musicInfo =GeneralManager.getGson().fromJson(new String(Base64.getDecoder().decode(info), StandardCharsets.UTF_8), MusicInfo.class);
        musicInfo.setAddUserId(userid);
        log.info("添加至播放列表 {}",musicInfo.getName());
        httpUtil.send(MessageAPI.MESSAGE_CREATE.setBody(
                Map.of(
                        "type", CardMessage.TYPE,
                        "target_id", GeneralManager.textChannel,
                        "quote",msgId,
                        "content", "[{\"type\":\"card\",\"theme\":\"secondary\",\"size\":\"lg\",\"modules\":[{\"type\":\"header\",\"text\":{\"type\":\"plain-text\",\"content\":\":musical_note:将 "+musicInfo.getName()+" 添加至播放列表\"}},{\"type\":\"section\",\"text\":{\"type\":\"kmarkdown\",\"content\":\""+musicInfo.getName()+" - "+musicInfo.getAuthor()+"\\n专辑: "+musicInfo.getAlbum()+"\\nID:"+musicInfo.getId()+"\\n添加者: (met)"+userid+"(met)\"},\"mode\":\"right\",\"accessory\":{\"type\":\"image\",\"src\":\"http://p1.music.126.net/tBTNafgjNnTL1KlZMt7lVA==/18885211718935735.jpg\",\"size\":\"sm\"}}]}]"
                )
        ));

        GeneralManager.getMusicList().add(musicInfo);
    }
}
