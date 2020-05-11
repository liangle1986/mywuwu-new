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

package com.mywuwu.pigx.shop.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.mywuwu.pigx.shop.entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lianglele
 * @date 2019-08-26 22:23:32
 */
@Data
public class CategoryVo {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@ApiModelProperty(value = "")
	private Integer id;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String name;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String keywords;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String frontDesc;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer parentId;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer sortOrder;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer showIndex;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer isShow;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String bannerUrl;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String iconUrl;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String imgUrl;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String wapBannerUrl;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String level;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private Integer type;
	/**
	 *
	 */
	@ApiModelProperty(value = "")
	private String frontName;
	private List<Category> subList;

}
