/**
 * 
 */
package com.d9hub.myslot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
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
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long user_id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_service_provider_id")
	ServiceProvider user_service_provider_id;
	
	@Column(name = "user_type", nullable = false)
	String user_type;
	
	@Column(name = "user_fullname", nullable = false)
	String user_fullname;
	
	@Column(name = "user_display_name", nullable = false)
	String user_display_name;
	
	@Column(name = "user_login", nullable = false)
	String user_login;
	
	@Column(name = "user_password", nullable = false)
	String user_password;
	
	@Column(name = "user_auth_type", nullable = false)
	String user_auth_type;
	
	@Column(name = "user_access_token", nullable = true)
	String user_access_token;	

	@Column(name = "user_gender", nullable = false)
	String user_gender;
	
	@Column(name = "user_date_of_birth", nullable = false)
	String user_date_of_birth;
	
	@Column(name = "user_email", nullable = false)
	String user_email;
	
	@Column(name = "user_phone", nullable = false)
	String user_phone;
	
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(name = "user_avatar", nullable = false)
	String user_avatar;
		
}
