/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cemi.appfinal.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import es.cemi.appfinal.util.Constants;

/**
 * @author cyague
 */
public class Logout extends ActionSupport {

	public Logout() {
	}

	@Override
	public String execute() {
		removeUserData();
		
		return SUCCESS;
	}

	/**
	 * Elimina de sesión los datos del usuario logado.
	 *
	 */
	private void removeUserData() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object userDataObj = session.getAttribute(Constants.USER_SESSION_PARAM);
		
		if (userDataObj != null) {
			session.removeAttribute(Constants.USER_SESSION_PARAM);
		}
	}

	/**
	 * getter & setters<br>
	 * ================
	 */

}