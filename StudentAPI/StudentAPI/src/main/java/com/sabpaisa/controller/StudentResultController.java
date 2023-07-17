package com.sabpaisa.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sabpaisa.dao.StudentResultDao;
import com.sabpaisa.entity.Images;
import com.sabpaisa.entity.StudentResult;

@Controller
public class StudentResultController {
	
	@Autowired
	private StudentResultDao studentResultDao;
	
	@RequestMapping("/addResult")
	public String addresult(Model model) {
		List<StudentResult> list = studentResultDao.findAll();
		model.addAttribute("lists", list);
		return "admin/addResult";
	}
	
	
	@PostMapping("/addResult")
	public String imageUpload(@RequestParam MultipartFile result) {		
		System.out.println(result.getOriginalFilename());	
		
		StudentResult im = new StudentResult();
		im.setResult(result.getOriginalFilename());
		
		StudentResult uploadimg= studentResultDao.save(im);
		if(uploadimg!=null) {			
			try {
				File saveFile = new ClassPathResource("static/img").getFile();
			    Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+result.getOriginalFilename());
			    System.out.println(path);
			    Files.copy(result.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
				
			} catch (Exception e) {
			
				e.printStackTrace();
		  }			
		}		
		System.out.println("msg :: Result Upload Successfully");
		return "admin/addResult";
	}
	
	@RequestMapping("/viewResult")
	public String viewResult(Model model) {
		List<StudentResult> list = studentResultDao.findAll();
		model.addAttribute("lists", list);		
		return "admin/viewResult";
	}
	
	@RequestMapping("/updateResult")
	public String updateResult() {
		System.out.println("result update...");
		return "admin/updateResult";
	}

	
}
