package edu.topica.controller;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.topica.DAO.StudentDAO;
import edu.topica.entity.Student;

@Controller
public class UploadController {
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView add(@RequestParam(value = "file",required = true) MultipartFile part) throws Exception {

		String line;
		BufferedReader br =  new BufferedReader(new InputStreamReader(part.getInputStream()));               		
		while ((line = br.readLine()) != null) {
			StudentDAO std = new StudentDAO();
			String[] strings=line.split(",");
			std.create(createObject(strings));
	     }
//		InputStream fileContent = filePart.getInputStream();
		ModelAndView views = new ModelAndView("upload");
		return views;
	}
	
	private Student createObject(String[] strings) {
		Integer id = Integer.parseInt(strings[0]);
		String name = strings[1];
        String birth = strings[2];
        int gender=Integer.parseInt(strings[3]);  
        return new Student(id,name,birth,gender);
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView show() {
		ModelAndView views = new ModelAndView("upload");
		return views;
	}
}
