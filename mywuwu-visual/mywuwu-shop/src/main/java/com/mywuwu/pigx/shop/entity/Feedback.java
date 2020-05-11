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

import java.time.LocalDateTime;

/**
 * 
 *
 * @author lianglele
 * @date 2019-08-26 22:23:28
 */
@Data
@TableName("feedback")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Feedback extends Model<Feedback> {
private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    @ApiModelProperty(value="主键")
    private Integer msgId;
    /**
     * 会员Id
     */
    @ApiModelProperty(value="会员Id")
    private Integer userId;
    /**
     * 会员会员名称
     */
    @ApiModelProperty(value="会员会员名称")
    private String userName;
    /**
     * 手机
     */
    @ApiModelProperty(value="手机")
    private String mobile;
    /**
     * 反馈类型
     */
    @ApiModelProperty(value="反馈类型")
    private Integer feedType;
    /**
     * 详细内容
     */
    @ApiModelProperty(value="详细内容")
    private String content;
    /**
     * 状态
     */
    @ApiModelProperty(value="状态")
    private Integer status;
    /**
     * 反馈时间
     */
    @ApiModelProperty(value="反馈时间")
    private LocalDateTime addTime;
    }
