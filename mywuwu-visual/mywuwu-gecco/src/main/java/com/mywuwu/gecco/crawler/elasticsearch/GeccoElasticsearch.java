package com.mywuwu.gecco.crawler.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 爬虫ES逻辑层
 * @Author: wisdomwang
 * @Date: 2019-04-16 10:48
 **/
@Service
@Slf4j
public class GeccoElasticsearch implements InitializingBean {

//    @Resource
//    private RestHighLevelClient client;
//
//    /**
//     * ES插入
//     * @return
//     */
//    public void saveGecco(GeccoData geccoData){
//        IndexRequest request = new IndexRequest("gecco","gecco",geccoData.getId().toString());
//        request.source(JSON.toJSONString(geccoData),XContentType.JSON);
//        try {
//            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
//            log.debug(indexResponse.toString());
//        } catch (IOException e) {
//            throw new BusinessException("系统异常，请重试");
//        }
//    }
//
//    /**
//     * 删除
//     * @return
//     */
//    public void deleteGecco() {
//        DeleteRequest deleteRequest = new DeleteRequest("gecco","gecco","34");
//        try {
//            client.delete(deleteRequest,RequestOptions.DEFAULT);
//        } catch (IOException e) {
//            throw new BusinessException("系统异常，请重试");
//        }
//    }
//
//    /**
//     * ES查询
//     * @return
//     */
//    public Object searchGecco() {
//        SearchRequest searchRequest = new SearchRequest();
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchQuery("content","新闻"));
//        searchRequest.source(searchSourceBuilder);
//        List list = new ArrayList();
//        try {
//            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
//            SearchHits hits = searchResponse.getHits();
//            for (SearchHit hit : hits) {
//                String source = hit.getSourceAsString();
//                list.add(source);
//            }
//        } catch (IOException e) {
//            return null;
//        }
//        return list;
//    }
//
//
    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
