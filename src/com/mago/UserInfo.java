package com.mago;

import org.apache.struts.action.ActionForm;

public class UserInfo extends ActionForm {

	/**
	 * This is an Action Form Bean that storage the User Login Info
	 */
	private static final long serialVersionUID = -966107637534939116L;
	
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
