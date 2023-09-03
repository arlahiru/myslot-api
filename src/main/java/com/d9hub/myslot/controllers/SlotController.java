/**
 * 
 */
package com.d9hub.myslot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.d9hub.myslot.exception.SlotException;
import com.d9hub.myslot.models.Slot;
import com.d9hub.myslot.services.SlotService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * @author lruhunage
 *
 */

@RestController
@RequestMapping("/api/v1/slots")
public class SlotController {
	
	@Autowired
	private SlotService slotService;
	
	@Operation(summary = "Get list of slots (Sorted by id in default), you must specify page number and page size. Default page size is 10.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful Operation", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Invalid parameters supplied", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Error", content = @Content) })
	@GetMapping
	public ResponseEntity<List<Slot>> getAllSlots(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
		List<Slot> stocks = slotService.getSlots(pageNo, pageSize, sortBy);

		return new ResponseEntity<List<Slot>>(stocks, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.GET)
	public ResponseEntity<Slot> get(@PathVariable Long id) throws Exception {
		Optional<Slot> slot = slotService.getSlot(id);
		
		if (slot.isPresent()) {
			return ResponseEntity.ok().body(slot.get());
		} else {
			throw new SlotException("Slot does not exist");
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Slot create(@RequestBody Slot slot) {
		return slotService.saveNewSlot(slot);
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		slotService.deleteSlot(id);
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.PUT)
	public Slot update(@PathVariable Long id,@RequestBody Slot slot) throws Exception {
		//PUT will expect full object to update. PATCH will need delta
		Slot existingSlot = slotService.getSlot(id).orElseThrow(() -> new Exception("Slot " + id + " not found"));
		BeanUtils.copyProperties(slot, existingSlot, "slot_id");
		return slotService.updateSlot(existingSlot);
	}

}
