package com.mywuwu.pigx.common.aliyun;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program mywuwu-new
 * @description: 配置文件对象
 * @author: lianglele
 * @create: 2019/12/06 19:57
 */
@Data
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunProperties {
	/**
	 * 访问地址
	 */
	private String endpoint;
	/**
	 * 唯一key
	 */
	private String accessKeyId;
	/**
	 * 密钥
	 */
	private String accessKeySecret;
}
