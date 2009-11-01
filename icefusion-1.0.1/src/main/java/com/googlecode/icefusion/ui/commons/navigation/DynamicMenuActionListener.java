/**
 * 
 */
package com.googlecode.icefusion.ui.commons.navigation;


import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;


/**
 * Creates a page call for a dynamic menu entry using navigation ids from the faces-config.xml. If no explicit
 * navigation id is set it interprets the id attribute from the menuitem tag as navigation id.
 * 
 * @author Rainer Eschen
 * 
 */
public class DynamicMenuActionListener implements ActionListener, Serializable {

    private static final long serialVersionUID = -5934851953265962383L;

    /**
     * Navigation id from faces-config.xml to use for page call.
     */
    private String navigationId;

    public DynamicMenuActionListener() {
        super();
    }

    public DynamicMenuActionListener(String navigationId) {
        super();
        this.setNavigationId(navigationId);
    }

    public String getNavigationId() {
        return navigationId;
    }

    public void setNavigationId(String navigationId) {
        this.navigationId = navigationId;
    }

    /**
     * Process page call.
     * 
     * @param navigationId page
     */
    public void navigation(String navigationId) {

        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, navigationId);
    }

    public void processAction(ActionEvent actionEvent) throws AbortProcessingException {
        if (this.getNavigationId() == null) {
            this.setNavigationId(((UIComponent)actionEvent.getSource()).getId());
        }
        this.navigation(this.getNavigationId());
    }

}
