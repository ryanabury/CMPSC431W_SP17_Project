USE fusion;

CREATE TABLE Users (
	reg_id 				VARCHAR(20),
	email 				VARCHAR(50),
	active 				BOOLEAN,			/* active user == true, inactive user == false */
	username 			VARCHAR(50),		/* active user must have username; enforced in front end */
	first_name 			VARCHAR(25),		/* active user must have first_name; enforced in front end */
	last_name 			VARCHAR(25),		/* active user must have last_name; enforced in front end */
	password 			VARCHAR(20),		/* active user must have password; enforced in front end */
	age 				INTEGER(3),
	phone_num 			VARCHAR(10),
	gender 				VARCHAR(1),
	annual_salary 		INTEGER(12),

	/* constraints */
	UNIQUE (username, phone_num),
	PRIMARY KEY(reg_id, email)
);

CREATE TABLE postal_addr(
	street_addr 		VARCHAR(50),
	city 				VARCHAR(50),
	state 				VARCHAR(50),
	zip 				INTEGER(9),
	reg_id 				VARCHAR(20),
	PRIMARY KEY(street_addr, city, state, zip, reg_id),
	FOREIGN KEY(reg_id) REFERENCES Users(reg_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);

CREATE TABLE credit_card(
	card_number 		INTEGER(16),
	type 				VARCHAR(20) NOT NULL,
	cvv 				INTEGER(3) 	NOT NULL,
	exp_date 			DATE 		NOT NULL,
	first_name 			VARCHAR(25),	/* first name may be different from user's first name */
	last_name 			VARCHAR(25),	/* last name may be different from user's last name */
	reg_id 				VARCHAR(20),
	PRIMARY KEY(card_number, reg_id),
	FOREIGN KEY(reg_id) REFERENCES Users (reg_id)
		ON DELETE NO ACTION 		/* credit card tuple deleted if user account becomes inactive */
		ON UPDATE NO ACTION
);

CREATE TABLE billing_addr(
	street_addr 		VARCHAR(50),
	city 				VARCHAR(50),
	state 				VARCHAR(50),
	zip 				INTEGER(9),
	card_number 		INTEGER(16),
	PRIMARY KEY(street_addr, city, state, zip, card_number),
	FOREIGN KEY(card_number) REFERENCES credit_card(card_number)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);
