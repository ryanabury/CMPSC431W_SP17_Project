CREATE TABLE sale_items (
	id integer NOT NULL,
	name varchar(50) NOT NULL,
	hasBeenSold boolean,
	seller integer,
	price integer NOT NULL, /* Given in Cents */
	reservePrice integer, /* Given in Cents */
	quanity integer NOT NULL,
	category integer NOT NULL,
	detailedDescriptionURL varchar(100),
	shippedStateID integer,
	typeOfSale integer NOT NULL,
	description varchar(500),
	PRIMARY KEY (id)
);
