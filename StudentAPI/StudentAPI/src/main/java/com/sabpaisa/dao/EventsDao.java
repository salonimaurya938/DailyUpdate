package com.sabpaisa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabpaisa.entity.Events;

@Repository
public interface EventsDao extends JpaRepository<Events, Integer>{

}
