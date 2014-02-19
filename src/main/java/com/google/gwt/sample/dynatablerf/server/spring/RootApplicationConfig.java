package com.google.gwt.sample.dynatablerf.server.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories("com.google.gwt.sample.dynatablerf")
@ComponentScan(basePackages = { "com.google.gwt.sample.dynatablerf" })
public class RootApplicationConfig {

}
