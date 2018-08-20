package com.sushant.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/LogoutDeveloper")
public class LogoutDeveloper extends HttpServlet {

   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		java.io.PrintWriter out=response.getWriter();
		out.println("<h1>Developer Logout Success</h1>");
		HttpSession session=request.getSession();
		session.invalidate();
		request.getRequestDispatcher("DeveloperLoginForm.html").include(request, response);
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
