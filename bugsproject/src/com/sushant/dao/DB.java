package com.sushant.dao;
import java.sql.Connection;
import java.sql.DriverManager;


public class DB {
	public static Connection getCon(){
		Connection con=null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3307/bugsdb","root","sushant");
		}
		catch(Exception ex){System.out.println(ex);}
		return con;
		}
}
