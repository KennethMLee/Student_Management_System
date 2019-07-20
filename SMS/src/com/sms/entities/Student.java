package com.sms.entities;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
@NamedQueries ({
@NamedQuery (query = "SELECT e FROM Student e", name = "queryAllStudents")
//@NamedQuery (query = "SELECT e FROM Student e WHERE e.SEmail = :pemail", name = "queryStudentByEmail")
})
public class Student 
{
	// Primary Key, Not Null
	// Student’s current school email, unique student identifier
	@Id
	@Column(name="email", length=50)
	private String sEmail;
	
	// Not Null
	// The full name of the student
	@Basic
	@Column(name="name",nullable=false,length=50)
	private String sName;
	
	// Not null
	@Basic
	@Column(name="password",nullable=false,length=50)
	private String sPassword;
	
	@OneToMany(targetEntity=Course.class)
	private List<Course> sCourses;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String email, String name, String password) {
		super();
		this.sEmail = email;
		this.sName = name;
		this.sPassword = password;
	}

	@Override
	public String toString() {
		return "Student Email: " + sEmail + ", Name: " + sName + ", Password: " + sPassword + ", Courses: " + sCourses;
	}

	public String getEmail() {
		return sEmail;
	}

	public void setEmail(String email) {
		this.sEmail = email;
	}

	public String getName() {
		return sName;
	}

	public void setName(String name) {
		this.sName = name;
	}

	public String getPassword() {
		return sPassword;
	}

	public void setPassword(String password) {
		this.sPassword = password;
	}
	
	public List<Course> getCourses() {
		return sCourses;
	}
	
	public void setCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student other = (Student)obj;
			boolean sameEmail = (this.getEmail().equals(other.getEmail()));
			boolean sameName = (this.getName().equals(other.getName()));
			boolean samePassword = (this.getPassword().equals(other.getPassword()));
			if(sameEmail && sameName && samePassword) return true;
			else return false;
		}
		else {
			return false;
		}
	}
}
