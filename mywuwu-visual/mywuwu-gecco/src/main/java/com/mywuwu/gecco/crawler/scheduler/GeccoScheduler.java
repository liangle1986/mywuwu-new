package com.mywuwu.gecco.crawler.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.mywuwu.gecco.crawler.bean.DynamicGeccoBean;
import com.mywuwu.gecco.crawler.entity.GeccoData;
import com.mywuwu.gecco.crawler.entity.GeccoRule;
import com.mywuwu.gecco.crawler.service.IGeccoDataService;
import com.mywuwu.gecco.crawler.service.IGeccoRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * @Description: 定时爬取
 * @Author: wisdomwang
 * @Date: 2019-06-03 16:47
 **/
@Component
public class GeccoScheduler{
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private IGeccoRuleService geccoRuleService;

    @Autowired
    private DynamicGeccoBean dynamicGeccoBean;

    @Scheduled(cron = "0 0 0/8 * * ?")
    public void testTasks() {
//        List<GeccoRule> geccoRuleList = geccoRuleService.selectList(null);
//        for (GeccoRule geccoRule : geccoRuleList) {
//            dynamicGeccoBean.dynamicBatchGecco(geccoRule,"");
//        }
        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
    }

}
