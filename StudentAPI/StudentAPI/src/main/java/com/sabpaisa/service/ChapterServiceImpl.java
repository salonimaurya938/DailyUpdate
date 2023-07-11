package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.ChapterDao;
import com.sabpaisa.entity.Chapter;

@Service
public class ChapterServiceImpl  implements ChapterService{
	
	@Autowired
	private ChapterDao chapterDao;

	@Override
	public List<Chapter> getChapters() {
		return chapterDao.findAll();
	}

	@Override
	public Optional<Chapter> getAdmin(int chapterid) {
		Optional<Chapter> getById = chapterDao.findById(chapterid);
		System.out.println("only one data:: "+getById);
		return getById;
	}

	@Override
	public Chapter updateChapter(Chapter chapter) {
		Chapter add=chapterDao.save(chapter);
		return add;
	}

	@Override
	public Chapter addChapter(Chapter chapter) {
		Chapter update=chapterDao.save(chapter);
		return update;
	}

	@Override
	public void deleteChapter(int Delete_id) {
		Chapter entity= chapterDao.getOne(Delete_id);
		chapterDao.delete(entity);		
	}

}
