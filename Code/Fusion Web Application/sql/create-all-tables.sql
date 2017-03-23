USE fusion;

CREATE TABLE Categories (
    id integer NOT NULL,
    name varchar(50) NOT NULL,
    parentID integer,
    PRIMARY KEY (id)
);

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
	card_number 		VARCHAR(16),
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

CREATE TABLE suppliers (
	supplier_id			INTEGER 	NOT NULL,
	company_name 		VARCHAR(50) NOT NULL,
	password 			VARCHAR(20) NOT NULL,
	category			VARCHAR(20) NOT NULL,
	yearly_revenue		INTEGER,			/* monetary unit is cents */

	/* supplier profile page attributes */
	url_ext				VARCHAR(30),		/* supplier specific URL extension */
	banner_img 			VARCHAR(512),
	about_description 	VARCHAR(250),

	/* constraints */
	PRIMARY KEY (supplier_id)
);

CREATE TABLE contact_info(
	point_of_contact 	VARCHAR(20),
	street_addr 		VARCHAR(50),
	city 				VARCHAR(50),
	state 				VARCHAR(50),
	zip 				INTEGER(9),
	email				VARCHAR(35) NOT NULL,
	phone_number		CHAR(10) 	NOT NULL,
	supplier_id			INTEGER 	NOT NULL,

	/* constraints */
	PRIMARY KEY (point_of_contact, supplier_id),
	FOREIGN KEY(supplier_id) REFERENCES suppliers(supplier_id)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);

CREATE TABLE suppliers_rating(
	rid 				VARCHAR(20),
	time_stamp			TIMESTAMP 	NOT NULL,
	score 				INTEGER(1) 	NOT NULL,
	description 		VARCHAR(50) NOT NULL,
	comment 			VARCHAR(250),
	supplier_id 		INTEGER(20),
	PRIMARY KEY(rid, supplier_id),
	FOREIGN KEY(supplier_id) REFERENCES suppliers(supplier_id)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);

CREATE TABLE sale_items (
	id 						INTEGER 	NOT NULL,
	name 					VARCHAR(50) NOT NULL,
	seller 					INTEGER,
	price 					INTEGER 	NOT NULL, 	/* Given in Cents */
	reservePrice 			INTEGER, 				/* Given in Cents */
	quantity 				INTEGER 	NOT NULL,
	category 				INTEGER,
	detailedDescriptionURL 	VARCHAR(100),
	typeOfSale 				INTEGER 	NOT NULL,
	description 			VARCHAR(500),

	/* constraints */
	PRIMARY KEY (id, detailedDescriptionURL),
	FOREIGN KEY(seller) REFERENCES suppliers(supplier_id)
		ON DELETE CASCADE
		ON UPDATE NO ACTION,
	FOREIGN KEY(category) REFERENCES Categories(id)
		ON DELETE NO ACTION
		ON UPDATE SET NULL
);

CREATE TABLE sale_items_rating(
	rid 					VARCHAR(20),
	time_stamp				TIMESTAMP 	NOT NULL,
	score 					INTEGER(1) 	NOT NULL,
	description 			VARCHAR(50) NOT NULL,
	comment 				VARCHAR(250),
	id 						INTEGER,
	PRIMARY KEY(rid, id),
	FOREIGN KEY(id) REFERENCES sale_items(id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);

CREATE TABLE sales_transaction(
	sale_id				INTEGER,
	credit_card			INTEGER 	NOT NULL,
	status 				VARCHAR(10)	NOT NULL,
	completion_date 	TIMESTAMP,
	item_id				INTEGER 	NOT NULL,
	quantity 			INTEGER 	NOT NULL,
	sale_price			INTEGER		NOT NULL,	/* monetary unit: cents */

	/* constraints */
	PRIMARY KEY (sale_id),
	FOREIGN KEY	(item_id) REFERENCES sale_items(id),
	FOREIGN KEY (credit_card) REFERENCES credit_card(card_number)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);

CREATE TABLE shipping_addr(
	sale_id				INTEGER,
	street_addr 		VARCHAR(50),
	city 				VARCHAR(50),
	state 				VARCHAR(50),
	zip 				INTEGER(9),
	buyer_id			VARCHAR(50) NOT NULL,

	/* constraints */
	PRIMARY KEY (sale_id, street_addr, city, state, zip),
	FOREIGN KEY (sale_id) REFERENCES sales_transaction(sale_id)
		ON DELETE CASCADE
		ON UPDATE NO ACTION,
	FOREIGN KEY (buyer_id) REFERENCES Users(reg_id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);
