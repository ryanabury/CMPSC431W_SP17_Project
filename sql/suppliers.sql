CREATE TABLE suppliers (
	name 				VARCHAR(50) NOT NULL,
	address 			VARCHAR(50),
	password 			VARCHAR(20) NOT NULL,
	point_of_contact 	VARCHAR(20),	
	email				VARCHAR(35) NOT NULL,
	phone_number		CHAR(10) 	NOT NULL,
	category			VARCHAR(20) NOT NULL,
	yearly_revenue		INTEGER,			/* monetary unit is cents */
	profile_page		VARCHAR(30),		/* user specific URL extension */

	PRIMARY KEY name,
	CONSTRAINT fk_address FOREIGN KEY (address) 
	REFERENCES postal_address(address) ON DELETE CASCADE
);