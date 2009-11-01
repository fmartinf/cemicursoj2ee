package com.googlecode.icefusion.ui.commons.navigation;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.icefusion.ui.commons.BackingBean;
import com.googlecode.icefusion.ui.commons.constant.ICEfusionConsts;
import com.icesoft.faces.component.menubar.MenuItem;


/**
 * Dynamic menu management. Navigation ids of the static menu are used.
 * 
 * @see com.googlecode.icefusion.ui.commons.constant.Context#getDynamicMenu() dynamicMenuMode
 * 
 * @author Rainer Eschen
 * 
 */
public class DynamicMenu extends BackingBean {

    private static final long serialVersionUID = -7000315155508809970L;

    @Autowired
    private ICEfusionConsts consts;

    @Autowired
    private Menu menu;

    /**
     * Menu structure. The class has to handle this as a singleton. If the locale is changed during a session this list
     * has to be reseted, to load corresponding resource bundle entries again.
     */
    ArrayList<MenuItem> dynamicMenu = new ArrayList<MenuItem>();

    /**
     * Defines values for main menu creation: navigationId, label.
     */
    LinkedHashMap<String, String> mainMenu = new LinkedHashMap<String, String>();

    // Add your menu items here

    // ICEfusion standard entries

    /**
     * Defines values for extra menu creation: navigationId, label.
     */
    LinkedHashMap<String, String> extraMenu = new LinkedHashMap<String, String>();

    /**
     * Prepare structure for menu creation.
     */
    protected void init() {

	// Add your menu items here
	
        // ICEfusion standard entries
        mainMenu.put("extra", consts.getLocalized("application.menu.extra", "icefusion"));

        extraMenu.put("settings", consts.getLocalized("application.menu.extra.settings", "icefusion"));
        extraMenu.put("about", consts.getLocalized("application.menu.extra.about", "icefusion"));
    }

    /**
     * Adds a single entry to the main menu.
     * 
     * @param parent node to add the entry
     * @param entry parameter to create a menu entry
     */
    protected MenuItem addEntry(List<MenuItem> parent, Entry<String, String> entry) {

        MenuItem menuItem = new MenuItem();
        menuItem.setValue(entry.getValue());
        menuItem.setId(entry.getKey());
        menuItem.addActionListener(new DynamicMenuActionListener());
        parent.add(menuItem);
        return menuItem;
    }

    /**
     * Adds a single entry to any sub menu.
     * 
     * @param parent node to add the entry
     * @param entry parameter to create a menu entry
     */
    protected MenuItem addEntry(MenuItem parent, Entry<String, String> entry) {

        MenuItem menuItem = new MenuItem();
        menuItem.setValue(entry.getValue());
        menuItem.setId(entry.getKey());
        menuItem.addActionListener(new DynamicMenuActionListener());
        parent.getChildren().add(menuItem);
        return menuItem;
    }

    /**
     * Delivers the ICEfaces menu model to render.
     * 
     * @return tree of menu entries
     */
    public List<MenuItem> getMenuModel() {

        if (!this.dynamicMenu.isEmpty()) {
            return this.dynamicMenu;
        }

        this.init();
        for (Entry<String, String> main : mainMenu.entrySet()) {
            MenuItem mainItem = this.addEntry(this.dynamicMenu, main);

            // Add your menu items here

            // ICEfusion standard entries
            if (main.getKey().equals("extra")) {
                for (Entry<String, String> extra : extraMenu.entrySet()) {
                    MenuItem extraItem = this.addEntry(mainItem, extra);
                }
            }
        }
        return this.dynamicMenu;
    }


    /**
     * Resets current menu definition for locale changes.
     */
    public void resetDynamicMenu() {
        if (this.dynamicMenu != null) {
            this.dynamicMenu.clear();
        }
    }

}
