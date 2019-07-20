/* Author: Ken Lee
 * Project: JPA SMS
 * Date: 7/2/2019
 */

package com.sms.main;



import java.util.*;

import com.sms.entities.Course;
import com.sms.entities.Student;
import com.sms.services.CourseService;
import com.sms.services.StudentServices;


public class SMSMainRunner {
	
	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) 
	{	

		System.out.println("Welcome to the Student Management System APP");

		int choice;
		
		do {
			System.out.println("Are you a(n)\n"
					+ "1. Student\n"
					+ "2. Quit\n");
					//+ "3. Admin only testing"); 
			choice = console.nextInt();
				
			switch (choice) {
			case 1:
				System.out.println("Enter your email");
				// Correct login method
				console.nextLine(); // Eat line
				String enteredEmail = console.nextLine();
				
				System.out.println("Enter your password");
				String enteredPassword = console.nextLine();
				isStudent(enteredEmail, enteredPassword);
				System.out.println("Your current courses are: ");
				//System.out.println(" Course Name                                     Instructor Name");
				//String studentEmail = studentServices.validateStudent(enteredEmail, enteredPassword);
				
				StudentServices studentService = new StudentServices();
				
				// Gets student courses by email
				List<Course> courseList = studentService.getStudentCourses(enteredEmail);
				for (Course e : courseList)
					System.out.println(e.toString());
				
				
					System.out.println("1. Register to Class\n"
									 + "2. Quit\n");
					
					int register = console.nextInt();
					//console.nextLine(); // Eat line
					switch (register) {
					
					// Register for course
					case 1: 
						System.out.println("All courses: ");
						System.out.println("Id  " + " Course name  " + " Instructor Name");
						showAllCourses();
						System.out.println("Which course? ");
						int newCourse = console.nextInt(); 
						System.out.println(newCourse);

						registerToCourse(enteredEmail, newCourse);
						
						break;
						
					// Exit
					case 2:
						System.out.println("Exiting App");
						System.exit(0);
						
					default: 
						System.out.println("Invalid choice, try again!");
						continue;
					
					}

				break;

			case 2: 
				System.out.println("Exiting App");
				System.exit(0);
				
			 //Testing purposes, option 3 not intended for public release.	
//			case 3:
//
//				showAllStudents();
//				showAllCourses();
//				
//				
//				break;
				
			default: 
				System.out.println("Invalid choice, try again!");
				continue;
			}
		}
		while (choice !=2);
	}
	
	private static void showAllStudents() 
	{
		StudentServices studentServices = new StudentServices();
		List<Student> studentList = new ArrayList<>();
		studentList = studentServices.getAllStudents();
		for (Student e: studentList) {
			System.out.println(e.toString());
		}
	}
		
		private static void showAllCourses() 
		{
			CourseService courseServices = new CourseService();
			List<Course> courseList = new ArrayList<>();
			courseList = courseServices.getAllCourses();
			for (Course e: courseList) 
			{
				System.out.println(e.toString());
			}
		}
		
		private static void isStudent(String sEmail, String sPassword) 
		{
			StudentServices studentService = new StudentServices();
			boolean studentList = studentService.validateStudent(sEmail, sPassword);
			if (studentList == true) 
			{
				System.out.println("Student login successfull");
				
			} else 
			{
				System.out.println("Student not found!");
			}
		}
		
		private static void showStudentByEmail(String sEmail) 
		{
			StudentServices studentService = new StudentServices();
			boolean foundStudent = studentService.getStudentByEmail(sEmail) != null;

		}
			
		private static void showStudentCourses(String sEmail) 
		{
			StudentServices studentService = new StudentServices();
			List<Course> courseList = studentService.getStudentCourses(sEmail);
			System.out.println("showStudentCourses: ");
			for (Course e : courseList) {
				System.out.println(e.toString());
			}
		}
		
		private static void registerToCourse(String sEmail, int cId) 
		{
			StudentServices studentService = new StudentServices();
			studentService.registerStudentToCourse(sEmail, cId);
		}
				
		private static void createCourse(Course course) 
		{
			CourseService courseServices = new CourseService();
			boolean result = courseServices.addCourse(course);
			System.out.println(result ? "Course saved" : "Course is not saved");
		}
}
