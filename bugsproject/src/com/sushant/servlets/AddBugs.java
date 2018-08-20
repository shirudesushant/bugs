package com.sushant.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sushant.beans.BugsBean;
import com.sushant.dao.BugsDao;


@WebServlet("/AddBugs")
public class AddBugs extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String id=request.getParameter("id");
	 	String name=request.getParameter("name");
		String assigned=request.getParameter("assigned");
		String status=request.getParameter("status");
		BugsBean bean=new BugsBean(id,name,assigned,status);
		int state=BugsDao.save(bean);
         out.println("Bug is added successfully!");
		
		request.getRequestDispatcher("AddBugs.html").include(request, response);
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
