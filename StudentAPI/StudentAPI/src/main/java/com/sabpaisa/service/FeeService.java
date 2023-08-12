package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.sabpaisa.entity.Fee;


@Service
public interface FeeService {
	
	public List<Fee> getfee();

	public Optional<Fee> getfee(int id);

	public Fee addBook(Fee fee);

	public Fee updatefee(Fee fee);

	public void deletefee(int id);

}
