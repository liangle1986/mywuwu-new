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
 * 
 *
 * @author lianglele
 * @date 2019-08-26 22:22:05
 */
@Data
@TableName("search_history")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class SearchHistory extends Model<SearchHistory> {
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
     * 搜索来源，如PC、小程序、APP等
     */
    @ApiModelProperty(value="搜索来源，如PC、小程序、APP等")
    private String fromName;
    /**
     * 搜索时间
     */
    @ApiModelProperty(value="搜索时间")
    private Integer addTime;
    /**
     * 会员Id
     */
    @ApiModelProperty(value="会员Id")
    private String userId;
    }
