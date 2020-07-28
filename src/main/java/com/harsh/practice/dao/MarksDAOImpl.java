/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsh.practice.dao;

import com.harsh.practice.Marks;
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
public class MarksDAOImpl implements MarksDAO{
    
    @Autowired
    private SessionFactory sessionFactory;
			
	@Override
	public List<Marks> getMarks() {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
				
		
		Query<Marks> theQuery = 
				currentSession.createQuery("from Marks",Marks.class);
		
		
		List<Marks> Markss = theQuery.getResultList();
				
			
		return Markss;
	}

	@Override
	public void saveMarks(Marks theMarks, int student_id) {

		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Student st = currentSession.get(Student.class, student_id);
                System.out.println(theMarks);
                theMarks.setStudent(st);
                st.add(theMarks);
                currentSession.saveOrUpdate(st);
                
                Session nextCurrentSession = sessionFactory.getCurrentSession();
                nextCurrentSession.save(theMarks);
//                
//                Session nextCurrentSession = sessionFactory.getCurrentSession();
//		
//                nextCurrentSession.saveOrUpdate(theMarks);
//                
		
		
	}

	@Override
	public Marks getMarks(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Marks theMarks = currentSession.get(Marks.class, theId);
		
		return theMarks;
	}

	@Override
	public void deleteMarks(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Marks where id=:MarksId");
		theQuery.setParameter("MarksId", theId);
		
		theQuery.executeUpdate();		
	}
    
}
