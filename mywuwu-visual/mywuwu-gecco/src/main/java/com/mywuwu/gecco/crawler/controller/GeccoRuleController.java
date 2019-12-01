package com.mywuwu.gecco.crawler.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.mywuwu.gecco.crawler.entity.GeccoDataClass;
import com.mywuwu.gecco.crawler.entity.GeccoRule;
import com.mywuwu.gecco.crawler.service.IGeccoDataClassService;
import com.mywuwu.gecco.crawler.service.IGeccoRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wisdom
 * @since 2019-05-22
 */
@RestController
@RequestMapping("/geccoRule")
public class GeccoRuleController {

    @Autowired
    private IGeccoRuleService geccoRuleService;
    @Autowired
    private IGeccoDataClassService geccoDataClassService;

//    /**
//     * 规则页面
//     * @return
//     */
//    @GetMapping("/index")
//    public ModelAndView toPage(){
//        ModelAndView view = new ModelAndView("geccoRule/geccoRule-list");
//        return view;
//    }
//
//    /**
//     * 规则列表
//     * @return
//     */
//    @GetMapping("/geccoRuleList")
//    public PageResult geccoRuleList(@RequestParam Map map){
//        PageResult pageResult = geccoRuleService.geccoRuleList(map);
//        return pageResult;
//    }
//
//    /**
//     * 规则添加页面
//     * @return
//     */
//    @GetMapping("/add")
//    public ModelAndView add(){
//        ModelAndView view = new ModelAndView("geccoRule/geccoRule-edit");
//        view.addObject("geccoRule",new GeccoRule());
//        List<GeccoDataClass> classList = geccoDataClassService.selectList(null);
//        if(!CollectionUtils.isEmpty(classList)){
//            JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(classList));
//            if (jsonArray.size() > 0) {
//                view.addObject("classList",jsonArray.toString());
//            }
//        }
//        return view;
//    }
//
//    /**
//     * 规则修改页面
//     * @return
//     */
//    @GetMapping("/update/{id}")
//    public ModelAndView update(@PathVariable long id){
//        ModelAndView view = new ModelAndView("geccoRule/geccoRule-edit");
//        GeccoRule geccoRule = geccoRuleService.selectById(id);
//        view.addObject("geccoRule",geccoRule);
//        List<GeccoDataClass> classList = geccoDataClassService.selectList(null);
//        if(!CollectionUtils.isEmpty(classList)){
//            JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(classList));
//            if (jsonArray.size() > 0) {
//                view.addObject("classList",jsonArray.toString());
//            }
//        }
//        return view;
//    }
//
//    /**
//     * 规则保存
//     * @return
//     */
//    @PostMapping("/saveOrUpdate")
//    public Result saveOrUpdate(GeccoRule geccoRule){
//        return geccoRuleService.saveOrUpdate(geccoRule);
//    }
//
//    /**
//     * 规则删除
//     * @return
//     */
//    @GetMapping("/delete/{id}")
//    public Result delete(@PathVariable long id){
//        geccoRuleService.deleteById(id);
//        return Result.success("删除成功");
//    }
//
//    /**
//     * @Author wisdomwang
//     * @Description 选择规则
//     * @Date 2019/5/22 14:08
//     */
//    @GetMapping("/chooseRule/{id}")
//    public Result chooseRule(@PathVariable long id){
//        GeccoRule geccoRule = geccoRuleService.selectById(id);
//        return Result.success("选择成功",geccoRule);
//    }
//
//    /**
//     * 爬取数据
//     * @param id
//     */
//    @GetMapping(value = "/crawlData/{id}")
//    public Result crawlData(@PathVariable Long id){
//        Result result = geccoRuleService.crawlData(id);
//        return result;
//    }
//
//    /**
//     * 一键爬取
//     * @return
//     */
//    @GetMapping("/batchCrawl/{ids}")
//    public Result batchCrawl(@PathVariable("ids") Long[] ids){
//        return geccoRuleService.batchCrawl(ids);
//    }
}
