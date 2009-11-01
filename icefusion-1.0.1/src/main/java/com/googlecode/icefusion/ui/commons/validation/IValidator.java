package com.googlecode.icefusion.ui.commons.validation;

import java.io.Serializable;

/**
 * Defines all methods to become a validator.
 * 
 * @author Rainer Eschen
 *
 */
public interface IValidator extends Serializable {

	/**
	 * Start the validation.
	 * @return true: validation ok.
	 */
	public Boolean validate();
	
	/**
	 * Get value to check.
	 */
	public Object getValue();
	/**
	 * Set value to check.
	 */
	public void setValue(Object value);
	
	/**
	 * Get message key for validation failure.
	 */
	public String getMessage();
	/**
	 * Set message key for validation failure.
	 */
	public void setMessage(String key);
}
