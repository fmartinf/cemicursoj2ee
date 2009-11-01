package com.googlecode.icefusion.ui.commons.dialog;

import com.googlecode.icefusion.ui.commons.BackingBeanForm;

/**
 * Manages all dialogs based on the PanelPopup tag. Each of the
 * different dialogs can be used once in a form and page respectively.
 * 
 * @author Rainer Eschen
 *
 */
public class Dialog extends BackingBeanForm {

	private static final long serialVersionUID = 8729008539728662952L;

	/**
	 * Defines the title for a dialog.
	 */
	private String title;
	
	/**
	 * Defines the text for a dialog.
	 */
	private String text;
	
	/**
	 * true: Show dialog.
	 */
	private Boolean show = false;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getShow() {
		return show;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}
}

