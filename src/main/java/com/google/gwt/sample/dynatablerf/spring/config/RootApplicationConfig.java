package com.google.gwt.sample.dynatablerf.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Java based Spring Application context.
 * The java version of the applicationContext.xml. Because beans are marked
 * as Spring beans using an annotation, this class can be kept quite simple.
 * @author Gerbrand van Dieijen <gerbrand@vandieijen.nl>
 *
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan(basePackages = { "com.google.gwt.sample.dynatablerf" })
public class RootApplicationConfig {

}
