package com.mywuwu.pigx.shop;

import com.mywuwu.pigx.common.security.annotation.EnablePigxFeignClients;
import com.mywuwu.pigx.common.security.annotation.EnablePigxResourceServer;
import com.mywuwu.pigx.common.swagger.annotation.EnablePigxSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;


/**
  * @description:  商城后台
  * @author: lianglele
  * @date: 2019-08-26 23:00
  */
@EnablePigxSwagger2
@SpringCloudApplication
@EnablePigxFeignClients
@EnablePigxResourceServer
public class MywuwuShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MywuwuShopApplication.class, args);
	}

}
