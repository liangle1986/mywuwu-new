package com.mywuwu.pigx.common.aliyun.service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @program mywuwu-new
 * @description: 文件处理类
 * @author: lianglele
 * @create: 2019/12/06 20:00
 */
@RequiredArgsConstructor
public class AliyunTemplate implements FactoryBean<OSSClient>, InitializingBean, DisposableBean {
	private OSSClient ossClient;
	private String endpoint;
	private String accessKeyId;
	private String accessKeySecret;

	public AliyunTemplate(String endpoint, String accessKeyId, String accessKeySecret) {
		this.endpoint = endpoint;
		this.accessKeyId = accessKeyId;
		this.accessKeySecret = accessKeySecret;
	}


	@Override
	public void destroy() throws Exception {
		if (this.ossClient != null) {
			this.ossClient.shutdown();
		}
	}

	@Override
	public OSSClient getObject() throws Exception {
		return this.ossClient;
	}

	@Override
	public Class<?> getObjectType() {
		return OSSClient.class;
	}


	/**
	 * 创建bucket
	 *
	 * @param bucketName bucket名称
	 */
	@SneakyThrows
	public void createBucket(String bucketName) {
		if (!ossClient.doesBucketExist(bucketName)) {
			// 创建CreateBucketRequest对象。
			CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
			// 创建存储空间。
			ossClient.createBucket(createBucketRequest);
		}

	}

	/**
	 * 获取全部bucket
	 * <p>
	 * https://docs.minio.io/cn/java-client-api-reference.html#listBuckets
	 */
	@SneakyThrows
	public List<Bucket> getAllBuckets() {
		return ossClient.listBuckets();

	}

	/**
	 * @param bucketName bucket名称
	 */
	@SneakyThrows
	public Optional<Bucket> getBucket(String bucketName) {
		return ossClient.listBuckets().stream().filter(b -> b.getName().equals(bucketName)).findFirst();
	}

	/**
	 * @param bucketName bucket名称
	 */
	@SneakyThrows
	public void removeBucket(String bucketName) {
		ossClient.deleteBucket(bucketName);

	}


	/**
	 * 获取文件外链
	 *
	 * @param bucketName bucket名称
	 * @param objectName 文件名称
	 * @param expires    过期时间 <=7
	 * @return url
	 */
	@SneakyThrows
	public String getObjectURL(String bucketName, String objectName, Date expires) {
		return ossClient.generatePresignedUrl(bucketName, objectName, expires).getPath();

	}

	/**
	 * 获取文件
	 *
	 * @param bucketName bucket名称
	 * @param objectName 文件名称
	 * @return 二进制流
	 */
	@SneakyThrows
	public InputStream getObject(String bucketName, String objectName) {
		return ossClient.getObject(bucketName, objectName).getObjectContent();
	}

	/**
	 * 上传文件
	 *
	 * @param bucketName bucket名称
	 * @param objectName 文件名称
	 * @param stream     文件流
	 * @throws Exception https://docs.minio.io/cn/java-client-api-reference.html#putObject
	 */
	public void putObject(String bucketName, String objectName, InputStream stream) throws Exception {

		ossClient.putObject(bucketName, objectName, stream);

	}


	/**
	 * 获取文件信息
	 *
	 * @param bucketName bucket名称
	 * @param objectName 文件名称
	 * @throws Exception https://docs.minio.io/cn/java-client-api-reference.html#statObject
	 */
	public ObjectMetadata getObjectInfo(String bucketName, String objectName) throws Exception {
		return ossClient.getObjectMetadata(bucketName, objectName);

	}

	/**
	 * 删除文件
	 *
	 * @param bucketName bucket名称
	 * @param objectName 文件名称
	 * @throws Exception https://docs.minio.io/cn/java-client-api-reference.html#removeObject
	 */
	public void removeObject(String bucketName, String objectName) throws Exception {
		ossClient.deleteObject(bucketName, objectName);
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.hasText(endpoint, "阿里云 endpoint 为空");
		Assert.hasText(accessKeyId, "阿里云 accessKeyId为空");
		Assert.hasText(accessKeySecret, "阿里云 accessKeySecret为空");
		this.ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}
}
