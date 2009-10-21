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

    public String execute() {
        return SUCCESS;
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