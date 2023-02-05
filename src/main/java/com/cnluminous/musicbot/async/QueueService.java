package com.cnluminous.musicbot.async;

import cn.enaium.kook.spring.boot.starter.api.MessageAPI;
import com.cnluminous.musicbot.GeneralManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 *  自动队列服务
 * @author CNLuminous
 */
@Slf4j
@Service
public class QueueService {
    @Async("asyncExecutor")
    public void queueService(){
        log.info("播放队列服务已启动");
        try{
            while (true){
                if (GeneralManager.getConnector() ==null && GeneralManager.getMusicList().size()!=0){
                    log.info("当前还有{}首歌曲待播放",GeneralManager.getMusicList().size());
                    GeneralManager.getAsyncService().play();
                    Thread.sleep(1000);
                }
            }
        }catch (Exception e){
            log.error("自动播放队列出现异常");
            GeneralManager.getHttpUtil().send(MessageAPI.MESSAGE_CREATE.setBody(
                    Map.of(
                            "type", "9",
                            "target_id", GeneralManager.textChannel,
                            "content", "自动播放队列出现异常,请联系管理员处理"
                    )
            ));
            e.printStackTrace();
        }
    }
}
