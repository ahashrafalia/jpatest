package com.jpatest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="common_seq")
	@SequenceGenerator(name="common_seq",allocationSize=1,sequenceName="common_seq")
	@Column(name = "STUDENT_ID")
	private long studentId;

	@Column(name = "STUDENTNAME", nullable = false, unique = true)
	private String studentName;
	
	
	
	@ManyToOne(optional=false)
	@JoinColumn(name="COURSE_ID")
	private  Courses courses;



	public long getStudentId() {
		return studentId;
	}



	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}



	public String getStudentName() {
		return studentName;
	}



	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}



	public Courses getCourses() {
		return courses;
	}



	public void setCourses(Courses courses) {
		this.courses = courses;
	}



	@Override
	public String toString() {
		return "Students [studentId=" + studentId + ", studentName=" + studentName + ", courses=" + courses + "]";
	}

		

}