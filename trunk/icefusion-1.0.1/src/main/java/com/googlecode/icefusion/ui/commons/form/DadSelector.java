package com.googlecode.icefusion.ui.commons.form;

import java.util.ArrayList;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.icefusion.ui.commons.BackingBeanForm;
import com.googlecode.icefusion.ui.commons.constant.ICEfusionConsts;
import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.dragdrop.DndEvent;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.BridgeExternalContext;
import com.icesoft.faces.webapp.xmlhttp.PersistentFacesState;

/**
 * Manages the behavior of a Drag and Drop Selector (DadSelector).
 * 
 * @author Rainer Eschen
 *
 */
public class DadSelector extends BackingBeanForm {

	private static final long serialVersionUID = 4226160332653182660L;

	@Autowired
	private ICEfusionConsts consts;
	
	/**
     * Binding to get the source list for calculations
     */
    private SelectInputText sourceList;
	
    /**
     * Binding to get the selected list for calculations
     */
    private SelectInputText selectedList;
    
    public void dragListener(DragEvent event){
    	// TODO: Redesign with ICEfaces 1.8 using <ice:setEventPhase />
    	if (event.getEventType() == DndEvent.DROPPED) {
            if ((event.getTargetClientId() != null)) {
            	// an entity was dropped
            	DadSelectorItem item =
                	(DadSelectorItem) ((HtmlPanelGroup) event.getComponent()).getDragValue();
            	ArrayList<DadSelectorItem> selected = (ArrayList<DadSelectorItem>)this.getSelectedList().getListValue();
            	if (!selected.contains(item)) {
            		selected.add(item);
            	}
            	ArrayList<DadSelectorItem> source = (ArrayList<DadSelectorItem>)this.getSourceList().getListValue();
            	if (source.contains(item)) {
            		source.remove(item);
            	}
            	consts.reloadPage();
            }
    	}
    }

	public SelectInputText getSourceList() {
		return sourceList;
	}

	public void setSourceList(SelectInputText sourceList) {
		this.sourceList = sourceList;
	}

	public SelectInputText getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(SelectInputText selectedList) {
		this.selectedList = selectedList;
	}
}
