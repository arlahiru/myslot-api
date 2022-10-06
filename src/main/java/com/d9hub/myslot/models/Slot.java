/**
 * 
 */
package com.d9hub.myslot.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author lruhunage
 *
 */

@Entity
@Table(name = "slots")
@Getter 
@Setter
@AllArgsConstructor
public  class Slot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long slot_id;
	
	@Column(name = "slot_user_id", nullable = false)
	private Long slot_user_id; // user who book the slot
	
	@Column(name = "slot_user_name", nullable = false)
	private String slot_user_name; // actual name or guests
	
	@Column(name = "slot_time", nullable = false)
	private LocalDate slot_time;
	
	@Column(name = "slot_online_platform", nullable = true)
	private String slot_online_platform;
	
	@Column(name = "slot_online_link", nullable = true)
	private String slot_online_link;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "slot_service_provider_id")
	private ServiceProvider service_provider; // company or individual who provide the services
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "slot_location_id")
	private Location location; // location
		
	public Slot() {
		
	}

}
