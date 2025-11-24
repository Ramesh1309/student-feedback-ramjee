package com.cma.principal.entity;

import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student-feedback")
public class StudentFeedbackDBEntity {


	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_grade")
	private String studentGrade;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(name = "student_response", columnDefinition = "jsonb")
	private List<StudentResponse> studentResponse;

	@Column(name = "student_section")
	private String studentSection;

	@Id
	@Column(name = "student_id")
	private String studentID;

	

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}

	public List<StudentResponse> getStudentResponse() {
		return studentResponse;
	}

	public void setStudentResponse(List<StudentResponse> studentResponse) {
		this.studentResponse = studentResponse;
	}



	public String getStudentSection() {
		return studentSection;
	}

	public void setStudentSection(String studentSection) {
		this.studentSection = studentSection;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	

}
