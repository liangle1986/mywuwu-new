/*
 *
 *      Copyright (c) 2018-2025, lianglele All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the ywuwu.com developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: lianglele (liangle1986@126.com)
 *
 */

package com.mywuwu.pigx.admin.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lianglele
 * @since 2017-10-29
 */
@Data
@ApiModel(value = "微信用户")
public class WxUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(value = "user_id", type = IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer userId;
	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "用户名")
	private String username;
	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码")
	private String password;
	/**
	 * 随机盐
	 */
	@ApiModelProperty(value = "性别")
	private Integer gender;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "生日")
	private LocalDateTime birthday;
	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "注册时间")
	private LocalDateTime registerTime;
	/**
	 * 修改时间
	 */
	@ApiModelProperty(value = "登陆时间")
	private LocalDateTime lastLoginTime;
	/**
	 * 0-正常，1-删除
	 */
	@ApiModelProperty(value = "登陆ip")
	private String lastLoginIp;
	/**
	 * 用户等级
	 */
	@ApiModelProperty(value = "用户等级")
	private Integer userLevelId;
	/**
	 * 别名
	 */
	@ApiModelProperty(value = "别名")
	private String nickName;
	/**
	 * 别名
	 */
	@ApiModelProperty(value = "手机")
	private String mobile;	/**
	 * 别名
	 */
	@ApiModelProperty(value = "注册IP")
	private String registerIp;
	/**
	 * 头像
	 */
	@ApiModelProperty(value = "头像地址")
	private String avatar;

	/**
	 * 微信openid
	 */
	@ApiModelProperty(value = "微信openid")
	private String weixinOpenid;
}
