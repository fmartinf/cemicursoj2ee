/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cemi.appfinal.action;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import es.cemi.appfinal.util.Constants;
import es.cemi.appfinal.util.Utils;

/**
 * 
 * @author Meyyappan Muthuraman
 */
public class Login extends ActionSupport {

	private String email;
	private String password;

	public Login() {
	}

	@Override
	public String execute() {
		saveUserData();
		
		return SUCCESS;
	}

	/**
	 * Guarda en sesión los datos del usuario logado.
	 * @
	 * Precondición: tanto el <code>email</code> como el password han sido comprobados
	 * mediante validadores Struts
	 */
	private void saveUserData() {
		HashMap<String, Object> userSessionData = new HashMap();

		userSessionData.put(Constants.EMAIL_KEY, email);
		userSessionData.put(Constants.PASSWORD_KEY, password);
		userSessionData.put(Constants.LAST_ACCESS_KEY, Utils.getCurrentDate());
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute(Constants.USER_SESSION_PARAM, userSessionData);
	}

	/**
	 * getter & setters<br>
	 * ================
	 */

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}