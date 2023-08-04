package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.AdmissionEnquiryDao;
import com.sabpaisa.entity.AdmissionEnquiry;
import com.sabpaisa.entity.AdmissionReport;
import com.sabpaisa.entity.Book;

@Service
public class AdmissionEnquiryServiceImpl implements AdmissionEnquiryService{

	@Autowired
	private AdmissionEnquiryDao admissionEnquiryDao;
	
	@Override
	public List<AdmissionEnquiry> getAdmissionEnquiry() {
		List<AdmissionEnquiry> a= admissionEnquiryDao.findAll();
		return a;
	}

	@Override
	public Optional<AdmissionEnquiry> getAdmissionEnquiry(int id) {
		Optional<AdmissionEnquiry> enid= admissionEnquiryDao.findById(id);
		return enid;
	}

	@Override
	public AdmissionEnquiry addAdmissionEnquiry(AdmissionEnquiry admissionEnquiry) {
		return admissionEnquiryDao.save(admissionEnquiry);
	}

	@Override
	public AdmissionEnquiry updateAdmissionEnquiry(AdmissionEnquiry admissionEnquiry) {
		Optional<AdmissionEnquiry> data = admissionEnquiryDao.findById(admissionEnquiry.getId());	
		if(data.isPresent()) {
			AdmissionEnquiry newdata=data.get();
			newdata.setName(admissionEnquiry.getName());
			newdata.setClasses(admissionEnquiry.getClasses());
			newdata.setMob(admissionEnquiry.getMob());
			newdata.setEmail(admissionEnquiry.getEmail());
			newdata.setAddress(admissionEnquiry.getAddress());
			newdata.setDescription(admissionEnquiry.getDescription());
			newdata.setDateTime(admissionEnquiry.getDateTime());
			newdata.setAssigned(admissionEnquiry.getAssigned());
			newdata.setReference(admissionEnquiry.getReference());
			newdata.setSource(admissionEnquiry.getSource());			
			newdata=admissionEnquiryDao.save(newdata);
			return newdata;
		}		
		admissionEnquiry=admissionEnquiryDao.save(admissionEnquiry);
		return admissionEnquiry;
	}

	@Override
	public void deleteAdmissionEnquiry(int id) {
		AdmissionEnquiry entity= admissionEnquiryDao.getOne(id);
		admissionEnquiryDao.delete(entity);	
	}

}
