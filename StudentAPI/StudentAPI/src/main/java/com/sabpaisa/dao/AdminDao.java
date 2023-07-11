package com.sabpaisa.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sabpaisa.entity.Admin;

public interface AdminDao  extends JpaRepository<Admin, Integer> {

	Admin  findByUsernameAndPassword(String username, String password);

}
