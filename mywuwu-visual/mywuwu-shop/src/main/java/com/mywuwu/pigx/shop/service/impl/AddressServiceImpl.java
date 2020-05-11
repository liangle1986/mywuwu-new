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
package com.mywuwu.pigx.shop.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mywuwu.pigx.common.core.util.R;
import com.mywuwu.pigx.shop.entity.Address;
import com.mywuwu.pigx.shop.mapper.AddressMapper;
import com.mywuwu.pigx.shop.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 *
 * @author lianglele
 * @date 2019-08-26 22:24:02
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

	@Override
	public R saveOrUpdateAddress(Address address){
		if(address.getIsDefault() == 1){
			this.list(Wrappers.<Address>query().lambda().eq(Address::getUserId, address.getUserId()).eq(Address::getIsDefault, 1)).stream(). forEach(a->{
				a.setIsDefault(0);
			this.updateById(a);});
		}
		if(address.getId() > 0){
			this.updateById(address);
		} else {
			this.save(address);
		}
		return R.ok("操作成功！");
	}
}
