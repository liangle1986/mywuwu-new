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

package com.mywuwu.pigx.shop.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 热闹关键词表
 *
 * @author lianglele
 * @date 2019-08-26 22:22:28
 */
@Data
@TableName("keywords")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "热闹关键词表")
public class Keywords extends Model<Keywords> {
private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value="主键")
    private Integer id;
    /**
     * 关键字
     */
    @ApiModelProperty(value="关键字")
    private String keyword;
    /**
     * 热销
     */
    @ApiModelProperty(value="热销")
    private Integer isHot;
    /**
     * 默认
     */
    @ApiModelProperty(value="默认")
    private Integer isDefault;
    /**
     * 显示
     */
    @ApiModelProperty(value="显示")
    private Integer isShow;
    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sortOrder;
    /**
     * 关键词的跳转链接
     */
    @ApiModelProperty(value="关键词的跳转链接")
    private String schemeUrl;
    /**
     * 类型
     */
    @ApiModelProperty(value="类型")
    private Integer type;
    }
