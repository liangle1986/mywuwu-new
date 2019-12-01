package com.mywuwu.gecco.crawler.bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.JsonPipeline;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 文章列表爬取结果处理
 * @Author: wisdomwang
 * @Date: 2019-04-12 12:03
 **/
@PipelineName("articlesPipeline")
@Slf4j
public class ArticlesPipeline extends JsonPipeline {

    @Override
    public void process(JSONObject jsonObject) {
        HttpRequest currRequest = HttpGetRequest.fromJson(jsonObject.getJSONObject("request"));
        JSONArray articles = jsonObject.getJSONArray("articles");
        String keyword = currRequest.getParameter("keyword");
        for(int i = 0; i < articles.size(); i++) {
            JSONObject article = articles.getJSONObject(i);
            JSONArray hrefs = article.getJSONArray("article");
            //子链接去重
            List<Object> collect = hrefs.stream().distinct().collect(Collectors.toList());
            for(int j = 0; j < collect.size(); j++) {
                Map map = (Map)collect.get(j);
                String url = map.get("url").toString();
                String text = map.get("text").toString();
                //关键字筛选
                if(!"".equals(keyword)){
                    if(keyword.equals(text)){
                        //DeriveSchedulerContext.into()方法是将待抓取的链接放入队列中等待进一步抓取。
                        DeriveSchedulerContext.into(currRequest.subRequest(url));
                    }
                }else{
                    DeriveSchedulerContext.into(currRequest.subRequest(url));
                }

            }
        }
    }

}
