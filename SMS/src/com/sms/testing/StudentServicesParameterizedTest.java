package com.sms.testing;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.sms.entities.Course;
import com.sms.entities.Student;
import com.sms.services.CourseService;
import com.sms.services.StudentServices;


@RunWith(Parameterized.class)
public class StudentServicesParameterizedTest {
	
	StudentServices studentService = new StudentServices();
	static StudentServices studentServices;
	static CourseService courseServices;
	
	Student expected; 
	
	
	public StudentServicesParameterizedTest(Student expected) {
		super();
		this.expected = expected;
	}
	
	// Tested 2 correct from Database and 1 incorrect
	@Parameterized.Parameters
	public static Collection params() {
		return Arrays.asList(new Object[][] {
			{new Student("aiannitti7@is.gd", "Alexandra Iannitti", "TWP4hf5j")},
			{new Student("qllorens2@howstuffworks.com", "Quillan Llorens", "W6rJuxd")},
			{new Student("obvioushacker@hack.com", "Hack Man", "I_hack_you")}
		});
	}

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
		List<Student> studentList = studentServices.getAllStudents();
		for (Student expected : studentList) {
			assertTrue(studentList.contains(expected)); // Returns true if list matches the expected.
		}
	}

	@Test
	public void testGetStudentByEmail() {
		Student expected = expected.getEmail();
		Student actual = studentService.getStudentByEmail(actual.getEmail());
		Assert.assertEquals(expected, actual); // True if the data expected is the same as actual
	}

	@Test
	public void testValidateStudent() {
		boolean isValid = studentService.validateStudent(expected.getEmail(), expected.getPassword());
		assertTrue(isValid); // True if validated info matches the database.
	
	}

	@Test //not working
	public void testRegisterStudentToCourse() {
		CourseService courseServices = new CourseService();
		Course course = new Course(10, "Art", "Kingsly Doxsey");
		
		Student studentFound = studentServices.getStudentByEmail(expected.getEmail());
		System.out.println(studentFound.getEmail());
		
		
		studentServices.registerStudentToCourse(studentFound.getEmail(), course.getcId());
		List<Course> listCourse = studentServices.getStudentCourses(studentFound.getEmail());
		assertTrue(listCourse.contains(course));
	}

	@Test
	public void testGetStudentCourses() 
	{
		List<Course> listCourse = studentServices.getStudentCourses(expected.getEmail());
		
		for(Course e : listCourse)
			System.out.println(e.toString());
		
	}

}
