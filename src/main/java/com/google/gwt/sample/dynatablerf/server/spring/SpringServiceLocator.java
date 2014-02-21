package com.google.gwt.sample.dynatablerf.server.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

/**
 * GWT Locator to find Spring-beans.
 * 
 * @author Gerbrand van Dieijen <gerbrand@vandieijen.nl>
 *
 */
@Component
public class SpringServiceLocator implements ServiceLocator, ApplicationContextAware {
	
	private ApplicationContext applicationContext;

	@Override
	public Object getInstance(Class<?> clazz) {
		return applicationContext.getBean(clazz);
	}

	@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	    this.applicationContext=applicationContext;
	    
    }


}