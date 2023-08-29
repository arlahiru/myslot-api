/**
 * 
 */
package com.d9hub.myslot.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author lruhunage
 *
 */

@Entity
@Table(name = "events")
@Getter 
@Setter
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public  class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long event_id;

	@Column(name = "event_name", nullable = false)
	private String event_name;
	
	@Column(name = "event_status", nullable = false)
	private String event_status;
	
	@Column(name = "event_start_time", nullable = false)
	private LocalDate event_start_time;
	
	@Column(name = "event_end_time", nullable = false)
	private LocalDate event_end_time;
	
	@Column(name = "event_slot_duration_minutes", nullable = false)
	private int event_slot_duration_minutes;
	
	@Column(name = "event_online_platform", nullable = true)
	private String event_online_platform;
	
	@Column(name = "event_online_link", nullable = true)
	private String event_online_link;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_service_provider_id", nullable = false)
	private ServiceProvider event_service_provider; // company or individual who provide the services
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_location_id", nullable = true)
	private Location event_location; // location
	
	@OneToMany(mappedBy = "slot_event")
	@JsonIgnore
	private List<Slot> event_slots;
		
	public Event() {
		
	}

}
