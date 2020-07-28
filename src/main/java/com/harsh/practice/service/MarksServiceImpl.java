/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsh.practice.service;

import com.harsh.practice.Marks;
import com.harsh.practice.dao.MarksDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lenovo
 */
@Service
public class MarksServiceImpl implements MarksService {
    
        @Autowired
	private MarksDAO marksDAO;
	
	@Override
	@Transactional
	public List<Marks> getMarks() {
		return marksDAO.getMarks();
	}

	@Override
	@Transactional
	public void saveMarks(Marks theMarks, int student_id) {

		marksDAO.saveMarks(theMarks, student_id);
	}

	@Override
	@Transactional
	public Marks getMarks(int theId) {
		
		return marksDAO.getMarks(theId);
	}

	@Override
	@Transactional
	public void deleteMarks(int theId) {
		
		marksDAO.deleteMarks(theId);
	}
    
}
