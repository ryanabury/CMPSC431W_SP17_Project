USE fusion;

CREATE TABLE sale_items (
	id 						INTEGER 	NOT NULL,
	name 					VARCHAR(50) NOT NULL,
	hasBeenSold 			BOOLEAN,
	seller 					INTEGER,
	price 					INTEGER 	NOT NULL, /* Given in Cents */
	reservePrice 			INTEGER, /* Given in Cents */
	quantity 				INTEGER 	NOT NULL,
	category 				INTEGER 	NOT NULL,
	detailedDescriptionURL 	VARCHAR(100),
	shippedStateID 			INTEGER,
	typeOfSale 				INTEGER 	NOT NULL,
	description 			VARCHAR(500),
	PRIMARY KEY (id)
);

CREATE TABLE sale_items_rating(
	rid 					VARCHAR(20),
	score 					INTEGER(1) NOT NULL,
	description 			VARCHAR(50) NOT NULL,
	comment 				VARCHAR(250),
	id 						VARCHAR(20),
	PRIMARY KEY(rid, id),
	FOREIGN KEY(id) REFERENCES sale_items(id)
		ON DELETE CASCADE
		ON UPDATE NO ACTION
);
