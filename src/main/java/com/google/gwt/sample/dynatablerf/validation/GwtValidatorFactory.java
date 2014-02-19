package com.google.gwt.sample.dynatablerf.validation;

import javax.validation.Validator;

import com.google.gwt.sample.dynatablerf.shared.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;

public class GwtValidatorFactory extends AbstractGwtValidatorFactory {

	  @GwtValidation(value ={PersonProxy.class,AddressProxy.class})
	  public interface GwtValidator extends Validator {
	  }

	  @Override
	  public AbstractGwtValidator createValidator() {
	    return GWT.create(GwtValidator.class);
	  }

}
