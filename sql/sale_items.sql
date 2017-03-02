USE fusion;

CREATE TABLE sale_items (
	id 						INTEGER 	NOT NULL,
	name 					VARCHAR(50) NOT NULL,
	seller 					INTEGER,
	price 					INTEGER 	NOT NULL, 	/* Given in Cents */
	reservePrice 			INTEGER, 				/* Given in Cents */
	quantity 				INTEGER 	NOT NULL,
	category 				INTEGER 	NOT NULL,
	detailedDescriptionURL 	VARCHAR(100),
	typeOfSale 				INTEGER 	NOT NULL,
	description 			VARCHAR(500),

	/* constraints */
	PRIMARY KEY (id, detailedDescriptionURL),
	FOREIGN KEY(seller) REFERENCES suppliers(supplier_id),
		ON DELETE CASCADE
		ON UPDATE NO ACTION
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
	id 						VARCHAR(20),
	PRIMARY KEY(rid, id),
	FOREIGN KEY(id) REFERENCES sale_items(id)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);
