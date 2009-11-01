package com.googlecode.icefusion.ui.commons.form;


import java.io.Serializable;
import java.util.List;

import javax.faces.model.SelectItem;


/**
 * Defines all methods for the completer management.
 * 
 * @author Rainer Eschen
 * 
 */
public interface ICompleter extends Serializable {

    public List<SelectItem> getCompleterBaseList();

    public String getCompleterValue();

    public void setCompleterValue(String value);
}
