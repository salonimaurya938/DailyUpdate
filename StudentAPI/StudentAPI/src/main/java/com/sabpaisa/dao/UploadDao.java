package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.Images;

@Repository
public interface UploadDao extends JpaRepository<Images, Integer>{
	

}
