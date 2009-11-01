package com.googlecode.icefusion.ui.commons.form;

import javax.faces.model.SelectItem;

/**
 * Standard SelectItem extended with Image tag attributes. 
 * For value comparison label and imageUrl are used as a kind
 * of id in dadSelectorContexts.
 * 
 * @author Rainer Eschen
 *
 */
public class DadSelectorItem extends SelectItem {

	private static final long serialVersionUID = -1332872570075283386L;
	
	private String imageUrl;
	private String imageAlt = "";
	private int imageWidth;
	private int imageHeight;
	
	public DadSelectorItem() {
	}
	
	public DadSelectorItem(DadSelectorItem item) {
		
		this.setDescription(item.getDescription());
		this.setDisabled(item.isDisabled());
		this.setEscape(item.isEscape());
		this.setLabel(item.getLabel());
		this.setValue(item.getValue());
		this.setImageUrl(item.getImageUrl());
		this.setImageAlt(item.getImageAlt());
		this.setImageWidth(item.getImageWidth());
		this.setImageHeight(item.getImageHeight());
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageAlt() {
		return imageAlt;
	}
	public void setImageAlt(String imageAlt) {
		this.imageAlt = imageAlt;
	}
	public int getImageWidth() {
		return imageWidth;
	}
	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}
	public int getImageHeight() {
		return imageHeight;
	}
	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if ((obj == null) || (obj.getClass() != this.getClass())) {
			return false;
		}
		// object must be DadSelectorItem at this point
		DadSelectorItem item = (DadSelectorItem)obj;
		return this.getLabel() == item.getLabel() &&
			(this.getImageUrl() == item.getImageUrl() || (this.getImageUrl() != null && 
			this.getImageUrl().equals(item.getImageUrl())));
	}
	
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (null == this.getLabel() ? 0 : this.getLabel().hashCode());
			hash = 31 * hash + (null == this.getImageUrl() ? 0 : this.getImageUrl().hashCode());
		return hash;
	}
}
