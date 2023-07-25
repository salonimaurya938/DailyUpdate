package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.ComplaintsDao;
import com.sabpaisa.entity.Complaints;
@Service
public class ComplaintsServiceImpl implements ComplaintsService{
	
	@Autowired 
	private ComplaintsDao complaintsDao;

	@Override
	public List<Complaints> getComplaints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Complaints> getComplaints(int id) {
		Optional<Complaints> data= complaintsDao.findById(id);
		return data;
	}

	@Override
	public Complaints addComplaints(Complaints complaints) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Complaints updateComplaints(Complaints complaints) {
		Optional<Complaints> data= complaintsDao.findById(complaints.getId());
		if(data.isPresent()) {
			Complaints newData =data.get();
			newData.setComplaint(complaints.getComplaint());
			newData=complaintsDao.save(newData);
			return newData;
		}else {
			complaints = complaintsDao.save(complaints);
			return complaints;
		}
	}

	@Override
	public void deleteComplaints(int id) {
		// TODO Auto-generated method stub
		
	}

}
