/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cemi.appfinal.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class FAQ extends ActionSupport {
	
	public static final String QUESTION = "Indique que le parece el framework Apache Struts 2:";
	
	private ArrayList<String> answersValues;	
	private String answer;

	public FAQ() {
	}
	
	public String init() {
		loadRadioAnswers();
		
		return "encuestar";
	}
		
	@Override
	public String execute() {
		return SUCCESS;
	}
	
	public String irMenu() {
		return "irMenu";
	}
	
	private void loadRadioAnswers() {
		answersValues = new ArrayList<String>();
		answersValues.add("Está muy bien");
		answersValues.add("Bueno, no está mal");
		answersValues.add("Demasiado lioso");
		answersValues.add("No me gusta nada");
	}
	
	/**
	 * getter & setters<br>
	 * ================
	 */
	
	
	
	public ArrayList<String> getAnswersValues() {
		return answersValues;
	}

	public static String getQuestion() {
		return QUESTION;
	}

	public void setAnswersValues(ArrayList<String> answersValues) {
		this.answersValues = answersValues;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}