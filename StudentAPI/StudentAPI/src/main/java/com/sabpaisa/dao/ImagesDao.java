package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.Images;

@Repository
public interface ImagesDao extends JpaRepository<Images, Integer>{

}
