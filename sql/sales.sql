USE fusion;

CREATE TABLE sales_transaction(
	sale_id				INTEGER,
	credit_card			INTEGER 	NOT NULL,
	status 				VARCHAR(10)	NOT NULL,
	completion_date 	TIMESTAMP,
	item_id				INTEGER 	NOT NULL,
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
		ON UPDATE NO ACTION
);

