package com.googlecode.icefusion.ui.commons.form;


import java.io.Serializable;


/**
 * Defines all methods for login management.
 * 
 * @author Rainer Eschen
 * 
 */
public interface ILogin extends Serializable {

    /**
     * Delivers login username
     * 
     * @param username input string
     */
    public void setLoginUsername(String username);

    /**
     * Delivers login password
     * 
     * @param password input string
     */
    public void setLoginPassword(String password);

    /**
     * Action handler for login
     * 
     * @return navigation id
     */
    public String loginAction();
}
