package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.TimeTable;

@Repository
public interface TimeTableDao extends JpaRepository<TimeTable, Integer> {

}
