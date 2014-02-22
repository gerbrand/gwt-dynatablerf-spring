package com.google.gwt.sample.dynatablerf.server.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = { "com.google.gwt.sample.dynatablerf" })
public class RootApplicationConfig {

}
