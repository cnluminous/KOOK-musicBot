package com.cnluminous.musicbot.async.asyncs;

import cn.enaium.kook.spring.boot.starter.api.ChannelAPI;
import cn.enaium.kook.spring.boot.starter.api.ChannelUserAPI;
import cn.enaium.kook.spring.boot.starter.api.MessageAPI;
import cn.enaium.kook.spring.boot.starter.api.UserAPI;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message.CardMessage;
import cn.enaium.kook.spring.boot.starter.util.HttpUtil;
import com.cnluminous.musicbot.GeneralManager;
import com.cnluminous.musicbot.entity.MusicInfo;
import com.cnluminous.musicbot.entity.UserVoiceChannelEntity;
import com.cnluminous.musicbot.kookvoice.Connector;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Header;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channel;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * 播放音乐所使用服务
 * @author CNLuminous
 */
@Slf4j
public class Play {
    public void play(MusicInfo info, String token){
        HttpUtil httpUtil = GeneralManager.getHttpUtil();
        String id = info.getId();
        try {
            if ( GeneralManager.getConnector()!=null){
                httpUtil.send(MessageAPI.MESSAGE_CREATE.setBody(
                        Map.of(
                                "type", "9",
                                "target_id", GeneralManager.textChannel,
                                "content", "当前已有音乐正在播放,此提示不应该出现,如若出现请联系管理员"
                        )
                ));
                return;
            }
            String path = "https://music.163.com/song/media/outer/url?id=" + id;
            URL url = new URL(path);
            URLConnection con = url.openConnection();
            URL urlL = new URL(con.getHeaderField("Location"));
            URLConnection conL = urlL.openConnection();
            int b = conL.getContentLength();
            BufferedInputStream bis = new BufferedInputStream(conL.getInputStream());
            Bitstream bt = new Bitstream(bis);
            Header h = bt.readFrame();
            int time = (int) h.total_ms(b);
            Date date = new Date();
            String startTime = date.getTime()+"";
            String endTime = date.getTime()+time+"";
            GeneralManager.setConnector(new Connector(GeneralManager.voiceChannel, token));
            Future<String> future = GeneralManager.getConnector().connect(null);
            log.info("推流地址:{}", future.get());
            String ffmpegPath = "D:/ffmpeg/bin/";
            String command = ffmpegPath;
            command += "ffmpeg -re";
            command += " -i " + path;
            command += " -map 0:a:0 -acodec libopus -ab 128k -f tee [select=a:f=rtp:ssrc=1357:payload_type=100]" + future.get();
            Process process = Runtime.getRuntime().exec(command);
            // 输出ffmpeg推流日志
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line = "";
            GeneralManager.getAsyncService().setNowPlay(info,startTime,endTime);
            GeneralManager.getAsyncService().nowPlay();
            GeneralManager.getAsyncService().list();
            while (br.readLine() != null) {
                if (GeneralManager.getCutMusic()){
                    log.info("音频推流结束");
                    GeneralManager.getAsyncService().setNowPlay(null,null,null);
                    GeneralManager.getConnector().disconnect();
                    GeneralManager.setConnector(null);
                    process.destroy();
                    GeneralManager.setCutMusic(false);
                    httpUtil.send(MessageAPI.MESSAGE_CREATE.setBody(
                            Map.of(
                                    "type", CardMessage.TYPE,
                                    "target_id", GeneralManager.textChannel,
                                    "content", "[{\"type\":\"card\",\"theme\":\"secondary\",\"size\":\"lg\",\"modules\":[{\"type\":\"divider\"},{\"type\":\"header\",\"text\":{\"type\":\"plain-text\",\"content\":\":musical_note: "+info.getName()+"播放中止,正在切歌\"}},{\"type\":\"divider\"}]}]"
                            )
                    ));
                    return;
                }
            }
            GeneralManager.getConnector().disconnect();
            GeneralManager.setConnector(null);
            GeneralManager.getAsyncService().setNowPlay(null,null,null);
            log.info("音频推流完成");
            httpUtil.send(MessageAPI.MESSAGE_CREATE.setBody(
                    Map.of(
                            "type", CardMessage.TYPE,
                            "target_id", GeneralManager.textChannel,
                            "content", "[{\"type\":\"card\",\"theme\":\"secondary\",\"size\":\"lg\",\"modules\":[{\"type\":\"divider\"},{\"type\":\"header\",\"text\":{\"type\":\"plain-text\",\"content\":\":musical_note: "+info.getName()+"播放完成\"}},{\"type\":\"divider\"}]}]"
                    )
            ));
        }catch (Exception e){
            log.error("音频推流异常");
            GeneralManager.setConnector(null);
            httpUtil.send(MessageAPI.MESSAGE_CREATE.setBody(
                    Map.of(
                            "type", "9",
                            "target_id", GeneralManager.textChannel,
                            "content", id+"播放时出现异常"
                    )
            ));
            e.printStackTrace();
        }
    }
}
