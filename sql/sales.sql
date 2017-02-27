CREATE TABLE sales (
	buyer_id	VARCHAR(50) 	NOT NULL,
	item_id		INTEGER 	NOT NULL,
	seller_id	VARCHAR(50) 	NOT NULL,
	credit_card	INTEGER 	NOT NULL,
	sale_price	INTEGER 	NOT NULL, 	/* monetary unit: cents */
	status		VARCHAR(10) 	NOT NULL,
	completion_date	VARCHAR(10),

	PRIMARY KEY 	item_id,
	
	CONSTRAINT 	fk_buyer 
	FOREIGN KEY 	(buyer_id) 
	REFERENCES 	credit_card(username),
	
	CONSTRAINT 	fk_seller 
	FOREIGN KEY 	(seller_id) 
	REFERENCES 	reg_user(username),
	
	CONSTRAINT 	fk_credit 
	FOREIGN KEY 	(credit_card) 	
	REFERENCES 	credit_card(card_number),
	
	CONSTRAINT 	fk_item
	FOREIGN KEY	(item_id)
	REFERENCES 	sales_item(id),
);
