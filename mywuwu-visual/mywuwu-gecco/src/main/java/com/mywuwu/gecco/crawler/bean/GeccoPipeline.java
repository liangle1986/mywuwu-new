package com.mywuwu.gecco.crawler.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spider.SpiderBean;
import com.mywuwu.gecco.crawler.entity.GeccoData;
import com.mywuwu.gecco.crawler.service.impl.GeccoDataServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @Description: 爬取结果
 * @Author: wisdomwang
 * @Date: 2019-04-12 12:03
 **/
@PipelineName("geccoPipeline")
@Slf4j
public class GeccoPipeline implements Pipeline<SpiderBean> {

    @Autowired
    private GeccoDataServiceImpl geccoDataServiceImpl;

    @Override
    public void process(SpiderBean bean){
        log.info("数据=============="+ JSON.toJSONString(bean));
        JSONObject geccoDataJson = JSONObject.parseObject(JSON.toJSONString(bean));
        //获取爬取页面传的参数
        HttpGetRequest request = HttpGetRequest.fromJson(geccoDataJson.getJSONObject("request"));
        String classId = request.getParameter("classId");
        String keyword = request.getParameter("keyword");
        GeccoData geccoData = JSON.toJavaObject(geccoDataJson,GeccoData.class);
        if(geccoData==null){
            geccoData.setClassId(Long.valueOf(classId));
            //是否有关键字
            if(!"".equals(keyword)){
                if(-1!=geccoData.getTitle().indexOf(keyword) || -1!=geccoData.getContent().indexOf(keyword)){
                    //保存到数据库
//                    geccoDataServiceImpl.insert(geccoData);
//                    //保存到ES
//                    geccoDataServiceImpl.saveGecco(geccoData);
                }
            }else{
//                //保存到数据库
//                geccoDataServiceImpl.insert(geccoData);
//                //保存到ES
//                geccoDataServiceImpl.saveGecco(geccoData);
            }
        }

    }
}
