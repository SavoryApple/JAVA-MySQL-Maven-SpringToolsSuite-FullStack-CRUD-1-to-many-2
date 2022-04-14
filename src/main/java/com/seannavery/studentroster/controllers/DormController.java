package com.seannavery.studentroster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seannavery.studentroster.models.Dorm;
import com.seannavery.studentroster.models.Student;
import com.seannavery.studentroster.services.DormService;

@Controller
public class DormController {
	private final DormService dormService;
    public DormController(DormService dormService){
        this.dormService = dormService;
    }
    
    @RequestMapping("/dorms")
    public String index(Model model, @ModelAttribute("dorm") Dorm dorm) {
    	List<Dorm> dorms = dormService.allDorms();
    	model.addAttribute("dorms", dorms);
    	return "index.jsp";
    }
    
    @RequestMapping("/dorms/{dorm_id}")
    public String showDorm(@PathVariable Long dorm_id, Model model) {
        
        Dorm someAwesomeDorm = dormService.findDorm(dorm_id);
        model.addAttribute("dorm", someAwesomeDorm);
        return "showDorm.jsp";
    }
    
    @RequestMapping("/dorms/new")
    public String showDorm(@ModelAttribute("dorm") Dorm dorm) {   
        return "newdormform.jsp";
    }
    
    @RequestMapping("/students/new")
    public String showStudentForm(@ModelAttribute("student") Student student, Model model) { 
    	List<Dorm> dorms = dormService.allDorms();
    	model.addAttribute("dorms", dorms);
        return "newstudentform.jsp";
    }
    
    @RequestMapping(value="/dorms/create", method=RequestMethod.POST)
    public String createPerson(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<Dorm> dorms = dormService.allDorms();
        	model.addAttribute("dorms", dorms);
            return "index.jsp";
        } else {
            dormService.createDorm(dorm);
            return "redirect:/dorms";
        }
    }
    
    @RequestMapping("/dorms/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Dorm dorm = dormService.findDorm(id);
        model.addAttribute("dorm", dorm);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/dorms/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("person") Dorm dorm, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            dormService.updateDorm(dorm);
            return "redirect:/dorms";
        }
    } 
    
    @RequestMapping(value = "/dorms/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		dormService.deleteDorm(id);
		return "redirect:/dorms";
	}
    
}
