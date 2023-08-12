package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.sabpaisa.entity.UploadCourses;

@Service
public interface UploadCourseService {
	
    public List<UploadCourses> getUploadCourse();
	
	public Optional<UploadCourses> getUploadCourse(int id);
	
	public UploadCourses addUploadCourse(UploadCourses uploadCourse);
	
	public UploadCourses updateUploadCourse(UploadCourses uploadCourse);
	
	public void deleteUploadCourse(int id);

}
