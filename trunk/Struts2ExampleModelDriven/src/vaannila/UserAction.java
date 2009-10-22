/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vaannila;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * @author Meyyappan Muthuraman
 */
public class UserAction extends ActionSupport implements ModelDriven {

    private User user = new User();

    public UserAction() {
    }

    public Object getModel() {
        return user;
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