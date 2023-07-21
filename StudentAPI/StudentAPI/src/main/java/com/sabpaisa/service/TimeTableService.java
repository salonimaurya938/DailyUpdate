package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sabpaisa.entity.TimeTable;

@Service
public interface TimeTableService {

	public List<TimeTable> getTimeTables();
	
	public Optional<TimeTable> getTimeTable(int timetableid);
	
	public TimeTable addTimeTable(TimeTable timeTable);
	
	public TimeTable updateTimeTable(TimeTable timeTable);
	
	public void deleteTimeTable(int deleteid);
	
}
