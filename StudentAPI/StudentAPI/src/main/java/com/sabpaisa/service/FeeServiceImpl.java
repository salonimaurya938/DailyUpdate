package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.feeDao;
import com.sabpaisa.entity.Events;
import com.sabpaisa.entity.Fee;

@Service
public class FeeServiceImpl implements FeeService {

	@Autowired
	private feeDao feeDao;
	
	@Override
	public List<Fee> getfee() {
		List<Fee> fee=feeDao.findAll();
		return fee;
	}

	@Override
	public Optional<Fee> getfee(int id) {
		Optional<Fee> fee = feeDao.findById(id);
		return fee;
	}

	@Override
	public Fee addfee(Fee fee) {
		Fee fees = feeDao.save(fee);
		return fees;
	}

	@Override
	public Fee updatefee(Fee fee) {
		Optional<Fee> data = feeDao.findById(fee.getId());		
		if(data.isPresent()) {			
			Fee newData= data.get();
			newData.setFee(fee.getFee());
			newData.setClasses(fee.getClasses());
			newData.setDate(fee.getDate());
			newData.setRollNo(fee.getRollNo());
			newData.setFeeType(fee.getFeeType());
			newData=feeDao.save(newData);
			return newData;
		  }else {
			  fee= feeDao.save(fee);
			  return fee;
		  }
	}

	@Override
	public void deletefee(int id) {
		// TODO Auto-generated method stub

	}

}
