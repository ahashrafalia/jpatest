package com.jpatest.model;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UNIV")
public class Univ {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="common_seq")
	@SequenceGenerator(name="common_seq",allocationSize=1,sequenceName="common_seq")
	@Column(name = "UNIV_ID")
	private long univId;

	@Column(name = "UNIVNAME", nullable = false, unique = true)
	private String univName;
	
	@OneToMany(mappedBy="univ",cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=Courses.class)
	private  Collection<Courses> courses;
	
	@OneToOne(optional=false,cascade=CascadeType.ALL, fetch=FetchType.EAGER,
		       mappedBy="univ",targetEntity=UnivAddress.class)
	private UnivAddress univAddress;

	public long getUnivId() {
		return univId;
	}

	public void setUnivId(long univId) {
		this.univId = univId;
	}

	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	public Collection<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Collection<Courses> courses) {
		this.courses = courses;
	}

	public UnivAddress getUnivAddress() {
		return univAddress;
	}

	public void setUnivAddress(UnivAddress univAddress) {
		this.univAddress = univAddress;
	}

	@Override
	public String toString() {
		return "Univ [univId=" + univId + ", univName=" + univName + ", courses=" + courses + ", univAddress="
				+ univAddress + "]";
	}

	

}