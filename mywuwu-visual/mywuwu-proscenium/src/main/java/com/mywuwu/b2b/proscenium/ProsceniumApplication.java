package com.mywuwu.b2b.proscenium;

import com.mywuwu.pigx.common.security.annotation.EnablePigxFeignClients;
import com.mywuwu.pigx.common.security.annotation.EnablePigxResourceServer;
import com.mywuwu.pigx.common.swagger.annotation.EnablePigxSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@EnablePigxSwagger2
@SpringCloudApplication
@EnablePigxFeignClients
@EnablePigxResourceServer
public class ProsceniumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProsceniumApplication.class, args);
	}

}
