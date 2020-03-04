package com.model;

public class Student {
	int studentNo;
	String studentName;
	String studentDept;
	public Student(){
		
	}
	public Student(int studentNo, String studentName, String studentDept) {
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.studentDept = studentDept;
	}
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentDept() {
		return studentDept;
	}
	public void setStudentDept(String studentDept) {
		this.studentDept = studentDept;
	}
}
