package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabpaisa.entity.Images;

public interface UploadDao extends JpaRepository<Images, Integer>{
	

}
