package com.googlecode.icefusion.ui.commons.dialog;

/**
 * Manages the behavior of a MessageDialog.
 * 
 * @author Rainer Eschen
 *
 */
public class MessageDialog extends Dialog implements IMessageDialog {

	private static final long serialVersionUID = -203516796997721428L;

	/**
	 * OK button management.
	 * @return navigation id
	 */
	public String messageDialogButtonOk() {
		
		this.setShow(false);
		return null;
	}
}
