package com.tutorialspoint;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@Controller
public class StudentController {
   @RequestMapping(value = "/student", method = RequestMethod.GET)
   public ModelAndView student() {
      return new ModelAndView("student", "student",  new Client());
   }
   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
  public String addStudent(@ModelAttribute("SpringWeb")Student student, ModelMap model) {
   		model.addAttribute("name", student.getName());
     	model.addAttribute("age", student.getAge());
     	model.addAttribute("id", student.getId());
     	return "result";
   }
   @RequestMapping("/validation")  
   public String submitForm( @Valid @ModelAttribute("student")Student student, BindingResult br, ModelMap model)  
   {  
       if(br.hasErrors())  
       {  
           return "student";  
       }  
       else  
       {  
    	   	model.addAttribute("name", student.getName());
        	model.addAttribute("age", student.getAge());
        	model.addAttribute("id", student.getId());
        	return "result";
       }  
   }  
  
}