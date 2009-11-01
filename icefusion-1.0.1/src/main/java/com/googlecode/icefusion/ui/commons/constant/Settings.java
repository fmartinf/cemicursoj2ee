package com.googlecode.icefusion.ui.commons.constant;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * User-specific management of settings. Managed via database.
 * 
 * @author Rainer Eschen
 * 
 */
@Entity
public class Settings implements Serializable {

    private static final long serialVersionUID = -2399150011059153566L;

    /**
     * Database identifier.
     */
    @Id
    Long id;

    /**
     * Current locale.
     */
    Locale locale;

    /**
     * Possible locales.
     */
    List<Locale> locales;

    /**
     * Current skin.
     */
    Skin skin;

    /**
     * Possible skins.
     */
    List<Skin> skins;


    /**
     * true: render the dynamic menu instead of the static one. The static menu has to be defined in the Facelets tag
     * &lt;icefusion:menu/&gt;
     * 
     * @see com.googlecode.icefusion.ui.commons.navigation.Menu dynamicMenuDefinition
     * 
     */
    private Boolean dynamicMenu;

    /**
     * Initialize settings independent from database.
     */
    protected void init() {

        dynamicMenu = false;

        locales = new ArrayList<Locale>();

        Locale locale = new Locale();
        locale.setCode("en");
        locale.setLabel("application.locale.en");
        locales.add(locale);

        this.locale = locale;

        locale = new Locale();
        locale.setCode("de");
        locale.setLabel("application.locale.de");
        locales.add(locale);

        skins = new ArrayList<Skin>();

        Skin skin = new Skin();
        skin.setCode("icefusion");
        skin.setLabel("application.skin.icefusion");
        skins.add(skin);

        this.skin = skin;

        skin = new Skin();
        skin.setCode("icesaurian");
        skin.setLabel("application.skin.icesaurian");
        skins.add(skin);
    }

    /**
     * Find a locale with the code.
     * 
     * @param code Two digit code
     * @return Found locale
     */
    protected Locale findLocaleFromCode(String code) {
        for (Locale locale : this.getLocales()) {
            if (locale.getCode().equals(code)) {
                return locale;
            }
        }
        throw new NullPointerException("No locale found with code [" + code + "]");
    }

    @Basic
    public Locale getLocale() {
        if (locale == null) {
            this.init();
        }
        return locale;
    }

    @Basic
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Basic
    public void setLocale(String locale) {
        this.locale = this.findLocaleFromCode(locale);
    }

    @Basic
    public List<Locale> getLocales() {
        if (locales == null) {
            this.init();
        }
        return locales;
    }

    @Basic
    public void setLocales(List<Locale> locales) {
        this.locales = locales;
    }

    /**
     * Find a skin with the code.
     * 
     * @param code Skin code
     * @return Found skin
     */
    protected Skin findSkinFromCode(String code) {
        for (Skin skin : this.getSkins()) {
            if (skin.getCode().equals(code)) {
                return skin;
            }
        }
        throw new NullPointerException("No skin found with code [" + code + "]");
    }

    @Basic
    public String getSkin() {
        if (skin == null) {
            this.init();
        }
        return skin.getCode();
    }

    @Basic
    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    @Basic
    public void setSkin(String skin) {
        this.skin = this.findSkinFromCode(skin);
    }

    @Basic
    public List<Skin> getSkins() {
        if (skins == null) {
            this.init();
        }
        return skins;
    }

    @Basic
    public void setSkins(List<Skin> skins) {
        this.skins = skins;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDynamicMenu() {
        return dynamicMenu;
    }

    public void setDynamicMenu(Boolean dynamicMenu) {
        this.dynamicMenu = dynamicMenu;
    }
}
