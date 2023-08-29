/**
 * 
 */
package com.d9hub.myslot.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

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
@Table(name = "service_providers")
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ServiceProvider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long service_provider_id;
	
	@Column(name = "service_provider_display_name", nullable = true)
	private String service_provider_display_name;
	
	@Column(name = "service_provider_legal_name", nullable = false)
	private String service_provider_legal_name;
	
	@Column(name = "service_provider_status", nullable = true)
	private String service_provider_status;
	
	@Column(name = "service_provider_company_reg_num", nullable = true)
	private String service_provider_company_reg_num;
	
	@Column(name = "service_provider_address", nullable = false)
	private String service_provider_address;
	
	@Column(name = "service_provider_country", nullable = false)
	private String service_provider_country;
	
	@Column(name = "service_provider_phone", nullable = false)
	private String service_provider_phone;
	
	@Column(name = "service_provider_email", nullable = false)
	private String service_provider_email;	
	
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(name = "service_provider_logo", nullable = true)
	private byte[] service_provider_logo;
	
	@Column(name = "service_provider_website_url", nullable = true)
	private String service_provider_website_url;
	
	@OneToMany(mappedBy="event_service_provider")
	@JsonIgnore
	private List<Event> service_provider_events;
	
	@OneToMany(mappedBy="user_service_provider")
	@JsonIgnore
	private List<User> service_provider_users;
	
	@OneToMany(mappedBy="location_service_provider")
	@JsonIgnore
	private List<Location> service_provider_locations;
	
	
	public ServiceProvider() {}

}
