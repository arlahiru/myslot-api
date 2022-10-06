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

import com.d9hub.myslot.models.Location;
import com.d9hub.myslot.repositories.LocationRepository;

/**
 * @author lruhunage
 *
 */

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {
	
	@Autowired
	private LocationRepository locationRepository;
	
	@GetMapping
	public List<Location> getAllUsers() {
	   return locationRepository.findAll();
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.GET)
	public ResponseEntity<Location> get(@PathVariable Long id) throws Exception {
		Location location = locationRepository.findById(id)
	            .orElseThrow(() -> new Exception("User " + id + " not found"));
		
		return ResponseEntity.ok().body(location);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Location create(@RequestBody Location location) {
		return locationRepository.saveAndFlush(location);
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		locationRepository.deleteById(id);
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.PUT)
	public Location update(@PathVariable Long id,@RequestBody Location location) throws Exception {
		//PUT will expect full object to update. PATCH will need delta
		Location existingLocation = locationRepository.findById(id).orElseThrow(() -> new Exception("Location " + id + " not found"));
		BeanUtils.copyProperties(location, existingLocation, "location_id");
		return locationRepository.saveAndFlush(location);
	}

}
