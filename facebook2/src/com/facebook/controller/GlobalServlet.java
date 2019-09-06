package com.facebook.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebook2.entity.FacebookEmployee;
import com.facebook2.service.FacebookService;
import com.facebook2.service.FacebookServiceInterface;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet
{
	protected void service(HttpServletRequest rqs,HttpServletResponse rsp)throws ServletException,IOException
	{
		rsp.setContentType("text/html");
		PrintWriter out=rsp.getWriter();
		out.println("<html><body>");
		String option=rqs.getParameter("ac");
		if(option.equals("register"))
		{
			String name=rqs.getParameter("name");
			String pass=rqs.getParameter("pass");
			String email=rqs.getParameter("email");
			String address=rqs.getParameter("address");
			FacebookEmployee fe=new FacebookEmployee();
			fe.setName(name);
			fe.setPass(pass);
			fe.setEmail(email);
			fe.setAddress(address);
			FacebookServiceInterface fs=FacebookService.createServiceObject();
			int i=fs.createProfile(fe);
			if(i>0) {
				out.println("profile is created");
				
			}
			else {
				out.println("profile is not created");
				
			}
			
		
			
		}
		
	
	if(option.equals("login"))
	{
		
	}
	if(option.equals("timeline")) {
		
	}
	out.println("</body></html>");
	}
}


