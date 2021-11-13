package com.rmgyantra.GenericUtility;
	
	public class UserPojoLib {
		
	String 	designation;
	String dob;
	String email;
	String empName;
	double experience;
	String mobileNo;
	String project;
	String role;
	String username;
	public UserPojoLib(String designation, String dob, String email, String empName, double experience, String mobileNo,
			String project, String role, String username) {
		this.designation = designation;
		this.dob = dob;
		this.email = email;
		this.empName = empName;
		this.experience = experience;
		this.mobileNo = mobileNo;
		this.project = project;
		this.role = role;
		this.username = username;
	}
	
	
	public String getDesignation() {
		return designation;
	}


	public String getDob() {
		return dob;
	}


	public String getEmail() {
		return email;
	}


	public String getEmpName() {
		return empName;
	}


	public double getExperience() {
		return experience;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public String getProject() {
		return project;
	}


	public String getRole() {
		return role;
	}


	public String getUsername() {
		return username;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setExperience(double experience) {
		this.experience = experience;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	}
