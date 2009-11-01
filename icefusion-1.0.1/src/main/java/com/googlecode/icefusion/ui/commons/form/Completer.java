package com.googlecode.icefusion.ui.commons.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.icefusion.ui.commons.BackingBeanForm;
import com.googlecode.icefusion.ui.commons.constant.Context;
import com.googlecode.icefusion.ui.commons.constant.ICEfusionConsts;
import com.icesoft.faces.component.selectinputtext.SelectInputText;

/**
 * Manages the behavior of a Completer.
 * 
 * @author Rainer Eschen
 *
 */
public class Completer extends BackingBeanForm {

	private static final long serialVersionUID = 3846199324813965959L;

	@Autowired
	private ICEfusionConsts consts;
	
	@Autowired
	private Context context;
    
    /**
     * Current selection in list or input by hand
     */
    private String value;
    
    /**
     * Binding to get the base list for calculations
     */
    private SelectInputText baseList;
    
    public SelectInputText getBaseList() {
		return baseList;
	}

	public void setBaseList(SelectInputText baseList) {
		this.baseList = baseList;
	}

	/**
     * Calculation of results to show
     */
    private List<SelectItem> matches = new ArrayList<SelectItem>();
	
	public void listener(ValueChangeEvent event) {

		if (event.getComponent() instanceof SelectInputText) {
            String search = (String) event.getNewValue();
            Long matches_i = 0L;
			matches.clear();
            for (SelectItem entry : (ArrayList<SelectItem>)this.getBaseList().getListValue()) {
            	if ((matches_i > this.getRows())) {
            		break;
            	}
            	if (entry.getLabel().toString().toUpperCase(this.context.getSettings().getLocale().getLocale()).startsWith(search.toUpperCase(this.context.getSettings().getLocale().getLocale()))) {
            		matches.add(entry);
            		matches_i++;
            	}
            }
        }
	}

	/**
	 * The results to show in user interface as list
	 */
	public List<SelectItem> getResultList() {
		
		return matches;
	}

	public String getValue() {

		return this.value;
	}

	public void setValue(String value) {

		this.value = value;
	}
	
	/**
	 * Maximum number of rows to show.
	 * @return number of rows
	 */
	public Long getRows() {

		return this.consts.getCompleterHitsMax();
	}
}
