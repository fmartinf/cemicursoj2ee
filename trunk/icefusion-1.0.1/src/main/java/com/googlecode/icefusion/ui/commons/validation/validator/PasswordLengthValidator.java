package com.googlecode.icefusion.ui.commons.validation.validator;


import com.googlecode.icefusion.ui.commons.validation.IValidator;


/**
 * Validator to check the minimum password length.
 * 
 * @author Rainer Eschen
 * 
 */
public class PasswordLengthValidator implements IValidator {

    private static final long serialVersionUID = 8785709026357238903L;

    String message = "application.validation.validator.passwordLength";

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

        String password = (String)this.value;
        return password.length() > 7;
    }
}
