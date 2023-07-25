package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.ChapterDao;
import com.sabpaisa.entity.Book;
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
	public Optional<Chapter> getChapter(int chapterid) {
		Optional<Chapter> getById = chapterDao.findById(chapterid);
		System.out.println("only one data:: "+getById);
		return getById;
	}

	@Override
	public Chapter updateChapter(Chapter chapter) {
		Optional<Chapter> data = chapterDao.findById(chapter.getId());	
		if(data.isPresent()) {
			Chapter newdata=data.get();
			newdata.setChapName(chapter.getChapName());
			newdata.setChapDescription(chapter.getChapDescription());
			newdata.setSubid(chapter.getSubid());
			newdata=chapterDao.save(newdata);
			return newdata;
		}		
		  chapter=chapterDao.save(chapter);
		return chapter;
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
