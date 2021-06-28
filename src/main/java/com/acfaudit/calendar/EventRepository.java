package com.acfaudit.calendar;

import com.acfaudit.model.Client;
import com.acfaudit.model.Event;
import org.springframework.data.repository.CrudRepository;


public interface EventRepository extends CrudRepository<Event, Integer> {
}