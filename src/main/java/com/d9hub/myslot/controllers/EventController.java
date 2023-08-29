/**
 * 
 */
package com.d9hub.myslot.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.d9hub.myslot.models.Event;
import com.d9hub.myslot.models.Location;
import com.d9hub.myslot.repositories.EventRepository;

/**
 * @author lruhunage
 *
 */

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
	
	@Autowired
	private EventRepository eventRepository;
	
	@GetMapping
	public List<Event> getAllEvents() {
	   return eventRepository.findAll();
	}
	
	@RequestMapping(value ="provider/{providerId}", method= RequestMethod.GET)
	public List<Event> getAllEventsByServiceProvider(@PathVariable Long providerId) {
	   return eventRepository.findAllEventsByProvider(providerId);
	}
	
	
	@RequestMapping(value ="{id}", method= RequestMethod.GET)
	public ResponseEntity<Event> get(@PathVariable Long id) throws Exception {
		Event event = eventRepository.findById(id)
	            .orElseThrow(() -> new Exception("Event " + id + " not found"));
		
		return ResponseEntity.ok().body(event);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Event create(@RequestBody Event event) {
		return eventRepository.saveAndFlush(event);
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		eventRepository.deleteById(id);
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.PUT)
	public Event update(@PathVariable Long id,@RequestBody Event event) throws Exception {
		//PUT will expect full object to update. PATCH will need delta
		Event existingEvent = eventRepository.findById(id).orElseThrow(() -> new Exception("Event " + id + " not found"));
		BeanUtils.copyProperties(event, existingEvent, "event_id");
		return eventRepository.saveAndFlush(existingEvent);
	}

}
