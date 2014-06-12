package com.mago;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CheckLoginAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserInfo userInfo = (UserInfo)form;
		
		String userName = userInfo.getUserName();
		String password = userInfo.getPassword();
		
		ActionForward forward = new ActionForward();
		
		if("hujiangtao1235@qq.com".equals(userName) && "123456".equals(password))
		{
			forward = mapping.findForward("successed");			
		}else{
			forward = mapping.findForward("failure");
		}
		
		return forward;
	}

}
