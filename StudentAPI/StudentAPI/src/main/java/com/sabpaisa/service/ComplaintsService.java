package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.sabpaisa.entity.Complaints;

@Service
public interface ComplaintsService {

	  public List<Complaints> getComplaints();
		
		public Optional<Complaints> getComplaints(int id);
		
		public Complaints addComplaints(Complaints complaints);
		
		public Complaints updateComplaints(Complaints complaints);
		
		public void deleteComplaints(int id);
	
}
