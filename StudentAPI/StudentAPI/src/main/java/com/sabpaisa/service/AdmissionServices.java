package com.sabpaisa.service;

import java.awt.Image;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.sabpaisa.entity.Admission;

@Service
public interface AdmissionServices {

	public List<Admission> getAdmissions();

	public Optional<Admission> getAdmission(int id);

	public Admission saveAdmission(Admission admission);

	public Admission updateAdmission(Admission admission);

	public void deleteAdmission(int id);

	public List<Admission> saveImagesWithType(List<Admission> admission);
	
	public Admission studentLogin(Admission admission);
	
}
