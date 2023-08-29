create table service_providers (

	service_provider_id  int8,
		
	service_provider_legal_name varchar(150) NOT NULL,
	
	service_provider_display_name varchar(50),
	
	service_provider_status varchar(25) NOT NULL,
	
	service_provider_company_reg_num varchar(50),
	
	service_provider_address varchar(300),
	
	service_provider_country varchar(100) NOT NULL,
	
	service_provider_phone varchar(25),
	
	service_provider_email varchar(100) NOT NULL,
	
	service_provider_logo bytea,
	
	service_provider_website_url varchar(200),
	
	PRIMARY KEY (service_provider_id)

);

create table locations (

	location_id  int8,
		
	location_name varchar(150) NOT NULL,
	
	location_display_name varchar(50),
	
	location_service_provider_id int8 NOT NULL,
	
	location_status varchar(25) NOT NULL,
	
	location_address varchar(300),
	
	location_country varchar(100),
	
	location__phone varchar(25),
	
	location_map_url varchar(250),
	
	PRIMARY KEY (location_id),
	
	FOREIGN KEY (location_service_provider_id) REFERENCES service_providers (service_provider_id)
	
);

create table events (

	event_id  int8,
	
	event_name varchar(100) NOT NULL,
	
	event_status varchar(25) NOT NULL,
	
	event_start_time TIME NOT NULL,
	
	event_end_time TIME NOT NULL,
	
	event_slot_duration_minutes integer NOT NULL,
		
	event_online_platform varchar(25),
	
	event_online_link varchar(25),
	
	event_service_provider_id int8 NOT NULL,
	
	event_location_id int8,
	
	PRIMARY KEY (event_id),
	
	FOREIGN KEY (event_service_provider_id) REFERENCES service_providers (service_provider_id),
	
	FOREIGN KEY (event_location_id) REFERENCES locations (location_id)
 
);

create table users (

	user_id  int8,
	
	user_fullname varchar(100) NOT NULL,
	
	user_display_name varchar(50),
	
	user_type varchar(25) NOT NULL,
	
	user_status varchar(25) NOT NULL,
	
	user_service_provider_id int8 ,
	
	user_login varchar(50) NOT NULL,
	
	user_password varchar(25) NOT NULL,
	
	user_auth_type varchar(25) NOT NULL,
	
	user_access_token text,
	
	user_gender varchar(25),
	
	user_date_of_birth DATE, 
	
	user_email varchar(100) NOT NULL,
	
	user_phone varchar(25),
	
	user_avatar bytea,
	
	PRIMARY KEY (user_id),
	
	FOREIGN KEY (user_service_provider_id) REFERENCES service_providers (service_provider_id)
	
);

create table slots (

	slot_id  int8,
	
	slot_user_id int8 NOT NULL,
	
	slot_event_id int8 NOT NULL,
	
	slot_start_time timestamptz NOT NULL,
	
	slot_end_time timestamptz NOT NULL,
	
	slot_status varchar(25) NOT NULL,
	
	PRIMARY KEY (slot_id),
	
	FOREIGN KEY (slot_user_id) REFERENCES users (user_id),
	
	FOREIGN KEY (slot_event_id) REFERENCES events (event_id)
 
);