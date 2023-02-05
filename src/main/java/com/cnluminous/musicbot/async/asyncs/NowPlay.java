package com.cnluminous.musicbot.async.asyncs;

import cn.enaium.kook.spring.boot.starter.api.MessageAPI;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message.CardMessage;
import cn.enaium.kook.spring.boot.starter.util.HttpUtil;
import com.cnluminous.musicbot.GeneralManager;
import com.cnluminous.musicbot.entity.MusicInfo;

import java.util.Map;

/**
 * @author CNLuminous
 */
public class NowPlay {
    private MusicInfo info;
    private String startTime;
    private String endTime;
    public void nowPlay(){
        HttpUtil httpUtil = GeneralManager.getHttpUtil();
        if (info==null){
            return;
        }
        httpUtil.send(MessageAPI.MESSAGE_CREATE.setBody(
                Map.of(
                        "type", CardMessage.TYPE,
                        "target_id", GeneralManager.textChannel,
                        "content", "[{\"type\":\"card\",\"theme\":\"secondary\",\"size\":\"lg\",\"modules\":[{\"type\":\"header\",\"text\":{\"type\":\"plain-text\",\"content\":\":musical_note: 正在播放 "+info.getName()+"\"}},{\"type\":\"section\",\"text\":{\"type\":\"kmarkdown\",\"content\":\""+info.getName()+" - "+info.getAuthor()+"\\n专辑: "+info.getAlbum()+"\\nID:"+info.getId()+"\\n添加者: (met)"+info.getAddUserId()+"(met)\"},\"mode\":\"right\",\"accessory\":{\"type\":\"image\",\"src\":\"http://p1.music.126.net/tBTNafgjNnTL1KlZMt7lVA==/18885211718935735.jpg\",\"size\":\"sm\"}},{\"type\":\"countdown\",\"mode\":\"second\",\"startTime\":"+startTime+",\"endTime\":"+endTime+"}]}]"
                )
        ));
    }

    public MusicInfo getMusicInfo() {
        return info;
    }

    public void setMusicInfo(MusicInfo musicInfo) {
        this.info = musicInfo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
