package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.sabpaisa.entity.Admission;

@Service
public interface AdmissionServices {

	public List<Admission> getAdmissions();

	public Optional<Admission> getAdmission(int id);

	public Admission addAdmission(Admission admission);

	public Admission updateAdmission(Admission admission);

	public void deleteAdmission(int id);
}
