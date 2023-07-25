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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.sabpaisa.dao.UploadDao;
import com.sabpaisa.entity.Images;

@Controller
public class ImgController {
	
	@Autowired
	public UploadDao uploadDao;
	
// ................................Image Handler.......................	
	
	@RequestMapping("/addimg")
	public String addimg(Model model) {
		List<Images> list = uploadDao.findAll();
		model.addAttribute("lists", list);
		return "admin/addimg";
	}
	
	@PostMapping("/addimg")
	public String imageUpload(@RequestParam MultipartFile img) {		
		System.out.println(img.getOriginalFilename());	
		
		Images im = new Images();
		im.setImageName(img.getOriginalFilename());
		
		Images uploadimg= uploadDao.save(im);
		if(uploadimg!=null) {			
			try {
				File saveFile = new ClassPathResource("static/img").getFile();
			    Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+img.getOriginalFilename());
			    System.out.println(path);
			    Files.copy(img.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
				
			} catch (Exception e) {
			
				e.printStackTrace();
		  }			
		}		
		System.out.println("msg :: Image Upload Successfully");
		return "admin/addimg";
	}
	
	@RequestMapping("/viewimgs")
	public String viewImg(Model model) {
		List<Images> list = uploadDao.findAll();
		model.addAttribute("lists", list);		
		return "admin/viewimgs";
	}
	
	@RequestMapping("/updateImg/{id}")
	public String Updateimg() {
		
		
		return "";
	}
	
	@PostMapping("/deleteUpload/{id}")
	public String deleteBook(Model model,@RequestParam int id) {
		model.addAttribute("title", "Delete-School Management System");
		System.out.println("delete method.............");
		uploadDao.deleteById(id);		
		return "login";
	}

}
