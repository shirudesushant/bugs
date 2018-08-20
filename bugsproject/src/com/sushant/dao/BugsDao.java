package com.sushant.dao;
import java.sql.PreparedStatement;
import com.sushant.dao.DB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;


import com.sushant.beans.BugsBean;
public class BugsDao {
	public static int save(BugsBean bean){
		int state=0;
		try
		{
			java.sql.Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into bugs(id,name,assigned,status) values(?,?,?,?)");
			ps.setString(1,bean.getId());
			ps.setString(2,bean.getName());
			ps.setString(3,bean.getAssigned());
			ps.setString(4,bean.getStatus());
			state=ps.executeUpdate();
			con.close();

		}catch(Exception ex){System.out.println(ex);}
		return state;
		
	}
	
	public static int update(BugsBean bean){
		int state=0;
		try
		{
			java.sql.Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update bugs set name=?,assigned=?,status=? where id=?");
			ps.setString(1,bean.getId());
			ps.setString(2,bean.getName());
			ps.setString(3,bean.getAssigned());
			ps.setString(4,bean.getStatus());
			state=ps.executeUpdate();
			con.close();

		}catch(Exception ex){System.out.println(ex);}
		return state;
		
	}
	
	public static int delete(String id){
		int state=0;
		try{
			Connection con=(Connection) DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from bugs where id=?");
			ps.setString(1,id);
			state=ps.executeUpdate();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return state;
	}
	
	public static int deleteByAssigned(String assigned){
		int state=0;
		try{
			Connection con=(Connection) DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from bugs where assigned=?");
			ps.setString(1,assigned);
			state=ps.executeUpdate();
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return state;
	}
	
	public static List<BugsBean> getAllRecords(){
		List<BugsBean> list=new ArrayList<BugsBean>();
		try{
			Connection con=(Connection) DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from bugs");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				BugsBean bean=new BugsBean();
				bean.setId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setAssigned(rs.getString(3));
				bean.setStatus(rs.getString(4));
				list.add(bean);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		return list;
		}
	
	public static List<BugsBean> getBugs(){
		List<BugsBean> list=new ArrayList<BugsBean>();
		try{
			Connection con=(Connection) DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from bugs where status=open");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				BugsBean bean=new BugsBean();
				bean.setId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setAssigned(rs.getString(3));
				bean.setStatus(rs.getString(4));
				list.add(bean);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list;
	}
	public static BugsBean getRecordByid(String id){
		BugsBean bean=new BugsBean();
		try{
			Connection con=(Connection) DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from bugs where id=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				bean.setId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setAssigned(rs.getString(3));
				bean.setStatus(rs.getString(4));
				
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return bean;
	}

	
	
}
