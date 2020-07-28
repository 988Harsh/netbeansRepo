/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
    
    org.springframework.web.servlet.HandlerInterceptor
    org.springframework.web.servlet.handler.HandlerInterceptorAdapter

 */
package com.harsh.practice;


import com.harsh.practice.service.StudentService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @RequestMapping("/showForm")
    public String showAddForm(Model StudentModel){
        
        Student theStudent = new Student();
        StudentModel.addAttribute("student",theStudent);        
        return "student-form";
    }
    
    
    @RequestMapping("/processForm")
    public String processForm( @ModelAttribute("student") Student st, HttpServletRequest req){

        studentService.saveStudent(st);
        return "redirect:/student/showStudents";
    }
    
    @RequestMapping("/showStudents")
    public String showData(Model theModel, HttpServletResponse response)
    {
        
        
	List<Student> theStudents = studentService.getStudents();
	theModel.addAttribute("theStudents", theStudents);
	return "show-student";
    }
    
    
    
    @RequestMapping("/editStudent")
    public String displayEditForm(HttpServletRequest req, Model theModel)
    {
         int id = Integer.parseInt(req.getParameter("id"));
        Student theStudent = studentService.getStudent(id);
        theModel.addAttribute("student", theStudent);
        return "edit-student-form";
    }
    
    @RequestMapping("/deleteStudent")
    public String deleteStudent(HttpServletRequest req,Model theModel)
    {
        int id = Integer.parseInt(req.getParameter("id"));
        studentService.deleteStudent(id);
       
        return "redirect:/student/showStudents";
       
    }
    
}
