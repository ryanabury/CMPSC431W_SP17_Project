CREATE TABLE suppliers (
	company_name 		VARCHAR(50) NOT NULL,
	supplier_id		INTEGER NOT NULL,	/* primary key */
	address 		VARCHAR(50),
	password 		VARCHAR(20) NOT NULL,
	point_of_contact 	VARCHAR(20),	
	company_email		VARCHAR(35) NOT NULL,
	phone_number		CHAR(10) NOT NULL,
	category		VARCHAR(20) NOT NULL,
	yearly_revenue		INTEGER,		/* monetary unit is cents */
	profile_page		VARCHAR(30),		/* user specific URL extension */

	PRIMARY KEY supplier_id,
	CONSTRAINT fk_address FOREIGN KEY (address) 
	REFERENCES postal_addr(address) ON DELETE CASCADE
);
