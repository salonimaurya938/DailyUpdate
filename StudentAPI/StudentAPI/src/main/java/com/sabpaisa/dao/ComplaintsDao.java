package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.Complaints;

@Repository
public interface ComplaintsDao  extends JpaRepository<Complaints, Integer>{

}
