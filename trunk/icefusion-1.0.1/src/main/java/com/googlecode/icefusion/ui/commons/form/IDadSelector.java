package com.googlecode.icefusion.ui.commons.form;


import java.io.Serializable;
import java.util.List;


/**
 * Defines all methods for the drag and drop selector management.
 * 
 * @author Rainer Eschen
 * 
 */
public interface IDadSelector extends Serializable {

    public List<DadSelectorItem> getDadSelectorSourceList();

    public List<DadSelectorItem> getDadSelectorSelectedList();
}
