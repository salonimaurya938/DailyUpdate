package com.sabpaisa.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.sabpaisa.dao.StudentResultDao;
import com.sabpaisa.entity.Book;
import com.sabpaisa.entity.StudentResult;
import com.sabpaisa.fileuploading.Fileuploading;
import com.sabpaisa.service.StudentResultService;

@Controller
public class StudentResultController {

	@Autowired
	private StudentResultDao studentResultDao;

	@Autowired
	private StudentResultService studentResultService;

	@RequestMapping("/addResult")
	public String addresult(Model model) {
		model.addAttribute("title", "StudentResult-School Management System");
		model.addAttribute("studentResult", new StudentResult());
		return "admin/addResult";
	}
//	
//	@PostMapping("/addResult")
//	public RedirectView imageUpload(@RequestParam("result") MultipartFile multipartFile, StudentResult studentResult)throws IOException {		
//		         
//		   
//		    System.out.println( multipartFile.getOriginalFilename());
//		
//	        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//	        studentResult.setResult(fileName); 
//	        StudentResult savedUser = studentResultService.addStudentResult(studentResult);
//	        String uploadDir = "img/" + savedUser.getId();
//	        Path uploadPath = Paths.get(uploadDir);
//	        if(!Files.exists(uploadPath)) {
//	        	Files.createDirectories(uploadPath);
//	        }	        
//	        Fileuploading.saveFile(uploadDir, fileName, multipartFile);        
//	        return new RedirectView("admin/addResult", true);
//	}

	@PostMapping("/addResult")
	public String imageUpload(@RequestParam MultipartFile result,String name, String classes, String division, String dob,
			String rollNo, String totalMarks, String obtainedMarks) {		
		System.out.println("Inserting data in table...");
		StudentResult studentResult = new StudentResult();
		System.out.println(result.getOriginalFilename());
		studentResult.setName(name);
		studentResult.setClasses(classes);
		studentResult.setDivision(division);
		studentResult.setDob(dob);
		studentResult.setRollNo(rollNo);
		studentResult.setTotalMarks(totalMarks);
		studentResult.setObTainedMarks(obtainedMarks);
		studentResult.setResult(result.getOriginalFilename());
		StudentResult uploadimg = studentResultDao.save(studentResult);
		System.out.println("image uplaoding.." + uploadimg);
		if (uploadimg != null) {
			try {
				File saveFile = new ClassPathResource("static/images").getFile();
				Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + result.getOriginalFilename());
				System.out.println(path);
				Files.copy(result.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				studentResultDao.save(studentResult);
				System.out.println("image uplaoding1.." + uploadimg);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("msg :: Result Upload Successfully");
		return "admin/addResult";
	}

	@RequestMapping("/viewResult")
	public String viewResult(Model model) {
		List<StudentResult> list = studentResultService.getStudentResults();
		model.addAttribute("lists", list);
		return "admin/viewResult";
	}

	@PostMapping("/deleteResult/{id}")
	public String deleteBook(Model model, @RequestParam int id) {
		model.addAttribute("title", "Delete-School Management System");
		System.out.println("delete method.............");
		studentResultDao.deleteById(id);
		List<StudentResult> list = studentResultService.getStudentResults();
		model.addAttribute("lists", list);
		return "admin/viewResult";
	}

//	@RequestMapping("/updateResult/{id}")
//	public String updateResult(Model model, StudentResult studentResult, int id) {
//		System.out.println("result update...");
//		model.addAttribute("studentResult", studentResult);
//		Optional<StudentResult> studentresutid=studentResultDao.findById(id);
//		StudentResult sr= studentresutid.get();
//		model.addAttribute("id",s);
//	;
//		return "admin/updateResult";	
//	
//	}
//	C:\Users\Raj Pandey\Desktop\Saloni\DailyUpdate\StudentAPI\StudentAPI\target\classes\static\img\6.web	
}
