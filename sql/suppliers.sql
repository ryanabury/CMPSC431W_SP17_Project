USE fusion;

CREATE TABLE suppliers (
	company_name 		VARCHAR(50) NOT NULL,
	supplier_id			INTEGER NOT NULL,	/* primary key */
	address 			VARCHAR(50),
	password 			VARCHAR(20) NOT NULL,
	point_of_contact 	VARCHAR(20),	
	company_email		VARCHAR(35) NOT NULL,
	phone_number		CHAR(10) NOT NULL,
	category			VARCHAR(20) NOT NULL,
	yearly_revenue		INTEGER,			/* monetary unit is cents */

	/* supplier profile page attributes */
	url_ext				VARCHAR(30),		/* supplier specific URL extension */
	banner_img 			VARCHAR(512),
	about_description 	VARCHAR(250),

	/* constraints */
	PRIMARY KEY supplier_id,
	CONSTRAINT fk_address FOREIGN KEY (address) 
	REFERENCES postal_addr(address) ON DELETE CASCADE
);

CREATE TABLE suppliers_rating(
	rid VARCHAR(20),
	score INTEGER(1) NOT NULL,
	description VARCHAR(50) NOT NULL,
	comment varchar(250),
	supplier_id INTEGER(20),
	PRIMARY KEY(rid, supplier_id),
	FOREIGN KEY(supplier_id) REFERENCES suppliers(supplier_id)
);
