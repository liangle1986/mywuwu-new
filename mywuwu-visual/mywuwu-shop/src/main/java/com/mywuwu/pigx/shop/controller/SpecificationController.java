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
import com.mywuwu.pigx.shop.entity.Specification;
import com.mywuwu.pigx.shop.service.SpecificationService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 规格表
 *
 * @author lianglele
 * @date 2019-08-26 22:21:25
 */
@RestController
@AllArgsConstructor
@RequestMapping("/nideshopspecification" )
@Api(value = "nideshopspecification", tags = "规格表管理")
public class SpecificationController {

    private final SpecificationService specificationService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param specification 规格表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getNideshopSpecificationPage(Page page, Specification specification) {
        return R.ok(specificationService.page(page, Wrappers.query(specification)));
    }


    /**
     * 通过id查询规格表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(specificationService.getById(id));
    }

    /**
     * 新增规格表
     * @param specification 规格表
     * @return R
     */
    @ApiOperation(value = "新增规格表", notes = "新增规格表")
    @SysLog("新增规格表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('nideshopspecification_add')" )
    public R save(@RequestBody Specification specification) {
        return R.ok(specificationService.save(specification));
    }

    /**
     * 修改规格表
     * @param specification 规格表
     * @return R
     */
    @ApiOperation(value = "修改规格表", notes = "修改规格表")
    @SysLog("修改规格表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('nideshopspecification_edit')" )
    public R updateById(@RequestBody Specification specification) {
        return R.ok(specificationService.updateById(specification));
    }

    /**
     * 通过id删除规格表
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除规格表", notes = "通过id删除规格表")
    @SysLog("通过id删除规格表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('nideshopspecification_del')" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(specificationService.removeById(id));
    }

}
