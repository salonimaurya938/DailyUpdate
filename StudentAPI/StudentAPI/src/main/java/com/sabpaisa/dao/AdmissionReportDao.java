package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabpaisa.entity.AdmissionReport;

public interface AdmissionReportDao extends JpaRepository<AdmissionReport, Integer> {

}
