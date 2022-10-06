package com.d9hub.myslot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "locations")
@Getter
@Setter
@AllArgsConstructor
public class Location {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long location_id;
	
	@Column(name = "location_service_provider_id", nullable = false)
	private Long location_service_provider_id;
	
	@Column(name = "location_name", nullable = false)
	private String location_name;
	
	@Column(name = "location_display_name", nullable = true)
	private String location_display_name;
	
	@Column(name = "location_address", nullable = true)
	private String location_address;
	
	@Column(name = "location_country", nullable = true)
	private String location_country;
	
	@Column(name = "location__phone", nullable = true)
	private String location__phone;
	
	@Column(name = "location_map_url", nullable = true)
	private String location_map_url;

}
