package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.sabpaisa.entity.StudentResult;

@Service
public interface StudentResultService {
 
    public List<StudentResult> getStudentResults();
	
	public Optional<StudentResult> getStudentResult(int StudentResultid);
	
	public StudentResult addStudentResult(StudentResult studentResult);
	
	public StudentResult updateStudentResult(StudentResult studentResult);
	
	public void deleteStudentResult(int Deleteid);
}
