
package com.harsh.practice.service;

import com.harsh.practice.Marks;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public interface MarksService {
    
        public List<Marks> getMarks();

	public void saveMarks(Marks theMarks, int student_id);

	public Marks getMarks(int theId);

	public void deleteMarks(int theId);
    
}
