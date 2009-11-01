package com.googlecode.icefusion.ui.commons.constant;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Single locale. Managed via database.
 * 
 * @author Rainer Eschen
 *
 */
@Entity
public class Locale implements Serializable {

	private static final long serialVersionUID = -8010265957067270877L;

	/**
	 * Database identifier.
	 */
	@Id
	Long id;

	/**
	 * Two char code for the locale.
	 */
	String code;
	
	/**
	 * Label to present locale in user interface.
	 */
	String label;
	
	public java.util.Locale getLocale() {
		java.util.Locale locale = new java.util.Locale(this.getCode());
		return locale;
	}

	@Basic
	public Long getId() {
		return id;
	}

	@Basic
	public void setId(Long id) {
		this.id = id;
	}
	
	@Basic
	public String getCode() {
		return code;
	}
	
	@Basic
	public void setCode(String code) {
		this.code = code;
	}

	@Basic
	public String getLabel() {
		return label;
	}

	@Basic
	public void setLabel(String label) {
		this.label = label;
	}
}
