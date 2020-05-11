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
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 
 *
 * @author lianglele
 * @date 2019-08-26 22:24:27
 */
@Data
@TableName("coupon")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Coupon extends Model<Coupon> {
private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId
    @ApiModelProperty(value="")
    private Integer id;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String name;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private BigDecimal typeMoney;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer sendType;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private BigDecimal minAmount;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private BigDecimal maxAmount;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime sendStartDate;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime sendEndDate;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime useStartDate;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime useEndDate;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private BigDecimal minGoodsAmount;
    /**
     * 转发次数
     */
    @ApiModelProperty(value="转发次数")
    private Integer minTransmitNum;
    }
