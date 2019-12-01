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

package com.mywuwu.pigx.daemon.elastic;

import com.mywuwu.pigx.common.job.annotation.EnablePigxXxlJob;
import com.mywuwu.pigx.common.security.annotation.EnablePigxFeignClients;
import com.mywuwu.pigx.common.security.annotation.EnablePigxResourceServer;
import com.mywuwu.pigx.common.swagger.annotation.EnablePigxSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author lianglele
 * @date 2018/7/24
 * 分布式任务调度模块
 */
@EnablePigxXxlJob
@EnablePigxSwagger2
@EnablePigxFeignClients
@SpringCloudApplication
@EnablePigxResourceServer
public class PigxDaemonElasticJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(PigxDaemonElasticJobApplication.class, args);
	}

}
