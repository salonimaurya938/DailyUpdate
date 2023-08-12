package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabpaisa.entity.Fee;

public interface feeDao extends JpaRepository<Fee, Integer> {

}
