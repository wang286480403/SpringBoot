package com.n22.common.config.db;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangsiyong
 * @Description: 多数据源配置
 * @date 2018/8/7 14:23
 */
@Configuration
public class DataSourceConfig {
	/**
	 * 数据源1
	 * @return
	 */
	@Bean(name = "datasource1")
	@ConfigurationProperties(prefix = "spring.datasource.db1")
	public DataSource dataSource1() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * 数据源2
	 * @return
	 */
	@Bean(name = "datasource2")
	@ConfigurationProperties(prefix = "spring.datasource.db2")
	public DataSource dataSource2() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * 动态数据源: 通过AOP在不同数据源之间动态切换
	 * @return
	 */
	@Primary
	@Bean(name = "dynamicDataSource")
	public DataSource dynamicDataSource() {
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		// 默认数据源
		dynamicDataSource.setDefaultTargetDataSource(dataSource1());
		// 配置多数据源
		Map<Object, Object> dsMap = new HashMap();
		dsMap.put("datasource1", dataSource1());
		dsMap.put("datasource2", dataSource2());

		dynamicDataSource.setTargetDataSources(dsMap);
		return dynamicDataSource;
	}

	/**
	 * 配置@Transactional注解事物
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dynamicDataSource());
	}
}