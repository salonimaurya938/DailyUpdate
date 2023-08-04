package com.sabpaisa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagementController {

	@RequestMapping("/")
	public String home() {
		System.out.println("Index handler...");
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(){
		System.out.println("About handler...");
		return "about";
	}
	
	@RequestMapping("/gallery")
	public String gallery(){
		System.out.println("gallery handler...");
		return "gallery";
	}
	
	@RequestMapping("/academic")
	public String academic(){
		System.out.println("Academic handler...");
		return "academic";
	}
	
	@RequestMapping("/admission")
	public String admission(){
		System.out.println("admission handler...");
		return "admission";
	}
	
	@RequestMapping("/alumni")
	public String alumni(){
		System.out.println("alumni handler...");
		return "alumni";
	}
	@RequestMapping("/blog")
	public String blog(){
		System.out.println("blog handler...");
		return "blog";
	}
	@RequestMapping("/Blog-Detail")
	public String blogDetail(){
		System.out.println("alumni handler...");
		return "Blog-Detail";
	}
	@RequestMapping("/bright-classroom")
	public String brightClassroom(){
		System.out.println("bright-classroom handler...");
		return "bright-classroom";
	}
	@RequestMapping("/cart")
	public String cart(){
		System.out.println("cart handler...");
		return "cart";
	}
	@RequestMapping("/contact")
	public String contact(){
		System.out.println("contact handler...");
		return "contact";
	}
	@RequestMapping("/events")
	public String events(){
		System.out.println("events handler...");
		return "events";
	}
	@RequestMapping("/facilities")
	public String facilities(){
		System.out.println("facilities handler...");
		return "facilities";
	}
	@RequestMapping("/faq")
	public String faq(){
		System.out.println("faq handler...");
		return "faq";
	}
	
	@RequestMapping("/Gallery-Detail")
	public String galleryDetails(){
		System.out.println("Gallery-Detail handler...");
		return "Gallery-Detail";
	}
	@RequestMapping("/kindgarden")
	public String kindgarden(){
		System.out.println("kindgarden handler...");
		return "kindgarden";
	}
	@RequestMapping("/lab-library")
	public String labLibrary(){
		System.out.println("lab-library handler...");
		return "lab-library";
	}
	@RequestMapping("/learning")
	public String learning(){
		System.out.println("faq learning...");
		return "learning";
	}
	@RequestMapping("/meeting-hall")
	public String meeting(){
		System.out.println("meeting-hall handler...");
		return "meeting-hall";
	}
	@RequestMapping("/multimedia")
	public String multimedia(){
		System.out.println("multimedia handler...");
		return "multimedia";
	}
	@RequestMapping("/my-account")
	public String myAccount(){
		System.out.println("my-account handler...");
		return "my-account";
	}
	@RequestMapping("/play-grounds")
	public String playGrounds(){
		System.out.println("play-grounds handler...");
		return "play-grounds";
	}
	@RequestMapping("/shop")
	public String shop(){
		System.out.println("shop handler...");
		return "shop";
	}
	@RequestMapping("/sports-clubs")
	public String sportsclubs(){
		System.out.println("sports-clubs handler...");
		return "sports-clubs";
	}
	@RequestMapping("/team")
	public String team(){
		System.out.println("team handler...");
		return "team";
	}
	
	@RequestMapping("/signup")
	public String signup(){
		System.out.println("registration handler...");
		return "signup";
	}
//	@RequestMapping("/studentDashboard")
//	public String studentDashboard(){
//		System.out.println("studentDashboard handler...");
//		return "admin/studentDashboard";
//	}
}
