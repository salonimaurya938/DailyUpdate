package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.Chapter;

@Service
public interface ChapterService {

	public List<Chapter> getChapters();

	public Optional<Chapter> getAdmin(int chapterid);

	public Chapter addChapter(Chapter chapter);

	public Chapter updateChapter(Chapter chapter);

	public void deleteChapter(int Delete_id);

}
