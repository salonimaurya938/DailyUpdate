package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.Admission;

@Repository
public interface AdmissionDao extends JpaRepository<Admission, Integer>{

}
