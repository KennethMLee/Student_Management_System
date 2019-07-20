package com.sms.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.sms.DAOI.CourseServiceDAOI;
import com.sms.entities.Course;


public class CourseService implements CourseServiceDAOI{
	
	// –This method takes no parameter and 
	// returns every Course in the table.
	@Override
	public List<Course> getAllCourses(){
		List<Course> courseList = new ArrayList<>();		
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("SMS");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		
//		Query query = entitymanager.createQuery("SELECT e FROM Items e");
		Query query = entitymanager.createNamedQuery("queryCourseList");
		courseList = query.getResultList();
		
		entitymanager.close();
		entitymanagerfactory.close();
		
		return courseList;
	}
	
	@Override
	public boolean addCourse(Course course) {
		boolean result = true;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sms01");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(course);
			entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.getMessage();
			result = false;
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return result;
	}
		
//		@Override
//		public Course getCoursesById(int cid) {
//			Course foundCourse = null;
//			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sms01");
//			EntityManager entityManager = entityManagerFactory.createEntityManager();
//			try {
//				foundCourse = entityManager.find(Course.class, cid);
//			} catch (PersistenceException e) {
//				e.getMessage();
//			} finally {
//				entityManager.close();
//				entityManagerFactory.close();
//			}
//			return foundCourse;
//		}

}
