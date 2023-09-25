package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sabpaisa.dao.AdmissionDao;
import com.sabpaisa.entity.Admission;

@Service
public class AdmissionServicesImpl  implements AdmissionServices{
	
	@Autowired 
	 AdmissionDao admissionDao;

	@Override
	public List<Admission> getAdmissions() {
		List<Admission> a= admissionDao.findAll();
		return a;
	}

	@Override
	public Optional<Admission> getAdmission(int id) {
		Optional<Admission> enid= admissionDao.findById(id);
		return enid;
	}

	@Override
	public Admission addAdmission(Admission admission) {
		Admission save = admissionDao.save(admission);
		return save;
	}

	@Override
	public Admission updateAdmission(Admission admission) {
		Optional<Admission> data = admissionDao.findById(admission.getId());	
		if(data.isPresent()) {
			Admission newdata=data.get();
			newdata.setName(admission.getName());		
			newdata=admissionDao.save(newdata);
			return newdata;
		}		
		admission=admissionDao.save(admission);
		return admission;
	}

	@Override
	public void deleteAdmission(int id) {
		Admission entity= admissionDao.getOne(id);
		admissionDao.delete(entity);	
	}
	
	public void saveStudentPic(byte[] stdProfile) {
        Admission student = new Admission();
        student.setStdProfile(stdProfile);
        admissionDao.save(student);
    }

}
