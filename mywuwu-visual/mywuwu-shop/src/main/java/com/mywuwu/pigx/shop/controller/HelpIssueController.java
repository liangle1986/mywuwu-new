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

package com.mywuwu.pigx.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.common.log.annotation.SysLog;
import com.mywuwu.pigx.shop.entity.HelpIssue;
import com.mywuwu.pigx.shop.service.HelpIssueService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author pigx code generator
 * @date 2019-08-26 22:14:21
 */
@RestController
@AllArgsConstructor
@RequestMapping("/nideshophelpissue" )
@Api(value = "nideshophelpissue", tags = "管理")
public class HelpIssueController {

    private final HelpIssueService helpIssueService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param helpIssue
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getNideshopHelpIssuePage(Page page, HelpIssue helpIssue) {
        return R.ok(helpIssueService.page(page, Wrappers.query(helpIssue)));
    }


    /**
     * 通过id查询
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(helpIssueService.getById(id));
    }

    /**
     * 新增
     * @param helpIssue
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @SysLog("新增" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('nideshophelpissue_add')" )
    public R save(@RequestBody HelpIssue helpIssue) {
        return R.ok(helpIssueService.save(helpIssue));
    }

    /**
     * 修改
     * @param helpIssue
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('nideshophelpissue_edit')" )
    public R updateById(@RequestBody HelpIssue helpIssue) {
        return R.ok(helpIssueService.updateById(helpIssue));
    }

    /**
     * 通过id删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('nideshophelpissue_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(helpIssueService.removeById(id));
    }

}
