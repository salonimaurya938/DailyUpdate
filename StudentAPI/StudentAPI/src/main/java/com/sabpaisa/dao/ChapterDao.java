package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.Chapter;

@Repository
public interface ChapterDao extends JpaRepository<Chapter, Integer> {

}
