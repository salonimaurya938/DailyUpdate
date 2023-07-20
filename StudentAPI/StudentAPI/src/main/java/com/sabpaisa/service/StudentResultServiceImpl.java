package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.StudentResultDao;
import com.sabpaisa.entity.StudentResult;

@Service
public class StudentResultServiceImpl implements StudentResultService {
	
	@Autowired
	private StudentResultDao studentResultDao;

	@Override
	public List<StudentResult> getStudentResults() {	
		List<StudentResult> s=studentResultDao.findAll();		
		return s;
	}

	@Override
	public Optional<StudentResult> getStudentResult(int StudentResultid) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public StudentResult addStudentResult(StudentResult studentResult) {
		StudentResult a= studentResultDao.save(studentResult);
		return a;
	}

	@Override
	public StudentResult updateStudentResult(StudentResult studentResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudentResult(int Deleteid) {
		// TODO Auto-generated method stub

	}

}
