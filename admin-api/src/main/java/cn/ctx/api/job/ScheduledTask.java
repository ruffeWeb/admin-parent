package cn.ctx.api.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
* @ClassName: ScheduledTask.java
* @Description: TODO(定时任务) 
* @author gyu
* @date 2016年11月3日 上午9:19:17
 */
@Component
public class ScheduledTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Integer count0 = 1;
    private Integer count1 = 1;
    private Integer count2 = 1;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() throws InterruptedException {
        System.out.println(String.format("---第%s次执行，当前时间为：%s", count0++, dateFormat.format(new Date())));
    }

    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTimeAfterSleep() throws InterruptedException {
        System.out.println(String.format("===第%s次执行，当前时间为：%s", count1++, dateFormat.format(new Date())));
    }

    @Scheduled(cron = "0 0 1 * * *")
    public void reportCurrentTimeCron() throws InterruptedException {
        System.out.println(String.format("+++第%s次执行，当前时间为：%s", count2++, dateFormat.format(new Date())));
    }

}