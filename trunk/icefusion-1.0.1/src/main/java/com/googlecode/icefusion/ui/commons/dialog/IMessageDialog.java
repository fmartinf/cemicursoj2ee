package com.googlecode.icefusion.ui.commons.dialog;


import java.io.Serializable;


/**
 * Manages the button events of a QuestionDialog.
 * 
 * @author Rainer Eschen
 * 
 */
public interface IMessageDialog extends Serializable {

    /**
     * OK button management.
     * 
     * @return navigation id
     */
    public String messageDialogButtonOk();
}
