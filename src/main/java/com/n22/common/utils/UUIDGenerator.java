package com.n22.common.utils;

import java.util.UUID;

/**
 * @author wangsiyong
 * @description: 生成UUID工具类
 * @create: 2018-07-16 15:31
 */
public class UUIDGenerator {
	/**
	 * <p>Title: createKey</p>
	 * <p>Description: 生成UUID公用业务方法</p>
	 * @return
	 * @author Asdpboy Yan  2012-1-13 下午02:25:11
	 */
	public static String createKey() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 
	 * <p>Title: create32Key</p>
	 * <p>Description: 创建32位的UUID</p>
	 * @return
	 * @author 许世选  2012-1-16 下午03:29:32
	 */
	public static String create32Key() {
		return UUID.randomUUID().toString().replaceAll("\\-", "");
	}
}
