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

@WebServlet("/TesterLogin")
public class TesterLogin extends HttpServlet {
	

   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		
PrintWriter out=((ServletResponse) response).getWriter();
		response.setContentType("text/html");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(email.equals("tester@gmail.com")&&password.equals("tester123"))
		{
			HttpSession session=request.getSession();
			session.setAttribute("tester","true");
			request.getRequestDispatcher("tester.html").include(request, response);

		}
		else
		{
			out.println("email or password is invalid");
			request.getRequestDispatcher("TesterLoginForm.html").include(request, response);
		}
	

		}

	protected void doPost(HttpServletRequest request, ServletResponse response) throws ServletException, IOException {
		
			}

}
