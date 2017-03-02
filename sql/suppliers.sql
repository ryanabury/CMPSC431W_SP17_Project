USE fusion;

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
	PRIMARY KEY (supplier_id),
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
	)

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
