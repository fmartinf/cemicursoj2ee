package com.googlecode.icefusion.ui.commons.validation.validator;


import com.googlecode.icefusion.ui.commons.validation.IValidator;


/**
 * Validator to check lowercase for username.
 * 
 * @author Rainer Eschen
 * 
 */
public class UsernameLowerCaseValidator implements IValidator {

    private static final long serialVersionUID = 4223453941923366531L;

    String message = "application.validation.validator.usernameLowerCase";

    Object value;

    public String getMessage() {

        return this.message;
    }

    public Object getValue() {

        return this.value;
    }

    public void setMessage(String key) {

        this.message = key;
    }

    public void setValue(Object value) {

        this.value = value;
    }

    public Boolean validate() {

        String username = (String)this.value;

        return username.equals(username.toLowerCase());
    }
}
