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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UNIV_ADDRESS")
public class UnivAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="common_seq")
	@SequenceGenerator(name="common_seq",allocationSize=1,sequenceName="common_seq")
	@Column(name = "ADDRESS_ID")
	private long addressId;

	@Column(name = "STREET", nullable = true)
	private String street;
	
	@Column(name = "CITY", nullable = true)
	private String city;
	
	@OneToOne(optional=false)
	@JoinColumn(name="UNIV_ID")
	private  Univ univ;

	@Override
	public String toString() {
		return "UnivAddress [addressId=" + addressId + ", street=" + street + ", city=" + city + ", univ=" + univ + "]";
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Univ getUniv() {
		return univ;
	}

	public void setUniv(Univ univ) {
		this.univ = univ;
	}

	
	
	
	

}