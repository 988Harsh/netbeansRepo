/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harsh.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    
    @RequestMapping("/")
    public String display() {
        return "home";
    }
    
    @RequestMapping("/second")
    public String redirect() {
        return "second";
    }
    
    @InitBinder
    public String filter()
    {
        return "";
    }
}
