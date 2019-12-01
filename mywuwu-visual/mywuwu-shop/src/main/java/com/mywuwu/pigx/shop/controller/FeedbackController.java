/*
 *    Copyright (c) 2018-2025, lianglele All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the ywuwu.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lianglele (liangle1986@126.com)
 */

package com.mywuwu.pigx.shop.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.common.log.annotation.SysLog;
import com.mywuwu.pigx.shop.entity.Feedback;
import com.mywuwu.pigx.shop.service.FeedbackService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author pigx code generator
 * @date 2019-08-26 22:23:28
 */
@RestController
@AllArgsConstructor
@RequestMapping("/nideshopfeedback" )
@Api(value = "nideshopfeedback", tags = "管理")
public class FeedbackController {

    private final FeedbackService feedbackService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param feedback
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getNideshopFeedbackPage(Page page, Feedback feedback) {
        return R.ok(feedbackService.page(page, Wrappers.query(feedback)));
    }


    /**
     * 通过id查询
     * @param msgId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{msgId}" )
    public R getById(@PathVariable("msgId" ) Integer msgId) {
        return R.ok(feedbackService.getById(msgId));
    }

    /**
     * 新增
     * @param feedback
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @SysLog("新增" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('nideshopfeedback_add')" )
    public R save(@RequestBody Feedback feedback) {
        return R.ok(feedbackService.save(feedback));
    }

    /**
     * 修改
     * @param feedback
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('nideshopfeedback_edit')" )
    public R updateById(@RequestBody Feedback feedback) {
        return R.ok(feedbackService.updateById(feedback));
    }

    /**
     * 通过id删除
     * @param msgId id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除" )
    @DeleteMapping("/{msgId}" )
    @PreAuthorize("@pms.hasPermission('nideshopfeedback_del')" )
    public R removeById(@PathVariable Integer msgId) {
        return R.ok(feedbackService.removeById(msgId));
    }

}
