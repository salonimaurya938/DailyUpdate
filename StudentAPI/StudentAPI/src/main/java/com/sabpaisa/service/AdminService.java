package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.sabpaisa.entity.Admin;


@Service
public interface AdminService {
	
    public List<Admin> getAdmins();
	
	public Optional<Admin> getAdmin(int adminid);
	
	public Admin addAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin);
	
	public void deleteAdmin(int Delete_id);
	
	public Admin adminlogin(Admin admin);
	
	public List<Admin> fetchAdmin();
//	
//	public List<Admin> getAllAmin();
////	void getbyusername(String username);
	
}
