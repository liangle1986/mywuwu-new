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
import com.mywuwu.pigx.shop.entity.Keywords;
import com.mywuwu.pigx.shop.service.KeywordsService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 热闹关键词表
 *
 * @author pigx code generator
 * @date 2019-08-26 22:22:28
 */
@RestController
@AllArgsConstructor
@RequestMapping("/nideshopkeywords" )
@Api(value = "nideshopkeywords", tags = "热闹关键词表管理")
public class KeywordsController {

    private final KeywordsService keywordsService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param keywords 热闹关键词表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getNideshopKeywordsPage(Page page, Keywords keywords) {
        return R.ok(keywordsService.page(page, Wrappers.query(keywords)));
    }


    /**
     * 通过id查询热闹关键词表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(keywordsService.getById(id));
    }

    /**
     * 新增热闹关键词表
     * @param keywords 热闹关键词表
     * @return R
     */
    @ApiOperation(value = "新增热闹关键词表", notes = "新增热闹关键词表")
    @SysLog("新增热闹关键词表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('nideshopkeywords_add')" )
    public R save(@RequestBody Keywords keywords) {
        return R.ok(keywordsService.save(keywords));
    }

    /**
     * 修改热闹关键词表
     * @param keywords 热闹关键词表
     * @return R
     */
    @ApiOperation(value = "修改热闹关键词表", notes = "修改热闹关键词表")
    @SysLog("修改热闹关键词表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('nideshopkeywords_edit')" )
    public R updateById(@RequestBody Keywords keywords) {
        return R.ok(keywordsService.updateById(keywords));
    }

    /**
     * 通过id删除热闹关键词表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除热闹关键词表", notes = "通过id删除热闹关键词表")
    @SysLog("通过id删除热闹关键词表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('nideshopkeywords_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(keywordsService.removeById(id));
    }

}
