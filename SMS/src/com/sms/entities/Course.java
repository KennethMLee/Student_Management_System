package com.sms.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries ({
@NamedQuery (query = "SELECT e FROM Course e", name = "queryCourseList")
})
public class Course 
{
	// Primary Key, not null
	// Unique Course Identifier
	@Id
	@Column(name="id")
	private int cId;
	// name of the course
	// not null
	@Basic
	@Column(name="name",nullable=false,length=50)
	private String cName;
	
	// name of the instructor
	// not null
	@Basic
	@Column(name="Instructor",nullable=false,length=50)
	private String cInstructorName;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int cId, String cName, String cInstructorName) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cInstructorName = cInstructorName;
	}

	@Override
	public String toString() {
		return "Course id: " + cId + ", Course Name: " + cName + ", Instructor: " + cInstructorName;
	}

	public int getcId() {
		return cId;
	}

	public void setCid(int cId) {
		this.cId = cId;
	}

	public String getCname() {
		return cName;
	}

	public void setName(String cName) {
		this.cName = cName;
	}

	public String getCinstructorName() {
		return cInstructorName;
	}

	public void setCinstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Course) {
			Course other = (Course)obj;
			boolean sameId = (this.getcId()==(other.getcId()));
			boolean sameInstructor = (this.getCinstructorName().equals(other.getCinstructorName()));
			boolean sameCourseName = (this.getCname().equals(other.getCname()));
			if(sameId && sameInstructor && sameCourseName) return true;
			else return false;
		}
		else {
			return false;
		}
	}
	
}
