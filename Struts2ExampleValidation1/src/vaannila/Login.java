/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vaannila;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Meyyappan Muthuraman
 */
public class Login extends ActionSupport {

    private String userName;
    private String password;

    public Login() {
    }

    @Override
    public String execute() {
    	System.out.println("executing..");
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (getUserName().length() == 0) {
            addFieldError("userName", "User Name is required");
        } else if (!getUserName().equals("Eswar")) {
            addFieldError("userName", "Invalid User");
        }
        if (getPassword().length() == 0) {
            addFieldError("password", getText("password.required"));
        }
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}