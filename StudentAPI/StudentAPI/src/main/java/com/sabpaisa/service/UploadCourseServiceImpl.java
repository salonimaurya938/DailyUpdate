package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.UploadCourseDao;
import com.sabpaisa.dao.UploadDao;
import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.UploadCourses;

@Service
public class UploadCourseServiceImpl implements UploadCourseService {
	
	@Autowired
	private UploadCourseDao uploadCourseDao;

	@Override
	public List<UploadCourses> getUploadCourse() {
		List<UploadCourses> getdata= uploadCourseDao.findAll();
		return getdata;
	}

	@Override
	public Optional<UploadCourses> getUploadCourse(int id) {
		Optional<UploadCourses> getById= uploadCourseDao.findById(id);
		return getById;
	}

	@Override
	public UploadCourses addUploadCourse(UploadCourses uploadCourse) {
		uploadCourseDao.save(uploadCourse);
		return uploadCourseDao.save(uploadCourse);
	}

	@Override
	public UploadCourses updateUploadCourse(UploadCourses uploadCourse) {
		Optional<UploadCourses> data = uploadCourseDao.findById(uploadCourse.getId());	
		if(data.isPresent()) {
			UploadCourses newdata=data.get();
			newdata.setTitle(uploadCourse.getTitle());
			newdata.setDiscription(uploadCourse.getDiscription());
			newdata.setClasses(uploadCourse.getClasses());
			newdata.setLesson(uploadCourse.getLesson());
			newdata=uploadCourseDao.save(newdata);
			return newdata;
		}else {
			uploadCourse = uploadCourseDao.save(uploadCourse);
			return uploadCourse;
		}
	}

	@Override
	public void deleteUploadCourse(int id) {
		// TODO Auto-generated method stub

	}

}
