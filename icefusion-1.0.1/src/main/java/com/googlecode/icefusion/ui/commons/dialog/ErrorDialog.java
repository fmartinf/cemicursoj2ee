package com.googlecode.icefusion.ui.commons.dialog;


import java.io.PrintWriter;
import java.io.StringWriter;


public class ErrorDialog extends MessageDialog implements IErrorDialog {

    private static final long serialVersionUID = -7011739468116795564L;

    /**
     * Manages exception for textual presentation
     */
    private Throwable exception;

    public Throwable getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public String getStackTrace() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        this.exception.printStackTrace(printWriter);
        return stringWriter.toString();
    }

    /**
     * OK button management.
     * 
     * @return navigation id
     */
    public String errorDialogButtonOk() {

        this.setShow(false);
        return null;
    }
}
