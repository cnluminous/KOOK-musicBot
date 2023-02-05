package com.cnluminous.musicbot.async.asyncs;

import cn.enaium.kook.spring.boot.starter.api.MessageAPI;
import cn.enaium.kook.spring.boot.starter.util.HttpUtil;
import com.cnluminous.musicbot.GeneralManager;
import com.cnluminous.musicbot.entity.CloudMusicSearchEntity;
import com.cnluminous.musicbot.entity.MusicInfo;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Map;

/**
 * @author CNLuminous
 */
@Slf4j
public class Search {
    public void search(String s,String userid, String quote, boolean add) {
        HttpUtil httpUtil = GeneralManager.getHttpUtil();
        String url = "http://cloud-music.pl-fe.cn/search?keywords=";
        String path = s.replace(" ", "%20");
        log.info("正在搜索{}", url+path);
        String result = "搜索失败";
        CloudMusicSearchEntity cloudMusicSearchEntity;
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder().version(HttpClient.Version.HTTP_1_1).uri(URI.create(url+path)).timeout(Duration.ofMillis(5000L));
            HttpRequest request = builder.method("GET", HttpRequest.BodyPublishers.noBody()).build();
            result = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString()).body();
            cloudMusicSearchEntity = new Gson().fromJson(result, CloudMusicSearchEntity.class);
        }catch (Exception e){
            httpUtil.send(MessageAPI.MESSAGE_CREATE.setBody(
                    Map.of(
                            "type", "9",
                            "target_id", GeneralManager.textChannel,
                            "quote",quote,
                            "content", "搜索时发生错误,请稍后再试"
                    )
            ));
            e.printStackTrace();
            log.error(result);
            return;
        }

        if (cloudMusicSearchEntity.getResult().getSongs()==null){
            String res = httpUtil.send(MessageAPI.MESSAGE_CREATE.setBody(
                    Map.of(
                            "type", "9",
                            "target_id", GeneralManager.textChannel,
                            "quote",quote,
                            "content", "没有找到【"+s+"】相关歌曲"
                    )
            ));
            System.out.println(res);
            return;
        }
        int count = cloudMusicSearchEntity.getResult().getSongs().size();
        if (count>5){
            count = 5;
        }

        StringBuilder builder = new StringBuilder();
        ArrayList<MusicInfo> musicInfos = new ArrayList<>();
        for (int i = 0;i<count;i++){
            CloudMusicSearchEntity.ResultDTO.SongsDTO song = cloudMusicSearchEntity.getResult().getSongs().get(i);
            musicInfos.add(new MusicInfo(song.getName(),song.getArtists().get(0).getName(),song.getAlbum().getName(),song.getId(),null));
            if (add){
                GeneralManager.getAsyncService().add(Base64.getEncoder().encodeToString(GeneralManager.getGson().toJson(musicInfos.get(0)).getBytes()),userid,quote);
                return;
            }
            String base = Base64.getEncoder().encodeToString(GeneralManager.getGson().toJson(musicInfos.get(i)).getBytes(StandardCharsets.UTF_8));
            builder.append(",{\"type\":\"section\",\"text\":{\"type\":\"plain-text\",\"content\":\"(").append(i + 1).append(") ").append(song.getName()).append(" - ").append(song.getArtists().get(0).getName()).append("\\n专辑: ").append(song.getAlbum().getName()).append(" ID:").append(song.getId()).append("\"},\"mode\":\"right\",\"accessory\":{\"type\":\"button\",\"theme\":\"primary\",\"value\":\"").append(base).append("\",\"click\":\"return-val\",\"text\":{\"type\":\"plain-text\",\"content\":\"点歌\"}}},{\"type\":\"divider\"}");
        }
        httpUtil.send(MessageAPI.MESSAGE_CREATE.setBody(
                        Map.of(
                                "type", "10",
                                "target_id", GeneralManager.textChannel,
                                "quote",quote,
                                "content", "[{\"type\":\"card\",\"theme\":\"secondary\",\"size\":\"lg\",\"modules\":[{\"type\":\"header\",\"text\":{\"type\":\"plain-text\",\"content\":\""+s+" 搜索结果\"}},{\"type\":\"divider\"}"+builder+",{\"type\":\"context\",\"elements\":[{\"type\":\"plain-text\",\"content\":\"搜索结果来自网易云音乐\"},{\"type\":\"image\",\"src\":\"http://p1.music.126.net/tBTNafgjNnTL1KlZMt7lVA==/18885211718935735.jpg\"}]}]}]"
                        )
                ));
    }
}
