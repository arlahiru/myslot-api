/**
 * 
 */
package com.d9hub.myslot.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	@Column(name = "user_type", nullable = false)
	private String user_type;
	
	@Column(name = "user_fullname", nullable = false)
	private String user_fullname;
	
	@Column(name = "user_display_name", nullable = false)
	private String user_display_name;
	
	@Column(name = "user_status", nullable = true)
	private String user_status;
	
	@Column(name = "user_login", nullable = false)
	private String user_login;
	
	@Column(name = "user_password", nullable = false)
	private String user_password;
	
	@Column(name = "user_auth_type", nullable = false)
	private String user_auth_type;
	
	@Column(name = "user_access_token", nullable = true)
	private String user_access_token;	

	@Column(name = "user_gender", nullable = false)
	private String user_gender;
	
	@Column(name = "user_date_of_birth", nullable = false)
	private String user_date_of_birth;
	
	@Column(name = "user_email", nullable = false)
	private String user_email;
	
	@Column(name = "user_phone", nullable = false)
	private String user_phone;
	
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(name = "user_avatar", nullable = false)
	private byte[] user_avatar;
	
	@OneToMany(mappedBy="slot_user")
	@JsonIgnore
	private List<Slot> user_slots;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_service_provider_id")
	private ServiceProvider user_service_provider;
	
	public User() {}
		
}
