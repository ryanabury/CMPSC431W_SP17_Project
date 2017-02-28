USE fusion;

/* active users table */
CREATE TABLE active_user(
	reg_id VARCHAR(20),
	email VARCHAR(50),
	username VARCHAR(50) NOT NULL,
	first_name VARCHAR(25) NOT NULL,
	last_name VARCHAR(25) NOT NULL,
	password VARCHAR(20) NOT NULL,
	age integer(3),
	phone_num VARCHAR(10),
	gender VARCHAR(1),
	annual_salary integer(12),

	/* user profile page attributes*/
	url_ext VARCHAR(30),		/* user specific URL extension */
	profile_img VARCHAR(512),
	about_description VARCHAR(250),

	/* constraints */
	PRIMARY KEY(reg_id, email)
);

/* inactive users table */
CREATE TABLE inactive_user(
	reg_id VARCHAR(20),
	email VARCHAR(50),
	age integer(3),
	phone_num VARCHAR(10),
	gender VARCHAR(1),
	annual_salary integer,
	PRIMARY KEY(reg_id, email)
);

CREATE TABLE postal_addr(
	street_addr VARCHAR(50),
	city VARCHAR(50),
	state VARCHAR(50),
	zip integer(9),
	reg_id VARCHAR(20),
	PRIMARY KEY(street_addr, city, state, zip, reg_id),
	FOREIGN KEY(reg_id) REFERENCES active_user(reg_id)
		ON DELETE SET NULL
		ON UPDATE NO ACTION
);

CREATE TABLE credit_card(
	card_number integer(16),
	type VARCHAR(20) NOT NULL,
	cvv integer(3) NOT NULL,
	exp_date date NOT NULL,
	reg_id VARCHAR(20),
	PRIMARY KEY(card_number, reg_id),
	FOREIGN KEY(reg_id) REFERENCES active_user(reg_id)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);

CREATE TABLE user_rating(
	rid VARCHAR(20),
	score integer(1) NOT NULL,
	description VARCHAR(50) NOT NULL,
	comment VARCHAR(250),
	reg_id VARCHAR(20),
	PRIMARY KEY(rid, reg_id),
	FOREIGN KEY(reg_id) REFERENCES active_user(reg_id)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);