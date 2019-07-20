package com.sms.DAOI;

import java.util.List;

import com.sms.entities.Course;
import com.sms.entities.Student;

public interface StudentServiceDAOI 
{
	
	List<Student> getAllStudents();
	
	Student getStudentByEmail(String sEmail);
	
	boolean validateStudent(String sEmail, String sPassword);

	void registerStudentToCourse(String sEmail, int cId);

	List<Course> getStudentCourses(String sEmail);
	
}
