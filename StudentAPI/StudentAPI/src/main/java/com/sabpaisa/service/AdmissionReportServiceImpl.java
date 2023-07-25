package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.AdmissionReportDao;
import com.sabpaisa.entity.AdmissionReport;

@Service
public class AdmissionReportServiceImpl implements AdmissionReportService {
	
	@Autowired 
	private  AdmissionReportDao admReportDao;

	@Override
	public List<AdmissionReport> getAdmissionReport() {
		// TODO Auto-generated method stub
	  return admReportDao.findAll();
	}

	@Override
	public Optional<AdmissionReport> getAdmissionReport(int id) {
		Optional<AdmissionReport> getById = admReportDao.findById(id);
		System.out.println("only one data:: "+getById);
		return getById;
	}

	@Override
	public AdmissionReport addAdmissionReport(AdmissionReport addAdmissionReport) {
		AdmissionReport add=admReportDao.save(addAdmissionReport);
		return add;
	}

	@Override
	public AdmissionReport updateAdmissionReport(AdmissionReport admissionReport) {
		Optional<AdmissionReport> data = admReportDao.findById(admissionReport.getId());	
		if(data.isPresent()) {
			AdmissionReport newdata=data.get();
			newdata.setName(admissionReport.getName());
			newdata.setClassSection(admissionReport.getClassSection());
			newdata.setFatherName(admissionReport.getFatherName());
			newdata.setMotherName(admissionReport.getMotherName());
			newdata.setAddress(admissionReport.getAddress());
			newdata.setTotalFee(admissionReport.getTotalFee());
			newdata.setPaidFee(admissionReport.getPaidFee());
			newdata.setRemainFee(admissionReport.getRemainFee());
			
			newdata=admReportDao.save(newdata);
			return newdata;
		}		
		  admissionReport=admReportDao.save(admissionReport);
		return admissionReport;
	}

	@Override
	public void deleteAdmissionReport(int deleteid) {
		// TODO Auto-generated method stub
		
	}

}
