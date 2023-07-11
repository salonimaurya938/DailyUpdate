package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabpaisa.entity.Chapter;

public interface ChapterDao extends JpaRepository<Chapter, Integer> {

}
