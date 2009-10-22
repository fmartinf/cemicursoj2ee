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

public class UserAction extends ActionSupport{

    private User user;
    
    public UserAction() {
    }

    public String execute() {
        return SUCCESS;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

}