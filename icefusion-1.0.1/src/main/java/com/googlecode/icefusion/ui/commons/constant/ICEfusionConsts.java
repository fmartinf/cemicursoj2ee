package com.googlecode.icefusion.ui.commons.constant;


import javax.el.ELContext;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import com.googlecode.icefusion.ui.commons.BackingBean;
import com.icesoft.faces.context.BridgeExternalContext;
import com.icesoft.faces.webapp.xmlhttp.PersistentFacesState;


/**
 * Pseudo constants for the ICEfusion extension.
 * 
 * @author Rainer Eschen
 * 
 */

public class ICEfusionConsts extends BackingBean {

    private static final long serialVersionUID = 5062686456025501453L;

    /**
     * Application name.
     */
    private String application = "ICEfusion";

    /**
     * Current release number.
     */
    private String release = "1.0";

    /**
     * Main folder for ICEfusion extension.
     */
    private String base = "/icefusion";

    /**
     * Main folder for ICEfusion skin management.
     */
    private String skinBase = base + "/styles";

    /**
     * Default skin to use.
     * 
     * @deprecated
     */
    @Deprecated
    private String skin = "icefusion";

    /**
     * Main folder for ICEfusion script management.
     */
    private String scriptBase = base + "/scripts";

    /**
     * Name for default resource bundle to use for localization.
     */
    private String defaultBundle = "icefusion";

    /**
     * Template page for pages after login.
     */
    private String templatePage = base + "/taglibs/commons/page.xhtml";

    /**
     * Defines number of entries in result list.
     */
    private Long completerHitsMax = 10L;

    /**
     * Delivers a localized string to a resource bundle id. The resource bundle is explicitly defined.
     * 
     * @param id resource bundle id
     * @return localized string
     * @see #createValueExpression
     */
    // TODO: Deprecation Fix
    // http://thomaswabner.wordpress.com/2007/09/27/replacing-deprecated-valuebindung-stuff-from-jsf-with-elresolver/
    @SuppressWarnings("deprecation")
    public String getLocalized(String id, String bundle) {

        /*
         * FacesContext context = FacesContext.getCurrentInstance();
         * 
         * Application application = context.getApplication(); ValueBinding binding =
         * application.createValueBinding("#{" + bundle + "['" + id + "']}"); return (String) binding.getValue(context);
         */
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        ValueExpression expression = this.createValueExpression("#{" + bundle + "['" + id + "']}", String.class);
        return (String)expression.getValue(elContext);
    }

    /**
     * Delivers a localized string to a resource bundle id from the default bundle definition.
     * 
     * @param id resource bundle id
     * @return localized string
     */
    public String getLocalized(String id) {
        return this.getLocalized(id, this.getDefaultBundle());
    }

    /**
     * Delivers a binding reference.
     * 
     * @param id string identifier
     * @return binding object
     * @see #createValueExpression
     * @deprecated
     */
    @Deprecated
    // TODO: Deprecation Fix
    // http://thomaswabner.wordpress.com/2007/09/27/replacing-deprecated-valuebindung-stuff-from-jsf-with-elresolver/
    @SuppressWarnings("deprecation")
    public ValueBinding getBinding(String id) {

        FacesContext context = FacesContext.getCurrentInstance();

        Application application = context.getApplication();
        ValueBinding binding = application.createValueBinding("#{" + id + "}");
        return binding;
    }

    /**
     * Used to circumvent view update problems.
     */
    public void reloadPage() {

        FacesContext context = FacesContext.getCurrentInstance();
        String uri = ((BridgeExternalContext)context.getExternalContext()).getRequestURI();
        PersistentFacesState state = PersistentFacesState.getInstance();
        state.redirectTo(uri);
    }

    /**
     * Delivers Web container context for path calculation.
     * 
     * @return Web container context
     */
    public String getContextPath() {

        return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
    }

    /**
     * Delivers an EL expression to define a value.
     * 
     * @param valueExpression String with a "#{...}"
     * @param valueType a class to use, like String.class
     * @return the expression object
     */
    public ValueExpression createValueExpression(String valueExpression, Class<?> valueType) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getApplication().getExpressionFactory().createValueExpression(facesContext.getELContext(),
            valueExpression, valueType);
    }

    /**
     * Delivers an EL expression to define a method.
     * 
     * @param actionExpression String with a "#{...}"
     * @param returnType a class to use, like String.class
     * @return the expression object
     */
    public MethodExpression createActionExpression(String actionExpression, Class<?> returnType) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getApplication().getExpressionFactory().createMethodExpression(facesContext.getELContext(),
            actionExpression, returnType, new Class[0]);
    }

    /**
     * Delivers a request parameter.
     * 
     * @param name Parameter name
     * @return Parameter value
     */
    public String getRequestParameter(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
    }


    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getBase() {
        return base;
    }

    public String getSkinBase() {
        return skinBase;
    }

    /**
     * @deprecated
     * @return
     */
    @Deprecated
    public String getSkin() {
        return skin;
    }

    /**
     * @deprecated
     * @param skin
     */
    @Deprecated
    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getScriptBase() {
        return scriptBase;
    }

    public String getTemplatePage() {
        return templatePage;
    }

    public Long getCompleterHitsMax() {
        return completerHitsMax;
    }

    public void setCompleterHitsMax(Long completerHitsMax) {
        this.completerHitsMax = completerHitsMax;
    }

    public String getDefaultBundle() {
        return defaultBundle;
    }

    public void setDefaultBundle(String defaultBundle) {
        this.defaultBundle = defaultBundle;
    }
}
