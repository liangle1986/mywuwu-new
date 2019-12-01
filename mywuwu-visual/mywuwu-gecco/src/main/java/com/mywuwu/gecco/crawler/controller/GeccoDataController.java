package com.mywuwu.gecco.crawler.controller;


import com.mywuwu.gecco.crawler.bean.DynamicGeccoBean;
import com.mywuwu.gecco.crawler.service.IGeccoDataClassService;
import com.mywuwu.gecco.crawler.service.IGeccoDataService;
import com.mywuwu.gecco.crawler.service.IGeccoRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 爬取的文章数据 前端控制器
 * </p>
 *
 * @author wisdom
 * @since 2019-04-15
 */
@RestController
@RequestMapping("/geccoData")
public class GeccoDataController {

    @Autowired
    private IGeccoDataService geccoDataService;

    @Resource
    private DynamicGeccoBean dynamicGeccoBean;

    @Autowired
    private IGeccoRuleService geccoRuleService;

    @Autowired
    private IGeccoDataClassService geccoDataClassService;

//    /**
//     * 爬取数据页面
//     * @return
//     */
//    @GetMapping(value = "/geccoPage")
//    public ModelAndView toPage(){
//        ModelAndView view = new ModelAndView("geccoData/geccoPage");
//        EntityWrapper<GeccoRule> wapper = new EntityWrapper<>();
//        wapper.eq("type",1);
//        //层级规则
//        List<GeccoRule> ruleList = geccoRuleService.selectList(wapper);
//        view.addObject("ruleList",ruleList);
//        //单页规则
//        wapper = new EntityWrapper<>();
//        wapper.eq("type",0);
//        List<GeccoRule> singleRuleList = geccoRuleService.selectList(wapper);
//        view.addObject("singleRuleList",singleRuleList);
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
//     * 增加
//     * @param geccoRule
//     */
//    @PostMapping(value = "/crawlData")
//    public Result crawlData(GeccoRule geccoRule,String keyword){
//        Result result = dynamicGeccoBean.dynamicGecco(geccoRule,keyword);
//        return result;
//    }
//
//    /**
//     * 数据管理页面
//     * @return
//     */
//    @GetMapping(value = "/index")
//    public ModelAndView index(){
//        ModelAndView view = new ModelAndView("geccoData/geccoData-list");
//        return view;
//    }
//
//
//    /**
//     * 数据管理列表  ES查询
//     * @return
//     */
//    @GetMapping(value = "/geccoDataList")
//    public PageResult geccoDataList(@RequestParam Map map){
//        PageResult pageResult = geccoDataService.geccoDbDataList(map);
//        return pageResult;
//    }
//
//
//    /**
//     * ES删除
//     * @return
//     */
//    /*@GetMapping(value = "/delete")
//    public void deleteRequest(){
//        geccoDataService.deleteGecco();
//    }*/
//
//    /**
//     * 根据ID从ES查询
//     */
//    @GetMapping(value = "/preview/{id}")
//    public ModelAndView preview(@PathVariable Long id){
//        ModelAndView view = new ModelAndView("geccoData/geccoData-detail");
//        GeccoData geccoData = geccoDataService.selectDbById(id);
//        view.addObject("geccoData",geccoData);
//        return view;
//    }
//
//    /**
//     * 批量增加
//     * @param geccoRule
//     */
//    @PostMapping(value = "/crawlBatchData")
//    public Result crawlBatchData(GeccoRule geccoRule,String keyword){
//        Result result = dynamicGeccoBean.dynamicBatchGecco(geccoRule,keyword);
//        return result;
//    }
//
//    /**
//     * 文章删除
//     * @return
//     */
//    @GetMapping("/delete/{ids}")
//    public Result delete(@PathVariable("ids") Long[] ids){
//        geccoDataService.deleteBatchIds(new ArrayList<>(Arrays.asList(ids)));
//        return Result.success("删除成功");
//    }
//
//    /**
//     * 数据编辑页面
//     * @return
//     */
//    @GetMapping(value = "/update/{id}")
//    public ModelAndView update(@PathVariable Long id){
//        ModelAndView view = new ModelAndView("geccoData/geccoData-edit");
//        GeccoData geccoData = geccoDataService.selectById(id);
//        view.addObject("geccoData",geccoData);
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
//     * 内容保存
//     * @return
//     */
//    @PostMapping("/update")
//    public Result update(GeccoData geccoData){
//        geccoDataService.updateById(geccoData);
//        return Result.success("修改成功");
//    }
}
