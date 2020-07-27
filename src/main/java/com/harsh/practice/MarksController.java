/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsh.practice;

import com.harsh.practice.service.MarksService;
import com.harsh.practice.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping("/marks")
public class MarksController {
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private MarksService marksService;
    
    @RequestMapping("/addMarks")
    public String showStudents(Model studentModel)
    {
        
        List<Student> theStudents = studentService.getStudents();
	studentModel.addAttribute("theStudents", theStudents);
        return "show-student-add-marks";
    }
    
    @RequestMapping("/getMarksStudent")
    public String showMarksStudent(@RequestParam("id") int id,Model marksModel)
    {
        Student st = studentService.getStudent(id);
        System.out.println(st);
        List<Marks> marks = st.getMarks();
        marksModel.addAttribute("student",st);
        marksModel.addAttribute("marks",marks);
        return "show-marks-of-student";
    }
    
    
    
    @RequestMapping("/addMarksStudent")
    public String addMarksForm(HttpServletRequest req,Model studentMarksModel)
    {
        int student_id = Integer.parseInt(req.getParameter("id"));
        
        Marks marks = new Marks();
        
        studentMarksModel.addAttribute("id",student_id);
        studentMarksModel.addAttribute("marks",marks);
        return "marks-form";
    }
    
    @RequestMapping("/addToMarks")
    public String finalAdd(@RequestParam("id") int id,@ModelAttribute("marks") Marks marks)
    {
        System.out.println(marks);
        marksService.saveMarks(marks, id);
        
        
        return "redirect:/";
    }
    
    
}
