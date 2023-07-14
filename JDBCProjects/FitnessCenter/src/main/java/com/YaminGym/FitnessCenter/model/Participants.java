package com.YaminGym.FitnessCenter.model;

public class Participants {
	
	Integer pid;
	String studentFName;
	String studentLName;
	String studentEmail;
	String studentPhone;
	Integer batchId;
	
	public Participants() {
		
	}
	
	public Participants(String studentFName, String studentLName, String studentEmail, String studentPhone,
			int batchId) {
		super();
		this.studentFName = studentFName;
		this.studentLName = studentLName;
		this.studentEmail = studentEmail;
		this.studentPhone = studentPhone;
		this.batchId = batchId;
	}

	@Override
	public String toString() {
		return "Participants [studentFName=" + studentFName + ", studentLName=" + studentLName + ", studentEmail="
				+ studentEmail + ", studentPhone=" + studentPhone + ", batchTime=" + batchId + "]";
	}
	

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getStudentFName() {
		return studentFName;
	}

	public void setStudentFName(String studentFName) {
		this.studentFName = studentFName;
	}

	public String getStudentLName() {
		return studentLName;
	}

	public void setStudentLName(String studentLName) {
		this.studentLName = studentLName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	
	
	
	

}
