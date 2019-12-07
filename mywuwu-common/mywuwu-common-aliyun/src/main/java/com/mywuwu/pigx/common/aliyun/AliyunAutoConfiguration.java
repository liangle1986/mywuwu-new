package com.mywuwu.pigx.common.aliyun;

import com.aliyun.oss.OSSClient;
import com.mywuwu.pigx.common.aliyun.service.AliyunTemplate;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program mywuwu-new
 * @description: oss对象存储
 * @author: lianglele
 * @create: 2019/12/06 19:54
 */
@Configuration
@AllArgsConstructor
@ConditionalOnClass({OSSClient.class})
@EnableConfigurationProperties(AliyunProperties.class)
public class AliyunAutoConfiguration {

	private final AliyunProperties properties;

//	public AliyunAutoConfiguration(AliyunProperties properties) {
//		this.properties = properties;
//	}

	@Bean
	@ConditionalOnMissingBean(AliyunTemplate.class)
	@ConditionalOnProperty(name = "aliyun.oss.endpoint")
	AliyunTemplate aliyunTemplate() {
		return new AliyunTemplate(
				properties.getEndpoint(),
				properties.getAccessKeyId(),
				properties.getAccessKeySecret()
		);
	}
}
