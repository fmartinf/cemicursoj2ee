package vaannila;

import com.opensymphony.xwork2.ActionSupport;

public class SampleAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	@Override
	public void validate()
	{
		System.out.println("validate() method called");
	}
	
	public String populate()
	{
		System.out.println("populate() method called");
		return "populate";
	}
	
	@Override
	public String execute()
	{
		System.out.println("execute() method called");
		return SUCCESS;
	}
}
