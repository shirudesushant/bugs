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


@WebServlet("/findbug")
public class findbugs extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		BugsBean bean=BugsDao.getRecordByid(id);
		
		if(bean.getId() != null){
			out.println("<table class='table table-bordered table-striped'>");
			out.print("<tr><td>Id:</td><td>"+bean.getId()+"</td></tr>");
			out.print("<tr><td>Name:</td><td>"+bean.getName()+"</td></tr>");
			out.print("<tr><td>Assigned:</td><td>"+bean.getAssigned()+"</td></tr>");
			out.print("<tr><td>Status:</td><td>"+bean.getStatus()+"</td></tr>");
			out.print("</table>");
			}else{
				out.println("<p>Sorry, No Record found for "+id+"</p>");
			}
		
			out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
