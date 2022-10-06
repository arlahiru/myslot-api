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

import com.d9hub.myslot.models.Slot;
import com.d9hub.myslot.repositories.SlotRepository;

/**
 * @author lruhunage
 *
 */

@RestController
@RequestMapping("/api/v1/slots")
public class SlotController {
	
	@Autowired
	private SlotRepository slotRepository;
	
	@GetMapping
	public List<Slot> getAllSlots() {
	   return slotRepository.findAll();
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.GET)
	public ResponseEntity<Slot> get(@PathVariable Long id) throws Exception {
		Slot slot = slotRepository.findById(id)
	            .orElseThrow(() -> new Exception("Slot " + id + " not found"));
		
		return ResponseEntity.ok().body(slot);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Slot create(@RequestBody Slot slot) {
		return slotRepository.saveAndFlush(slot);
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		slotRepository.deleteById(id);
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.PUT)
	public Slot update(@PathVariable Long id,@RequestBody Slot slot) throws Exception {
		//PUT will expect full object to update. PATCH will need delta
		Slot existingSlot = slotRepository.findById(id).orElseThrow(() -> new Exception("Slot " + id + " not found"));
		BeanUtils.copyProperties(slot, existingSlot, "slot_id");
		return slotRepository.saveAndFlush(slot);
	}

}
