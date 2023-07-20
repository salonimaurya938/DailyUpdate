package com.sabpaisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sabpaisa.entity.Events;

@Service
public interface EventsService {
	
	public List<Events> getEvents();

	public Optional<Events> getEvents(int eventid);

	public Events addEvents(Events events);

	public Events updateEvents(Events events);

	public void deleteEvents(int Delete_id);

}
