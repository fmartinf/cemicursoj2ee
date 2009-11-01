package com.googlecode.icefusion.ui.commons.constant;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.icefusion.ui.commons.BackingBeanForm;
import com.googlecode.icefusion.ui.commons.navigation.DynamicMenu;


/**
 * Manages user settings context.
 * 
 * @author Rainer Eschen
 * 
 */
public class Context extends BackingBeanForm {

    private static final long serialVersionUID = 1269573046943299859L;

    @Autowired
    private DynamicMenu dynamicMenuBean;

    /**
     * Settings of current user.
     */
    Settings settings = new Settings();

    /**
     * Activate en locale.
     */
    public void switchToEn() {

        this.getSettings().setLocale("en");
    }

    /**
     * Activate de locale.
     */
    public void switchToDe() {

        this.getSettings().setLocale("de");
    }

    /**
     * Simple switcher for menu presentation
     */
    public String switchMenu() {
        this.getSettings().setDynamicMenu(!this.getSettings().getDynamicMenu());
        return null;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    /**
     * Deliver current locale for Facelets template.
     * 
     * @return locale
     */
    public java.util.Locale getLocale() {

        return this.getSettings().getLocale().getLocale();
    }

    /**
     * Deliver current locale for Facelets template.
     * 
     * @return locale as string
     */
    public String getLocaleCode() {

        return this.getSettings().getLocale().getCode();
    }

    /**
     * Deliver list of locales.
     * 
     * @return list of locales
     */
    public List<Locale> getLocales() {

        return this.getSettings().getLocales();
    }

    /**
     * Deliver list of current skins.
     * 
     * @return list of skins
     */
    public List<Skin> getSkins() {
        return this.getSettings().getSkins();
    }

    /**
     * Deliver current skin for Facelets template.
     * 
     * @return skin
     */
    public String getSkin() {

        return this.getSettings().getSkin();
    }

    /**
     * Define new locale selection.
     * 
     * @param code locale id
     */
    public void setLocale(String code) {
        this.getSettings().setLocale(code);
    }

    /**
     * Define new skin selection.
     * 
     * @param code skin id
     */
    public void setSkin(String code) {

        this.getSettings().setSkin(code);
    }

    /**
     * Deliver current menu modus for Facelets template.
     * 
     * @return true: show dynamic menu
     */
    public Boolean getDynamicMenu() {

        return this.getSettings().getDynamicMenu();
    }
}
