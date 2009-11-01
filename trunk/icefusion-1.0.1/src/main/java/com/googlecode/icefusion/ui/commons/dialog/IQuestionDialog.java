package com.googlecode.icefusion.ui.commons.dialog;


import java.io.Serializable;


/**
 * Manages the button events of a QuestionDialog.
 * 
 * @author Rainer Eschen
 * 
 */
public interface IQuestionDialog extends Serializable {

    /**
     * YES button management.
     * 
     * @return navigation id
     */
    public String questionDialogButtonYes();

    /**
     * NO button management.
     * 
     * @return navigation id
     */
    public String questionDialogButtonNo();
}
