package com.sushant.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DeveloperLogin")
public class DeveloperLogin extends HttpServlet {
	

   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		
PrintWriter out=((ServletResponse) response).getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(email.equals("developer@gmail.com")&&password.equals("developer123"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("developer","true");
			request.getRequestDispatcher("developer.html").include(request, response);

		}
		else
		{
			out.println("email or password is invalid");
			request.getRequestDispatcher("DeveloperLoginForm.html").include(request, response);
		}
	

		}

	protected void doPost(HttpServletRequest request, ServletResponse response) throws ServletException, IOException {
		
			}

}
