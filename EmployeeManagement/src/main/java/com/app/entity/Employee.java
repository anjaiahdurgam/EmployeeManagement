package com.app.entity;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "EMPLOYEE_TB")
public class Employee {

	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String lastName;

	private String email;
	private String designation;
	private String passowrd;
	private String contact;
	private boolean status;
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Lob
	private Blob profilepic;

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date dob;
	private String gender;
	private String salConfigured;

	@Transient
	private Address address;

	@Transient
	private Department department;

	@ManyToOne
	private Hr hr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSalConfigured() {
		return salConfigured;
	}

	public void setSalConfigured(String salConfigured) {
		this.salConfigured = salConfigured;
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

	public Hr getHr() {
		return hr;
	}

	public void setHr(Hr hr) {
		this.hr = hr;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", designation=" + designation + ", passowrd=" + passowrd + ", contact=" + contact + ", profilepic="
				+ profilepic + ", dob=" + dob + ", gender=" + gender + ", salConfigured=" + salConfigured + ", address="
				+ address + ", department=" + department + ", hr=" + hr + "]";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String firstName, String lastName, String email, String designation, String passowrd,
			String contact, Blob profilepic, Date dob, String gender, String salConfigured, Address address,
			Department department, Hr hr) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.designation = designation;
		this.passowrd = passowrd;
		this.contact = contact;
		this.profilepic = profilepic;
		this.dob = dob;
		this.gender = gender;
		this.salConfigured = salConfigured;
		this.address = address;
		this.department = department;
		this.hr = hr;
	}

}