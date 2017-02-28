USE fusion;

CREATE TABLE sale_items (
	id integer NOT NULL,
	name varchar(50) NOT NULL,
	hasBeenSold boolean,
	seller integer,
	price integer NOT NULL, /* Given in Cents */
	reservePrice integer, /* Given in Cents */
	quantity integer NOT NULL,
	category integer NOT NULL,
	detailedDescriptionURL varchar(100),
	shippedStateID integer,
	typeOfSale integer NOT NULL,
	description varchar(500),
	PRIMARY KEY (id)
);

CREATE TABLE sale_items_rating(
	rid VARCHAR(20),
	score integer(1) NOT NULL,
	description VARCHAR(50) NOT NULL,
	comment VARCHAR(250),
	id VARCHAR(20),
	PRIMARY KEY(rid, id),
	FOREIGN KEY(id) REFERENCES sale_items(id)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);
