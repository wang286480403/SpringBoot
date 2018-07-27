package com.n22.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wangsiyong
 * @description: 公共配置
 * @create: 2018-07-16 15:26
 */
@Component
public class CommonProperties {
	@Value("${dev}")
	private String dev;

	@Value("${prod}")
	private String prod;

	public String getDev() {
		return dev;
	}

	public void setDev(String dev) {
		this.dev = dev;
	}

	public String getProd() {
		return prod;
	}

	public void setProd(String prod) {
		this.prod = prod;
	}
}
