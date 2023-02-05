package com.cnluminous.musicbot.async;

import com.cnluminous.musicbot.GeneralManager;
import com.cnluminous.musicbot.async.asyncs.*;
import com.cnluminous.musicbot.entity.MusicInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author CNLuminous
 */
@Service
@Slf4j
public class AsyncService {
    private final Play play = new Play();
    private final NowPlay nowPlay = new NowPlay();
    private final Search search = new Search();
    private final Add add = new Add();
    private final List list = new List();
    @Async("asyncExecutor")
    public void play(){
        MusicInfo musicInfo = GeneralManager.getMusicList().get(0);
        GeneralManager.getMusicList().remove(musicInfo);
        play.play(musicInfo,GeneralManager.token);
    }
    @Async("asyncExecutor")
    public void add(String id,String userid,String msgId) {
        add.add(id,userid,msgId);
    }

    @Async("asyncExecutor")
    public void search(String s,String userid,String quote){
        search.search(s,quote,userid,false);
    }
    @Async("asyncExecutor")
    public void search(String s, String quote, String userid, boolean add){
        search.search(s, quote, userid,add);
    }

    @Async("asyncExecutor")
    public void list(){
        list.list();
    }
    @Async("asyncExecutor")
    public void setNowPlay(MusicInfo info, String start, String end){
        nowPlay.setMusicInfo(info);
        nowPlay.setStartTime(start);
        nowPlay.setEndTime(end);
    }
    @Async("asyncExecutor")
    public void nowPlay(){
        nowPlay.nowPlay();
    }

    public boolean nowPlayStatus() {
        return nowPlay.getMusicInfo()!=null;
    }
}
