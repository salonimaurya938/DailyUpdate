package com.sabpaisa.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sabpaisa.dao.AdminDao;
import com.sabpaisa.dto.AdminDto;
import com.sabpaisa.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return adminDao.findAll();
	}

	@Override
	public Optional<Admin> getAdmin(int adminid) {
		Optional<Admin> getById = adminDao.findById(adminid);
		System.out.println("only one data:: "+getById);
		return getById;
	}

	@Override
	public Admin addAdmin(Admin admin) {
		Admin add=adminDao.save(admin);
		return add;
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		System.out.println("Update......");			
			Optional<Admin> adminData = adminDao.findById(admin.getId());	
			if(adminData.isPresent()) {
				Admin newdata=adminData.get();
				newdata.setEmail(admin.getEmail());
				newdata.setUsername(admin.getUsername());
				newdata=adminDao.save(newdata);
				return newdata;
			}else {
				admin = adminDao.save(admin);
				return admin;
			}
	}

	@Override
	public void deleteAdmin(int Delete_id) {
		Admin entity= adminDao.getOne(Delete_id);
		adminDao.delete(entity);		
	}
		
	public Admin save(AdminDto adminDto) {
		Admin admin =new Admin();
		admin.setUsername(adminDto.getUsername());
		admin.setPassword(adminDto.getPassword());
		admin.setId(adminDto.getId());
		admin.setEmail(adminDto.getEmail());
//		admin.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));		
		return adminDao.save(admin);
	}	
//     *************************** Admin Login *******************************************
	
//	public ModelAndView adminlogin(Admin admin) {
//		Admin findByUsername= adminDao.findByUsernameAndPassword(admin.getUsername(),admin.getPassword());		
//		if(findByUsername==null) {
//			ModelAndView modelAndView=new ModelAndView("admin/output1");			
//			HashMap<String, Object> hashMap=new HashMap<String, Object>();			
//			hashMap.put("invalid","Error: please use valid Credential");
//			modelAndView.addObject("hashMapObject",hashMap);		
//			return modelAndView;			
//		}else {
//			getAdmin(1);
//			return new ModelAndView("admin/adminDashBoard");
//		}		
//	}	
	public List<Admin> fetchAdmin() {
		List<Admin> list=adminDao.findAll();
		System.out.println("all data:: "+ list);
		return list;
	}
	
	public Admin adminlogin(Admin admin) {		
		Admin findByUsername= adminDao.findByUsernameAndPassword(admin.getUsername(),admin.getPassword());		
	    return findByUsername;
		}

	@Override
	public Admin changePassword(Admin admin) {
	Optional<Admin> adminData = adminDao.findById(admin.getId());	
		if(adminData.isPresent()) {
			Admin newdata=adminData.get();
			newdata.setEmail(admin.getPassword());
			newdata=adminDao.save(newdata);
			return newdata;
		}else {
			admin = adminDao.save(admin);
			return admin;
		}
	
	}
    
//	@Override
//	public List<Admin> getAllAmin() {
//		List<Admin> all =adminDao.getAllAmin();
//		all.forEach(e->{
//			System.out.println("all data.."+e);
//		});
//		return all;
//	}
	
	
	
}

