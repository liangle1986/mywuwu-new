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
 * @date 2019-08-26 22:24:02
 */
@Data
@TableName("address")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Address extends Model<Address> {
private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId
    @ApiModelProperty(value="")
    private Integer id;
    /**
     * 会员ID
     */
    @ApiModelProperty(value="会员ID")
    private Integer userId;
    /**
     * 收货人姓名
     */
    @ApiModelProperty(value="收货人姓名")
    private String userName;
    /**
     * 手机
     */
    @ApiModelProperty(value="手机")
    private String telNumber;
    /**
     * 邮编
     */
    @ApiModelProperty(value="邮编")
    private String postalCode;
    /**
     * 收货地址国家码
     */
    @ApiModelProperty(value="收货地址国家码")
    private String nationalCode;
    /**
     * 省
     */
    @ApiModelProperty(value="省")
    private String provinceName;
    /**
     * 市
     */
    @ApiModelProperty(value="市")
    private String cityName;
    /**
     * 区
     */
    @ApiModelProperty(value="区")
    private String countyName;
    /**
     * 详细收货地址信息
     */
    @ApiModelProperty(value="详细收货地址信息")
    private String detailInfo;
	/**
	 * 默认收获地址 1：是
	 */
	@ApiModelProperty(value = "默认收货地址")
	private Integer isDefault;

    }
