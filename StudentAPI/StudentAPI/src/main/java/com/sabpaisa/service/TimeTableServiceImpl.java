package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.TimeTableDao;
import com.sabpaisa.entity.HomeWork;
import com.sabpaisa.entity.TimeTable;

@Service
public class TimeTableServiceImpl implements TimeTableService{

	@Autowired
	private TimeTableDao timeTableDao;
	
	
	@Override
	public List<TimeTable> getTimeTables() {
		
		return timeTableDao.findAll();
	}

	@Override
	public Optional<TimeTable> getTimeTable(int timetableid) {
		Optional<TimeTable>  tm= timeTableDao.findById(timetableid);
		return tm;
	}

	@Override
	public TimeTable addTimeTable(TimeTable timeTable) {
		
		return timeTableDao.save(timeTable);
	}

	@Override
	public TimeTable updateTimeTable(TimeTable timeTable) {
		Optional<TimeTable> workdata = timeTableDao.findById(timeTable.getId());	
		if(workdata.isPresent()) {
			TimeTable newdata=workdata.get();
			newdata.setSchoolTime(timeTable.getSchoolTime());
			newdata.setSunday(timeTable.getSunday());
			newdata.setMonday(timeTable.getMonday());
			newdata.setTuesday(timeTable.getTuesday());
			newdata.setWednesday(timeTable.getWednesday());
			newdata.setThursday(timeTable.getThursday());
			newdata.setFriday(timeTable.getFriday());
			newdata.setSaturday(timeTable.getSaturday());
			newdata=timeTableDao.save(newdata);
			return newdata;
		}		
		timeTable=timeTableDao.save(timeTable);		
		return timeTable;
	}

	
	
	
	
	@Override
	public void deleteTimeTable(int deleteid) {
		// TODO Auto-generated method stub
		
	}

}

