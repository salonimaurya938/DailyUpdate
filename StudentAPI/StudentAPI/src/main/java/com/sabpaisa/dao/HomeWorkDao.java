package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.HomeWork;

@Repository
public interface HomeWorkDao extends JpaRepository<HomeWork, Integer>{

}
