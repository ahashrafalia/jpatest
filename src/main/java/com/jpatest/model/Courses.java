package com.jpatest.model;

import java.util.Collection;

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
@Table(name = "COURSES")
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="common_seq")
	@SequenceGenerator(name="common_seq",allocationSize=1,sequenceName="common_seq")
	@Column(name = "COURSE_ID")
	private long courseId;

	@Column(name = "COURSENAME", nullable = false, unique = true)
	private String courseName;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="UNIV_ID")
	private  Univ univ;
	
	@OneToMany(mappedBy="courses",cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=Students.class)
	private  Collection<Students> students;

	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", univ=" + univ + ", students="
				+ students + "]";
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Univ getUniv() {
		return univ;
	}

	public void setUniv(Univ univ) {
		this.univ = univ;
	}

	public Collection<Students> getStudents() {
		return students;
	}

	public void setStudents(Collection<Students> students) {
		this.students = students;
	}

	

}