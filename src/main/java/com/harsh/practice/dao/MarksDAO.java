/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsh.practice.dao;

import com.harsh.practice.Marks;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenovo
 */
@Repository
public interface MarksDAO {
    
        public List<Marks> getMarks();

	public void saveMarks(Marks theMarks, int student_id);

	public Marks getMarks(int theId);

	public void deleteMarks(int theId);
    
}
