package com.n22.common.config.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author wangsiyong
 * @Description: 当前数据源
 * @date 2018/8/7 14:25
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		System.out.println("数据源为"+DataSourceContextHolder.getDB());
		return DataSourceContextHolder.getDB();
	}
}

