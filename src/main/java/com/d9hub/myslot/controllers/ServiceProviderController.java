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

import com.d9hub.myslot.models.ServiceProvider;
import com.d9hub.myslot.models.Slot;
import com.d9hub.myslot.repositories.ServiceProviderRepository;
import com.d9hub.myslot.repositories.SlotRepository;

/**
 * @author lruhunage
 *
 */

@RestController
@RequestMapping("/api/v1/providers")
public class ServiceProviderController {
	
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;
	
	@GetMapping
	public List<ServiceProvider> getAllServiceProviders() {
	   return serviceProviderRepository.findAll();
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.GET)
	public ResponseEntity<ServiceProvider> get(@PathVariable Long id) throws Exception {
		ServiceProvider serviceProvider = serviceProviderRepository.findById(id)
	            .orElseThrow(() -> new Exception("ServiceProvider " + id + " not found"));
		
		return ResponseEntity.ok().body(serviceProvider);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServiceProvider create(@RequestBody ServiceProvider serviceProvider) {
		return serviceProviderRepository.saveAndFlush(serviceProvider);
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		serviceProviderRepository.deleteById(id);
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.PUT)
	public ServiceProvider update(@PathVariable Long id,@RequestBody ServiceProvider serviceProvider) throws Exception {
		//PUT will expect full object to update. PATCH will need delta
		ServiceProvider exustingServiceProvider = serviceProviderRepository.findById(id).orElseThrow(() -> new Exception("ServiceProvider" + id + " not found"));
		BeanUtils.copyProperties(serviceProvider, exustingServiceProvider, "service_provider_id");
		return serviceProviderRepository.saveAndFlush(exustingServiceProvider);
	}

}
