CREATE TABLE reg_user(
	username varchar2(50),
	first_name varchar2(25) NOT NULL,
	last_name varchar2(25) NOT NULL,
	password varchar2(20) NOT NULL,
	PRIMARY KEY(username)
)

CREATE TABLE email(
	email_addr varchar2(50),
	username varchar2(50),
	PRIMARY KEY(email_addr),
	FOREIGN KEY(username) REFERENCES reg_user(username)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
)

CREATE TABLE postal_addr(
	street_addr varchar2(50),
	city varchar2(50),
	state varchar2(50),
	zip integer(9),
	username varchar2(50),
	PRIMARY KEY(street_addr, city, state, zip),
	FOREIGN KEY(username) REFERENCES reg_user(username)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
)

CREATE TABLE credit_card(
	card_number integer(16),
	type varchar2(20) NOT NULL,
	cvv integer(3) NOT NULL,
	exp_date date NOT NULL,
	username varchar2(50),
	PRIMARY KEY(card_number),
	FOREIGN KEY(username) REFERENCES reg_user(username)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
)

CREATE TABLE profile_page(
	pid varchar2(20),
	banner_img varbinary(max),
	about_description varchar2(250),
	username varchar2(50),
	PRIMARY KEY(pid),
	FOREIGN KEY(username) REFERENCES reg_user(username)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
)

CREATE TABLE user_rating(
	rid varchar2(20),
	score integer(1) NOT NULL,
	description varchar(50) NOT NULL,
	comment varchar(250),
	pid varchar2(20),
	PRIMARY KEY(rid),
	FOREIGN KEY(pid) REFERENCES profile_page(pid)
)