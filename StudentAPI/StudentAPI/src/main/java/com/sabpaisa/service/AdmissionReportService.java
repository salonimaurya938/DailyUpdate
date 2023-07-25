package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.sabpaisa.entity.AdmissionReport;

@Service
public interface AdmissionReportService {
		
	public List<AdmissionReport> getAdmissionReport();

	public Optional<AdmissionReport> getAdmissionReport(int id);

	public AdmissionReport addAdmissionReport(AdmissionReport addAdmissionReport);

	public AdmissionReport updateAdmissionReport(AdmissionReport admissionReport);

	public void deleteAdmissionReport(int deleteid);
}
