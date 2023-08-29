package com.sabpaisa.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
	
	Admin  findByUsernameAndPassword(String username, String password);

}
