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
 * Author: lianglele (lianglele1986@126.com)
 */

package com.mywuwu.b2b.proscenium.controller;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 支付
 *
 * @author lianglele
 * @date 2019-05-28 23:58:18
 */
@RestController
@AllArgsConstructor
@RequestMapping("/index")
@Api(value = "index", tags = "测试")
public class IndexController {


	/**
	 * 首页
	 *
	 * @return
	 */
	@GetMapping("/index")
	public ModelAndView getPayTradeOrderPage(ModelAndView modelAndView) {
//		ModelAndView modelAndView = new ModelAndView();
		List areaList = new ArrayList();
		for (int i = 0; i <= 5; i++) {
			areaList.add("地区" + i);
		}
		Map<String, Object> map = new HashMap<>();
		map.put("areaList", areaList);
		modelAndView.setViewName("index");
		modelAndView.addObject("areaList", areaList);
		return modelAndView;
	}


}
