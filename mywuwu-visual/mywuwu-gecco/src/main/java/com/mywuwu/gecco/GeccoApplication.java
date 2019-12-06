package com.mywuwu.gecco;

import com.mywuwu.pigx.common.security.annotation.EnablePigxFeignClients;
import com.mywuwu.pigx.common.security.annotation.EnablePigxResourceServer;
import com.mywuwu.pigx.common.swagger.annotation.EnablePigxSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@EnablePigxSwagger2
@SpringCloudApplication
@EnablePigxFeignClients
@EnablePigxResourceServer
public class GeccoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeccoApplication.class, args);
	}

}
