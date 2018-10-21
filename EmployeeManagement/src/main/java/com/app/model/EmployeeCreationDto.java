package com.app.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import com.app.entity.Address;
import com.app.entity.Department;

public class EmployeeCreationDto {

	private int id;
	private String name;
	private String email;
	private String designation;
	private String passowrd;
	private String contact;

	private Blob profilepic;
	private Date dob;
	private String salConfigured;
	private int hr;

	private Address address;

	private Department department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Blob getProfilepic() {
		return profilepic;
	}

	public void setProfilepic(Blob profilepic) {
		this.profilepic = profilepic;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSalConfigured() {
		return salConfigured;
	}

	public void setSalConfigured(String salConfigured) {
		this.salConfigured = salConfigured;
	}

	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmployeeCreationDto [id=" + id + ", name=" + name + ", email=" + email + ", designation=" + designation
				+ ", passowrd=" + passowrd + ", contact=" + contact + ", profilepic=" + profilepic + ", dob=" + dob
				+ ", salConfigured=" + salConfigured + ", hr=" + hr + ", address=" + address + ", department="
				+ department + "]";
	}

}
