package com.sms.testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sms.entities.Course;
import com.sms.entities.Student;
import com.sms.services.StudentServices;

public class StudentServicesTest {
	
	StudentServices studentService = new StudentServices();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllStudents() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStudentByEmail() {
		Student expected = new Student();
		expected.setCourses(new ArrayList<Course>());
		expected.setEmail("aiannitti7@is.gd");
		expected.setName("Alexandra Iannitti");
		expected.setPassword("TWP4hf5j");
		Student actual = studentService.getStudentByEmail("aiannitti7@is.gd");
		Assert.assertEquals(expected.getEmail(), actual.getEmail());
	}

	@Test
	public void testValidateStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegisterStudentToCourse() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStudentCourses() {
		fail("Not yet implemented");
	}

}
