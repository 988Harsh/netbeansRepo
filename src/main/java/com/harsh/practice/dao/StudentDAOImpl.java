/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsh.practice.dao;

import com.harsh.practice.Student;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenovo
 */
@Repository
public class StudentDAOImpl implements StudentDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
			
	@Override
	public List<Student> getStudents() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Student> theQuery = 
				currentSession.createQuery("from Student",Student.class);
		
		// execute query and get result list
		List<Student> Students = theQuery.getResultList();
				
		// return the results		
		return Students;
	}

	@Override
	public void saveStudent(Student theStudent) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the Student ... finally LOL
		currentSession.saveOrUpdate(theStudent);
		
	}

	@Override
	public Student getStudent(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Student theStudent = currentSession.get(Student.class, theId);
		
		return theStudent;
	}

	@Override
	public void deleteStudent(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Student where id=:StudentId");
		theQuery.setParameter("StudentId", theId);
		
		theQuery.executeUpdate();		
	}
    
}
