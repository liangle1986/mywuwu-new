package com.mywuwu.gecco.crawler.controller;


import com.mywuwu.gecco.crawler.entity.GeccoDataClass;
import com.mywuwu.gecco.crawler.service.IGeccoDataClassService;
import com.mywuwu.pigx.common.core.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * <p>
 * 爬取数据分类表 前端控制器
 * </p>
 *
 * @author wisdom
 * @since 2019-05-24
 */
@RestController
@RequestMapping("/geccoDataClass")
public class GeccoDataClassController {

    @Autowired
    private IGeccoDataClassService geccoDataClassService;
    
//    /**
//     * 内容分类页面
//     * @return
//     */
//    @GetMapping("/index")
//    public ModelAndView toPage(){
//        ModelAndView view = new ModelAndView("geccoDataClass/geccoDataClass-list");
//        return view;
//    }
//
//    /**
//     * 内容分类列表
//     * @return
//     */
//    @GetMapping("/classList")
//    public R classList(@RequestParam Map map){
//        R pageResult = geccoDataClassService.classList(map);
//        return pageResult;
//    }
//
//    /**
//     * 内容分类添加页面
//     * @return
//     */
//    @GetMapping("/add")
//    public ModelAndView add(){
//        ModelAndView view = new ModelAndView("geccoDataClass/geccoDataClass-edit");
//        view.addObject("geccoDataClass",new GeccoDataClass());
//        return view;
//    }
//
//    /**
//     * 内容分类修改页面
//     * @return
//     */
//    @GetMapping("/update/{id}")
//    public ModelAndView update(@PathVariable long id){
//        ModelAndView view = new ModelAndView("geccoDataClass/geccoDataClass-edit");
//        GeccoDataClass geccoDataClass = geccoDataClassService.selectById(id);
//        view.addObject("geccoDataClass",geccoDataClass);
//        return view;
//    }
//
//    /**
//     * 内容分类保存
//     * @return
//     */
//    @PostMapping("/saveOrUpdate")
//    public Result saveOrUpdate(GeccoDataClass geccoDataClass){
//        return geccoDataClassService.saveOrUpdate(geccoDataClass);
//    }
//
//    /**
//     * 内容分类删除
//     * @return
//     */
//    @GetMapping("/delete/{id}")
//    public Result delete(@PathVariable long id){
//        geccoDataClassService.deleteById(id);
//        return Result.success("删除成功");
//    }
}
