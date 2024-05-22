package com.cglia.si.controller;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cglia.si.DtabaseUtil.DatabaseUtil;
import com.cglia.si.model.*;
import com.cglia.si.service.StudentService;
import com.cglia.si.serviceimpl.ServiceImpl;

@Controller(value = "SIController")
public class ControllerClass {
	@RequestMapping({"/home", "/"})
	public String showHome() {
		return "Home";
	}
	@RequestMapping("/about")
		public String about() {
			return "About";
		}
		
		
	@RequestMapping("/operation")
	public String operation() {
		return"Operation";
	}
	@RequestMapping("/form")
	public String insert() {
		return"Form";
	}

	
	@RequestMapping(path="/insert", method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute Student student , HttpServletRequest request, RedirectAttributes atts)  {
		System.out.println(student);
		StudentService service = new ServiceImpl();
		Integer id = service.save (student);
		//request.setAttribute("id", id);
		atts.addFlashAttribute("id", id);
		if(id>0) {
			//request.setAttribute("successmsg","Employee saved successfully with ID:"+id);
			atts.addFlashAttribute("successmsg","Employee saved successfully with ID:"+id);
		}else {
			//request.setAttribute("failuremsg","System problem. Please contact Help desk.");
			atts.addFlashAttribute("failuremsg","System problem. Please contact Help desk.");
		}
		
		return "redirect:/form";
	}
	@RequestMapping("/delete")
	public String delete() {
		return"Delete";
	}

	
	@RequestMapping(path= "/deletebyid", method = RequestMethod.POST)
    public String deleteStudent(HttpServletRequest request,RedirectAttributes atts) {
        StudentService service = new ServiceImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        Boolean deleted = service.delete(id);
        
        if (deleted) {
            atts.addFlashAttribute("message", "Student deleted successfully");
        } else {
            atts.addFlashAttribute("message", "Failed to delete student. Please try again.");
        }
        
        return "redirect:/delete";
    }

	@RequestMapping("/show")
	public String showAllStudent(HttpServletRequest request) {
		List<Student> stdList = new ArrayList<>();
		StudentService service = new ServiceImpl();
		stdList = service.show();
		request.setAttribute("students",stdList);
		
		return "Showall";
		

	}
	@RequestMapping("/update")
	public String update() {
		return"Inputid";
}	
	@RequestMapping("/updateStd")
	public String updatestd(HttpServletRequest request) {
		String id = "";
		if(request.getParameter("id")!=null) {
			id = request.getParameter("id");
			request.setAttribute("id", id);
		};
		int  stdId = Integer.parseInt(id);
		StudentService service = new ServiceImpl();
		if(! id.isEmpty()) {
			Student std = service.showStdById(stdId) ;
			request.setAttribute("student", std);
		}
		
		return"Update";
	}
	@RequestMapping("/updateStudent")
	    public String updateStudent(@ModelAttribute Student std, RedirectAttributes attrs) {
	    	StudentService service = new ServiceImpl();
	        int count = service.update(std);
	        if (count > 0) {
	            System.out.println("Student with ID: " + std.getId() + " is updated successfully.");
	        } else {
	            System.out.println("An error occurred. Please try again...");
	        }
	        return "redirect:/show"; // Redirect to a suitable URL after update
	}
	
	
	}

		


