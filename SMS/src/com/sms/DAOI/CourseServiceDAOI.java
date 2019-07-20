package com.sms.DAOI;

import java.util.List;

import com.sms.entities.Course;

public interface CourseServiceDAOI {

	boolean addCourse(Course course);

	List<Course> getAllCourses();


	//getAllCourses();
}
