/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsh.practice.dao;

import com.harsh.practice.Student;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenovo
 */
@Repository
public interface StudentDAO {
    
        public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudent(int theId);

	public void deleteStudent(int theId);
    
}
