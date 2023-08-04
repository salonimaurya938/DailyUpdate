package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sabpaisa.entity.AdmissionEnquiry;

@Service
public interface AdmissionEnquiryService {
	
public List<AdmissionEnquiry> getAdmissionEnquiry();
	
	public Optional<AdmissionEnquiry> getAdmissionEnquiry(int id);
	
	public AdmissionEnquiry addAdmissionEnquiry(AdmissionEnquiry admissionEnquiry);
	
	public AdmissionEnquiry updateAdmissionEnquiry(AdmissionEnquiry admissionEnquiry);
	
	public void deleteAdmissionEnquiry(int id);

}
