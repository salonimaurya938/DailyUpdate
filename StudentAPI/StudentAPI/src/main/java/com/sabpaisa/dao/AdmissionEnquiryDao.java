package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.AdmissionEnquiry;

@Repository
public interface AdmissionEnquiryDao  extends JpaRepository<AdmissionEnquiry, Integer>{

}
