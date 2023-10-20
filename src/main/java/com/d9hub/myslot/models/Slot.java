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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public  class Slot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "slot_id", nullable = false)
	private Long id;
	
	@Column(name = "slot_start_time", nullable = false)
	private LocalDate slot_start_time;
	
	@Column(name = "slot_end_time", nullable = false)
	private LocalDate slot_end_time;
	
	@Column(name = "slot_status", nullable = true)
	private String slot_status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "slot_user_id")
	private User slot_user; // user
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "slot_event_id")
	private Event slot_event; // user
		
	public Slot() {
		
	}

}
