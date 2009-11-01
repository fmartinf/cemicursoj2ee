package com.googlecode.icefusion.ui.commons.navigation;


import com.googlecode.icefusion.ui.commons.BackingBean;


/**
 * Static menu management.
 * 
 * @see com.googlecode.icefusion.ui.commons.constant.Context#getDynamicMenu() dynamicMenuMode
 * 
 * @author Rainer Eschen
 * 
 */
public class Menu extends BackingBean {

    private static final long serialVersionUID = 1300411741204478711L;

    /**
     * Menu item action
     * 
     * @return next page id
     */
    public String menu1() {

        return "menu1";
    }

    /**
     * Menu item action
     * 
     * @return next page id
     */
    public String menu2() {

        return "menu2";
    }

    /**
     * Menu item action
     * 
     * @return next page id
     */
    public String menu3() {

        return "menu3";
    }
}
