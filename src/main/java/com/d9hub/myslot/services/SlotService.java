package com.d9hub.myslot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.d9hub.myslot.models.Slot;
import com.d9hub.myslot.repositories.SlotRepository;


@Service
public class SlotService {
	
	@Autowired
	private SlotRepository slotRepository;
	

	public List<Slot> getSlots(int pageNo, int pageSize, String sortBy) {

		PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Slot> pagedResult = slotRepository.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Slot>();
		}

	}
	
	public Optional<Slot> getSlot(Long id) {
		return slotRepository.findById(id);

	}

	public Slot saveNewSlot(Slot slot) {
		slotRepository.save(slot);
		return slot;
	}

	public Slot updateSlot(Slot slot) {
		slotRepository.save(slot);
		return slot;
	}

	public void deleteSlot(Long id) {
		slotRepository.deleteById(id);

	}

}
