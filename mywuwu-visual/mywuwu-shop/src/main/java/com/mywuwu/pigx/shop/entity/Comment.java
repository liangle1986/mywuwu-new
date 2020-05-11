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
 * @date 2019-08-26 22:24:07
 */
@Data
@TableName("comment")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Comment extends Model<Comment> {
private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value="主键")
    private Integer id;
    /**
     * 类型
	 * 0 商品 1 专题
     */
    @ApiModelProperty(value="类型")
    private Integer typeId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer valueId;
    /**
     * 储存为base64编码
     */
    @ApiModelProperty(value="储存为base64编码")
    private String content;
    /**
     * 记录时间
     */
    @ApiModelProperty(value="记录时间")
    private Long addTime;
    /**
     * 状态
     */
    @ApiModelProperty(value="状态")
    private Integer status;
    /**
     * 会员Id
     */
    @ApiModelProperty(value="会员Id")
    private Integer userId;
    }
