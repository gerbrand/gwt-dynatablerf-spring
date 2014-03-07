package com.google.gwt.sample.dynatablerf.validation;

import javax.validation.Validator;

import com.google.gwt.sample.dynatablerf.shared.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;

/**
 * This class is the 'boilerplate' needed to to get Bean validation
 * working on the client side.<br/>
 * There's no need to duplicate validation logic on the client side anymore.
 * @author gerbrand
 *
 */
public class GwtValidatorFactory extends AbstractGwtValidatorFactory {

	  @GwtValidation(value ={PersonProxy.class,AddressProxy.class})
	  public interface GwtValidator extends Validator {
	  }

	  @Override
	  public AbstractGwtValidator createValidator() {
	    return GWT.create(GwtValidator.class);
	  }

}
