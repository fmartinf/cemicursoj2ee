package com.googlecode.icefusion.ui.commons.push;


import java.io.Serializable;


/**
 * Manages the processing status of a ProgressDialog.
 * 
 * @author Rainer Eschen
 * 
 */
public interface IProgressDialog extends Serializable {

    /**
     * Get curent percentage of progress.
     * 
     * @return progress in percent
     */
    public Long getProgress();

    /**
     * Set current percentage of progress.
     * 
     * @param progress current progress in percent
     */
    public void setProgress(Long progress);

    /**
     * true: dialog Cancel button was clicked.
     * 
     * @return cancel status
     */
    public Boolean getCancel();

    /**
     * Set Cancel button status.
     * 
     * @param cancel true: button was clicked.
     */
    public void setCancel(Boolean cancel);
}
