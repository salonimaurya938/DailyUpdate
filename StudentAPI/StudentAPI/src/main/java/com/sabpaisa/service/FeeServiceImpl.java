package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.feeDao;
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
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Fee addBook(Fee fee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fee updatefee(Fee fee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletefee(int id) {
		// TODO Auto-generated method stub

	}

}
