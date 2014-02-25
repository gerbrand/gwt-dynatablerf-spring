package com.google.gwt.sample.dynatablerf.server.spring;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Defines the DataSource. You might want to replace the Driverbased Datasource
 * with J2EE lookup depending on your situation.
 * @author gerbrand
 *
 */
@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfig {
	private static final Logger LOG = LoggerFactory.getLogger(DataSourceConfig.class);
	
	@Autowired
	Environment env;

	@Bean
	@Autowired
	public DataSource dataSource() throws Exception {
		DriverManagerDataSource ds = new DriverManagerDataSource();
    	ds.setDriverClassName(env.getProperty("jdbc.driver"));
        LOG.info("Creating datasource for {}",env.getProperty("jdbc.url"));
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));
        return ds;
	}
}
