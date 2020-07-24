/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
    
    org.springframework.web.servlet.HandlerInterceptor
    org.springframework.web.servlet.handler.HandlerInterceptorAdapter

 */
package com.harsh.practice;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    
    @RequestMapping("/showForm")
    public String showAddForm(Model StudentModel){
        
        Student theStudent = new Student();
        StudentModel.addAttribute("student",theStudent);        
        return "student-form";
    }
    
    @RequestMapping("/processForm")
    public String processForm( @ModelAttribute("student") Student st, HttpServletRequest req){
        
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();
        
        Session session = factory.getCurrentSession();
        
        try
        {
            session.beginTransaction();
            session.save(st);
            session.getTransaction().commit();
            System.out.println("Done");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        return "student-conformation";
    }
    
    @RequestMapping("/showStudents")
    public String showData(Model theModel)
    {
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();
        
       //  theStudents = new List<Student>();
       
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Student> theStudents = session
                                    .createQuery("from Student")
                                    .list();
        session.getTransaction().commit();
        
        System.out.println("Starting to fetch");
//        for(Student st1:theStudents)
//        {
//            System.out.println(st1.getId()+ " " + st1.getEmail() +" "+ st1.getFname() + " "+st1.getLname()  );
//        }
        System.out.println("End of fetch");
       
       // theModel.addAllObjects(theStudents);
        theModel.addAttribute("theStudents",theStudents);
        return "show-student";
    }
    
    @RequestMapping("/editStudent")
    public String displayEditForm(HttpServletRequest req, Model theModel)
    {
        
        //System.out.println("In here!!");
        int id = Integer.parseInt(req.getParameter("id"));
        
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();
       
        Session session = factory.getCurrentSession();
       
        session.beginTransaction();
        Student theStudent = session.get(Student.class,id);
        session.getTransaction().commit();
        
        System.out.println("In here twice!!");
        
        theModel.addAttribute("student",theStudent);        
        return "edit-student-form";
    }
    
    @RequestMapping("/updateStudent")
    public String updateStudent(@ModelAttribute("student") Student st, Model theModel)
    {
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();
       
        Session session = factory.getCurrentSession();
       // System.out.println("Before Updating!!");
        session.beginTransaction();
        session.update(st);
        List<Student> theStudents = session
                                    .createQuery("from Student")
                                    .list();
        session.getTransaction().commit();
       // System.out.println("After Update!!");
        
        theModel.addAttribute("theStudents",theStudents);
        return "show-student";
    }
    
    @RequestMapping("/deleteStudent")
    public String deleteStudent(HttpServletRequest req,Model theModel)
    {
        int id = Integer.parseInt(req.getParameter("id"));
        
        SessionFactory factory = new Configuration()
                                 .configure("hibernate.cfg.xml")
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();
       
        Session session = factory.getCurrentSession();
       
        session.beginTransaction();
        Student st = session.get(Student.class,id);
        session.delete(st);
        List<Student> theStudents = session
                                    .createQuery("from Student")
                                    .list();
        session.getTransaction().commit();
       
       theModel.addAttribute("theStudents",theStudents);
        return "show-student";
       
    }
    
}
