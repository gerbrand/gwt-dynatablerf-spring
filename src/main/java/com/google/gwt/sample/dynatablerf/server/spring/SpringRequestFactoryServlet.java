package com.google.gwt.sample.dynatablerf.server.spring;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.web.bindery.requestfactory.server.ExceptionHandler;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;
import com.google.web.bindery.requestfactory.server.ServiceLayerDecorator;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

/**
 * The RequestFactory is extended so GWT service clases
 * so Locator objects are looked up via Spring.
 * @author gerbrand
 *
 */
public class SpringRequestFactoryServlet extends RequestFactoryServlet {
	private static final Logger LOG = LoggerFactory.getLogger(SpringRequestFactoryServlet.class);
	private static final long serialVersionUID = -2734812368731072628L;
	private static WebApplicationContext applicationContext;

	
	public SpringRequestFactoryServlet() {
		super(new ExceptionHandler(){

			@Override
			public ServerFailure createServerFailure(Throwable throwable) {
				LOG.error("Exception while handling request.",throwable);
				return new ServerFailure(
				        "Server Error: " + (throwable == null ? null : throwable.getMessage()), null, null , true);
			}

			},new ServiceLayerDecorator(){
				  @Override
				  public <T extends Locator<?, ?>> T createLocator(Class<T> clazz) {
					  return applicationContext.getBean(clazz);
				  }
				  
				  @Override
				  public <T extends ServiceLocator> T createServiceLocator(Class<T> clazz) {
					  return applicationContext.getBean(clazz);					  
				  }
				  
				  public void setProperty(Object domainObject, String property, Class<?> expectedType, Object value) {
					  try {
						  super.setProperty(domainObject, property, expectedType, value);
					  } catch (Exception e) {
						  //Catching exception and rethrow it because the exception of gwt can be rather cryptic.
						  throw new RuntimeException("Could not set property "+property+" to "+value+" of "+domainObject,e);
					  }
				  }
			});
	}
	
	@Override
	public void init() throws ServletException {
		synchronized (getClass()) {
			if (applicationContext==null) {
				applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
			}
        }
		super.init();
	}
}
