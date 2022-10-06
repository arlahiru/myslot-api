/**
 * 
 */
package com.d9hub.myslot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

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
public class ServiceProvider {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long service_provider_id;
	
	@Column(name = "service_provider_display_name", nullable = true)
	String service_provider_display_name;
	
	@Column(name = "service_provider_legal_name", nullable = false)
	String service_provider_legal_name;
	
	@Column(name = "service_provider_company_reg_num", nullable = true)
	String service_provider_company_reg_num;
	
	@Column(name = "service_provider_address", nullable = false)
	String service_provider_address;
	
	@Column(name = "service_provider_country", nullable = false)
	String service_provider_country;
	
	@Column(name = "service_provider_phone", nullable = false)
	String service_provider_phone;
	
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(name = "service_provider_logo", nullable = true)
	byte[] service_provider_logo;
	
	@Column(name = "service_provider_website_url", nullable = true)
	String service_provider_website_url;

}
