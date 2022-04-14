package com.seannavery.studentroster.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seannavery.studentroster.models.Student;
import com.seannavery.studentroster.services.StudentService;

@Controller
public class StudentController {
	private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    
    @RequestMapping(value="/students/create", method=RequestMethod.POST)
    public String createLicense(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	System.out.println(result);
            return "redirect:/students/new";
        } else {
            studentService.createStudent(student);
            return "redirect:/dorms";
        }
    }
    
    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
 	public String destroy(@PathVariable("id") Long id) {
 		studentService.deleteStudent(id);
 		return "redirect:/dorms";
 	}
     
 }

