package com.sushant.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/AddBugsForm")
public class AddBugsForm extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		java.io.PrintWriter out=response.getWriter();
         HttpSession session=request.getSession(false);
		
		if(session==null||session.getAttribute("developer")==null){
			out.println("<h1>Not Developer!</h1>");
			request.getRequestDispatcher("DeveloperLoginForm.html").include(request, response);
		}else{
			request.getRequestDispatcher("AddBugsForm.html").include(request, response);
		}
		out.close();
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
