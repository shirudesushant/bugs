package com.sushant.beans;

public class BugsBean {
	private String id;
	private String name;
	private String assigned;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAssigned() {
		return assigned;
	}
	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BugsBean [id=" + id + ", name=" + name + ", assigned=" + assigned + ", status=" + status + "]";
	}
	public BugsBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BugsBean(String id, String name, String assigned, String status) {
		super();
		this.id = id;
		this.name = name;
		this.assigned = assigned;
		this.status = status;
	}
	
}
