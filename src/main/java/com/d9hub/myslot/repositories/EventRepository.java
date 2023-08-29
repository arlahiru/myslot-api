/**
 * 
 */
package com.d9hub.myslot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.d9hub.myslot.models.Event;

/**
 * @author lruhunage
 *
 */
public interface EventRepository extends JpaRepository<Event, Long>{
	
	@Query("SELECT e FROM Event e WHERE e.event_service_provider.service_provider_id = ?1")
	List<Event> findAllEventsByProvider(Long providerId);

}
