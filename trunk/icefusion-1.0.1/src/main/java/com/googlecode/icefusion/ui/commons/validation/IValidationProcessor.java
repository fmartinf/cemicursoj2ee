package com.googlecode.icefusion.ui.commons.validation;


import java.io.Serializable;
import java.util.List;


/**
 * Defines all methods for processing a validation with dialog feedback.
 * 
 * @author Rainer Eschen
 * 
 */
public interface IValidationProcessor extends Serializable {

    /**
     * Delivers all messages from validators that had errors.
     * 
     * @return List of message keys
     */
    public List<String> getValidationMessages();

    /**
     * Set all messages from validators that had errors.
     * 
     * @param messages message keys
     */
    public void setValidationMessages(List<String> messages);

    /**
     * Delivers validation error status.
     * 
     * @return true: one or more validators created errors.
     */
    public Boolean getValidationErrorStatus();

    /**
     * Set name of field that is validated.
     * 
     * @param field field name
     */
    public void setValidationField(String field);

    /**
     * Get name of field that is validated.
     * 
     * @return field name
     */
    public String getValidationField();

    /**
     * OK button management. Need to reset ErrorStatus.
     * 
     * @return navigation id
     */
    public String validationDialogButtonOk();
}
