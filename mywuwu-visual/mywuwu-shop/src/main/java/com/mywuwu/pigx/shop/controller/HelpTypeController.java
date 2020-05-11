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
import com.mywuwu.pigx.shop.entity.HelpType;
import com.mywuwu.pigx.shop.service.HelpTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author lianglele
 * @date 2019-08-26 22:21:15
 */
@RestController
@AllArgsConstructor
@RequestMapping("/nideshophelptype" )
@Api(value = "nideshophelptype", tags = "管理")
public class HelpTypeController {

    private final HelpTypeService helpTypeService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param helpType
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getNideshopHelpTypePage(Page page, HelpType helpType) {
        return R.ok(helpTypeService.page(page, Wrappers.query(helpType)));
    }


    /**
     * 通过id查询
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(helpTypeService.getById(id));
    }

    /**
     * 新增
     * @param helpType
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @SysLog("新增" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('nideshophelptype_add')" )
    public R save(@RequestBody HelpType helpType) {
        return R.ok(helpTypeService.save(helpType));
    }

    /**
     * 修改
     * @param helpType
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('nideshophelptype_edit')" )
    public R updateById(@RequestBody HelpType helpType) {
        return R.ok(helpTypeService.updateById(helpType));
    }

    /**
     * 通过id删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('nideshophelptype_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(helpTypeService.removeById(id));
    }

}
