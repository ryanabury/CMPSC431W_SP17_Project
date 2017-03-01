USE fusion;

CREATE TABLE sales (
	buyer_id			VARCHAR(50) NOT NULL,
	item_id				INTEGER 	NOT NULL,
	seller_id			VARCHAR(50) NOT NULL,
	credit_card			INTEGER 	NOT NULL,
	sale_price			INTEGER 	NOT NULL, 	/* monetary unit: cents */
	transaction_status 	VARCHAR(10) NOT NULL,
	completion_date		VARCHAR(10),

	PRIMARY KEY (item_id),
	
	FOREIGN KEY (buyer_id) REFERENCES user(reg_id),
	
	FOREIGN KEY (seller_id) REFERENCES suppliers(supplier_id),
	
	FOREIGN KEY (credit_card) REFERENCES credit_card(card_number),
	
	FOREIGN KEY	(item_id) REFERENCES sales_item(id)
);
