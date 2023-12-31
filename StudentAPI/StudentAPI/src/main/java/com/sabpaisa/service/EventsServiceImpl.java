package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabpaisa.dao.EventsDao;
import com.sabpaisa.entity.Admin;
import com.sabpaisa.entity.Events;

@Service
public class EventsServiceImpl implements EventsService {

	@Autowired
	private EventsDao eventsDao;
	
	@Override
	public List<Events> getEvents() {
		
		return eventsDao.findAll();
	}

	@Override
	public Optional<Events> getEvents(int eventid) {
		Optional<Events> evid= eventsDao.findById(eventid);
		return evid;
	}

	@Override
	public Events addEvents(Events events) {
		Events as=eventsDao.save(events);
		return as;
	}

	@Override
	public Events updateEvents(Events events) {
		Optional<Events> data = eventsDao.findById(events.getId());		
		if(data.isPresent()) {			
			Events newData= data.get();
			newData.setEvent(events.getEvent());
			newData.setDateTime(events.getDateTime());
			newData=eventsDao.save(newData);
			return newData;
		  }else {
			  events= eventsDao.save(events);
			  return events;
		  }
	}
	
	
	
	@Override
	public void deleteEvents(int Delete_id) {
		// TODO Auto-generated method stub		
	}

	
}
