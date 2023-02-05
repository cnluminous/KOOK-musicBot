package com.cnluminous.musicbot;

import cn.enaium.kook.spring.boot.starter.configuration.KookConfiguration;
import cn.enaium.kook.spring.boot.starter.util.HttpUtil;
import com.cnluminous.musicbot.async.AsyncService;
import com.cnluminous.musicbot.async.QueueService;
import com.cnluminous.musicbot.entity.MusicInfo;
import com.cnluminous.musicbot.kookvoice.Connector;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author CNLuminous
 */
@Service
@Slf4j
public class GeneralManager {

    private static Connector connector;
    private static HttpUtil httpUtil;
    private static AsyncService asyncService;
    private static QueueService queueService;
    private static  ArrayList<MusicInfo> musicList;
    private static Boolean cutMusic;
    private static Gson gson;
    private static KookConfiguration kookConfiguration;
    public static String voiceChannel;
    public static String textChannel;
    public static String guildId;

    public static String token;
    @PostConstruct
    public void onStart() {
        cutMusic = false;
        voiceChannel = "3655791818300988";
        textChannel = "5684096999643726";
        guildId = "5843447190838204";
        token = kookConfiguration.getToken();
        musicList = new ArrayList<>();
        log.info("正在初始化服务");
        queueService.queueService();
    }
    public static AsyncService getAsyncService() {
        return asyncService;
    }
    public static HttpUtil getHttpUtil() {
        return httpUtil;
    }
    public static Connector getConnector() {
        return connector;
    }

    public static Gson getGson() {
        return gson;
    }

    public static ArrayList<MusicInfo> getMusicList() {
        return musicList;
    }

    public static void setConnector(Connector connector) {
        GeneralManager.connector = connector;
    }

    @Autowired
    public void setHttpUtil(HttpUtil httpUtil) {
        GeneralManager.httpUtil = httpUtil;
    }
    @Autowired
    public void setAsyncService(AsyncService asyncService) {
        GeneralManager.asyncService = asyncService;
    }
    @Autowired
    public void setQueueService(QueueService queueService) {
        GeneralManager.queueService = queueService;
    }
    @Autowired
    public void setGson(Gson gson) {
        GeneralManager.gson = gson;
    }
    @Autowired
    public void setKookConfiguration(KookConfiguration kookConfiguration) {
        GeneralManager.kookConfiguration = kookConfiguration;
    }
    public static Boolean getCutMusic() {
        return cutMusic;
    }

    public static void setCutMusic(Boolean cutMusic) {
        GeneralManager.cutMusic = cutMusic;
    }
}
