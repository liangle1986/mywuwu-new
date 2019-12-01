package com.geccocrawler.gecco.crawler.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mywuwu.gecco.crawler.entity.GeccoRule;
import com.mywuwu.gecco.crawler.mapper.GeccoRuleMapper;
import com.mywuwu.gecco.crawler.service.IGeccoRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wisdom
 * @since 2019-05-22
 */
@Service
public class GeccoRuleServiceImpl extends ServiceImpl<GeccoRuleMapper, GeccoRule> implements IGeccoRuleService {
//
//    @Autowired
//    private GeccoRuleMapper geccoRuleMapper;
//    @Autowired
//    private DynamicGeccoBean dynamicGeccoBean;
//
//    @Override
//    public PageResult geccoRuleList(Map map) {
//        int page = Integer.parseInt(map.get("page").toString());
//        int limit = Integer.parseInt(map.get("limit").toString());
//        Page<GeccoRule> rulePage = new Page<>(page, limit);
//        //分页查询
//        List<Map> ruleList = geccoRuleMapper.selectPageMap(rulePage,map);
//        return PageResult.success(ruleList,rulePage.getTotal());
//    }
//
//    @Override
//    public Result saveOrUpdate(GeccoRule geccoRule) {
//        String message = "添加成功";
//        try{
//            if(geccoRule.getId()==null){
//                geccoRuleMapper.insert(geccoRule);
//            }else{
//                geccoRuleMapper.updateById(geccoRule);
//                message = "修改成功";
//            }
//            return Result.success(message);
//        }catch (RuntimeException e){
//            return Result.error("很抱歉，请稍后重试");
//        }
//    }
//
//    /**
//     * 爬取数据
//     * @param id
//     */
//    @Override
//    public Result crawlData(Long id) {
//        GeccoRule geccoRule = geccoRuleMapper.selectById(id);
//        if(geccoRule.getType()==1){
//            return dynamicGeccoBean.dynamicBatchGecco(geccoRule,"");
//        }else{
//            return dynamicGeccoBean.dynamicGecco(geccoRule,"");
//        }
//    }
//
//    /**
//     * 一键爬取
//     * @return
//     */
//    @Override
//    public Result batchCrawl(Long[] ids) {
//        List<GeccoRule> geccoRuleList = geccoRuleMapper.selectBatchIds(new ArrayList<>(Arrays.asList(ids)));
//        Result result = null;
//        try {
//            for(GeccoRule geccoRule:geccoRuleList){
//                if(geccoRule.getType()==1){
//                    result = dynamicGeccoBean.dynamicBatchGecco(geccoRule,"");
//                }else{
//                    result = dynamicGeccoBean.dynamicGecco(geccoRule,"");
//                }
//            }
//            return result;
//        }catch (RuntimeException e){
//            return Result.error("很抱歉，请稍后再试");
//        }
//    }
}
