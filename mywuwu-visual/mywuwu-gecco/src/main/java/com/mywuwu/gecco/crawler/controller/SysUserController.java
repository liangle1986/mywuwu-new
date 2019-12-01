package com.mywuwu.gecco.crawler.controller;


import com.mywuwu.gecco.crawler.entity.SysUser;
import com.mywuwu.gecco.crawler.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 用户管理控制层
 * @author wisdom
 * @since 2019-04-17
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

//    /**
//     * 用户页面
//     * @return
//     */
//    @GetMapping("/index")
//    public ModelAndView toPage(){
//        ModelAndView view = new ModelAndView("user/user-list");
//        return view;
//    }
//
//    /**
//     * 用户列表
//     * @return
//     */
//    @GetMapping("/userList")
//    public PageResult userList(@RequestParam Map map){
//        PageResult pageResult = sysUserService.userList(map);
//        return pageResult;
//    }
//
//    /**
//     * 用户添加页面
//     * @return
//     */
//    @GetMapping("/add")
//    public ModelAndView add(){
//        ModelAndView view = new ModelAndView("user/user-edit");
//        view.addObject("sysUser",new SysUser());
//        return view;
//    }
//
//    /**
//     * 用户修改页面
//     * @return
//     */
//    @GetMapping("/update/{id}")
//    public ModelAndView update(@PathVariable long id){
//        ModelAndView view = new ModelAndView("user/user-edit");
//        SysUser sysUser = sysUserService.selectById(id);
//        view.addObject("sysUser",sysUser);
//        return view;
//    }
//
//    /**
//     * 用户保存
//     * @return
//     */
//    @PostMapping("/saveOrUpdate")
//    public Result saveOrUpdate(SysUser sysUser){
//        return sysUserService.saveOrUpdate(sysUser);
//    }
//
//    /**
//     * 用户删除
//     * @return
//     */
//    @GetMapping("/delete/{id}")
//    public Result delete(@PathVariable long id){
//        sysUserService.deleteById(id);
//        return Result.success("删除成功");
//    }删除成功
}
