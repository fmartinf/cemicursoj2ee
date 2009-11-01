package com.googlecode.icefusion.ui.commons.dialog;

/**
 * Manages the behavior of a QuestionDialog.
 * 
 * @author Rainer Eschen
 *
 */
public class QuestionDialog extends Dialog implements IQuestionDialog {

	private static final long serialVersionUID = 4874914431398569988L;

	/**
	 * Text for the first button.
	 */
	private String yes;
	
	/**
	 * Text for the second button.
	 */
	private String no;
	
	/**
	 * true: YES button was clicked.
	 */
	private Boolean yesClicked;
	
	public String getYes() {
		return yes;
	}

	public void setYes(String yes) {
		this.yes = yes;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Boolean getYesClicked() {
		return yesClicked;
	}

	public void setYesClicked(Boolean yesClicked) {
		this.yesClicked = yesClicked;
	}

	/**
	 * YES button management.
	 * @return navigation id (keep page)
	 */
	public String questionDialogButtonYes() {

		this.setShow(false);
		this.setYesClicked(true);
		return null;
	}

	/**
	 * NO button management.
	 * @return navigation id (keep page)
	 */
	public String questionDialogButtonNo() {

		this.setShow(false);
		this.setYesClicked(false);
		return null;
	}
}
