package com.googlecode.icefusion.ui.commons.validation;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Validation processor. Allows to check a value with one or more IValidators following the order sequence of
 * definition. If errors occur a list of corresponding error message keys is delivered via the IValidationProcessor
 * reference.
 * 
 * @author Rainer Eschen
 * 
 */
public class Validation implements Serializable {

    private static final long serialVersionUID = -3998545050992411049L;

    /**
     * Reference to form processing bean.
     */
    IValidationProcessor processing;

    /**
     * Validators to use for checking the value.
     */
    List<IValidator> validators = new ArrayList<IValidator>();

    /**
     * Value to check with validators.
     */
    Object value;

    /**
     * List of message ids after validation.
     */
    List<String> messages = new ArrayList<String>();

    /**
     * true: stop validation with the first error
     */
    Boolean processSingleErrors = false;

    public Validation(IValidationProcessor processing, IValidator... validators) {

        this.processing = processing;
        for (int i = 0; i < validators.length; i++) {
            this.validators.add(validators[i]);
        }
    }

    /**
     * Check the set value with all defined validators and create a list of message ids for failed validators.
     */
    public void validate() {
        for (IValidator validator : validators) {
            validator.setValue(this.getValue());
            if (!validator.validate()) {
                messages.add(validator.getMessage());
                if (this.getProcessSingleErrors()) {
                    break;
                }
            }
        }
    }

    /**
     * Check value with all existing validators.
     * 
     * @param value value to check
     */
    public void validateValue(Object value) {

        this.setValue(value);
        this.messages.clear();
        this.validate();
        if (this.getProcessing() != null) {
            this.getProcessing().setValidationMessages(messages);
        }
    }

    public IValidationProcessor getProcessing() {
        return processing;
    }

    public void setProcessing(IValidationProcessor processing) {
        this.processing = processing;
    }

    public List<IValidator> getValidators() {
        return validators;
    }

    public void setValidators(List<IValidator> validators) {
        this.validators = validators;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Boolean getProcessSingleErrors() {
        return processSingleErrors;
    }

    public void setProcessSingleErrors(Boolean processSingleErrors) {
        this.processSingleErrors = processSingleErrors;
    }
}
