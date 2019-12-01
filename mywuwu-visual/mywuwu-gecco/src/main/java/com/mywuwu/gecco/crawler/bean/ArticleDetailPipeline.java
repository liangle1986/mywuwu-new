package com.mywuwu.gecco.crawler.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.JsonPipeline;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.mywuwu.gecco.crawler.entity.GeccoData;
import com.mywuwu.gecco.crawler.service.impl.GeccoDataServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description: 文章明细爬取结果处理
 * @Author: wisdomwang
 * @Date: 2019-04-28 10:21
 **/
@PipelineName("articleDetailPipeline")
@Slf4j
public class ArticleDetailPipeline extends JsonPipeline {

    @Autowired
    private GeccoDataServiceImpl geccoDataServiceImpl;

    @Override
    public void process(JSONObject jsonObject) {
        log.info(jsonObject.toJSONString());
        //获取爬取页面传的参数
        HttpGetRequest request = HttpGetRequest.fromJson(jsonObject.getJSONObject("request"));
        String classId = request.getParameter("classId");
        String keyword = request.getParameter("keyword");
        GeccoData geccoData = JSON.toJavaObject(jsonObject,GeccoData.class);
        geccoData.setClassId(Long.valueOf(classId));
        //是否有关键字
        /*if(!"".equals(keyword)){
            if(-1!=geccoData.getTitle().indexOf(keyword) || -1!=geccoData.getContent().indexOf(keyword)){
                save(geccoData);
            }
        }else{*/
            save(geccoData);
        //}

    }

    /**
     * @Author wisdomwang
     * @Description  数据持久化
     * @Date 2019/5/28 15:14
     */
    private void save(GeccoData geccoData){
//        //检查数据有没有爬取过
//        EntityWrapper entityWrapper = new EntityWrapper();
//        entityWrapper.eq("title",geccoData.getTitle());
//        List<GeccoData> list = geccoDataServiceImpl.selectList(entityWrapper);
//        if(list==null || list.size()==0){
//            //保存到数据库
//            geccoDataServiceImpl.insert(geccoData);
//            //保存到ES
//            geccoDataServiceImpl.saveGecco(geccoData);
//        }
    }

}
