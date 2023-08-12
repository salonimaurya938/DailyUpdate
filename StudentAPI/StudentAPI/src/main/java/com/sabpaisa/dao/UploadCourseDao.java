package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.UploadCourses;

@Repository
public interface UploadCourseDao extends JpaRepository<UploadCourses, Integer>{

}
