package edu.topica.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.topica.DAO.StudentDAO;
import edu.topica.entity.Student;

@Controller
public class StudentController {
	@RequestMapping(value = "/students", method = RequestMethod.GET,produces = "application/json")
	 @ResponseBody
	   public String homePage() throws Exception {
		ObjectMapper ob = new ObjectMapper();
		StudentDAO std = new StudentDAO();
		List<Student> list = std.get();
		return ob.writeValueAsString(list);
	   }
}
