create table slots (

	slot_id  int8,
	
	slot_service_provider_id int8,
	
	slot_user_id int8,
	
	slot_user_name varchar(200),
	
	slot_time timestamptz,
	
	slot_location_id int8,
	
	slot_online_platform varchar(200),
	
	slot_online_link varchar(500)

);

create table users (

	user_id  int8,
	
	user_service_provider_id int8,
	
	user_type varchar(25),
	
	user_fullname varchar(100),
	
	user_display_name varchar(50),
	
	user_login varchar(50),
	
	user_password varchar(25),
	
	user_auth_type varchar(25),
	
	user_access_token text,
	
	user_gender varchar(25),
	
	user_date_of_birth DATE, 
	
	user_email varchar(100),
	
	user_phone varchar(25),
	
	user_avatar bytea

);

create table service_providers (

	service_provider_id  int8,
	
	service_provider_legal_name varchar(150),
	
	service_provider_display_name varchar(50),
	
	service_provider_company_reg_num varchar(50),
	
	service_provider_address varchar(300),
	
	service_provider_country varchar(100),
	
	service_provider_phone varchar(25),
	
	service_provider_logo bytea,
	
	service_provider_website_url varchar(200)

);

create table locations (

	location_id  int8,
	
	location_service_provider_id int8,
	
	location_name varchar(150),
	
	location_display_name varchar(50),
	
	location_address varchar(300),
	
	location_country varchar(100),
	
	location__phone varchar(25),
	
	location_map_url varchar(250)

);