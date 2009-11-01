package com.googlecode.icefusion.ui.commons.constant;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Single skin. Managed via database.
 * 
 * @author Rainer Eschen
 *
 */
@Entity
public class Skin implements Serializable {

	private static final long serialVersionUID = 411970553876977595L;

	/**
	 * Database identifier.
	 */
	@Id
	Long id;

	/**
	 * Code for the skin. Used for folder calculation.
	 */
	String code;
	
	/**
	 * Label to present skin in user interface.
	 */
	String label;
	
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
