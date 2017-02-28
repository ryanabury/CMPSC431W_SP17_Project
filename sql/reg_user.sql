USE fusion;

CREATE TABLE reg_user(
	username VARCHAR(50),
	first_name VARCHAR(25) NOT NULL,
	last_name VARCHAR(25) NOT NULL,
	password VARCHAR(20) NOT NULL,
	PRIMARY KEY(username)
);

CREATE TABLE email(
	email_addr VARCHAR(50),
	username VARCHAR(50),
	PRIMARY KEY(email_addr),
	FOREIGN KEY(username) REFERENCES reg_user(username)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);

CREATE TABLE postal_addr(
	street_addr VARCHAR(50),
	city VARCHAR(50),
	state VARCHAR(50),
	zip integer(9),
	username VARCHAR(50),
	PRIMARY KEY(street_addr, city, state, zip),
	FOREIGN KEY(username) REFERENCES reg_user(username)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);

CREATE TABLE credit_card(
	card_number integer(16),
	type VARCHAR(20) NOT NULL,
	cvv integer(3) NOT NULL,
	exp_date date NOT NULL,
	username VARCHAR(50),
	PRIMARY KEY(card_number),
	FOREIGN KEY(username) REFERENCES reg_user(username)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);

CREATE TABLE profile_page(
	pid VARCHAR(20),
	banner_img VARCHAR(512),
	about_description VARCHAR(250),
	username VARCHAR(50),
	PRIMARY KEY(pid),
	FOREIGN KEY(username) REFERENCES reg_user(username)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);

CREATE TABLE user_rating(
	rid VARCHAR(20),
	score integer(1) NOT NULL,
	description varchar(50) NOT NULL,
	comment varchar(250),
	pid VARCHAR(20),
	PRIMARY KEY(rid),
	FOREIGN KEY(pid) REFERENCES profile_page(pid)
);