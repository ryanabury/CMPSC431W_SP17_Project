USE fusion;

/* Create Table */
CREATE TABLE Categories (
    id integer NOT NULL,
    name varchar(50) NOT NULL,
    parentID integer,
    PRIMARY KEY (id)
);

/* Populate Table */

/* Parent Categories */
INSERT INTO Categories VALUES (100000, "Automotive", -1);
INSERT INTO Categories VALUES (200000, "Industrial", -1);
INSERT INTO Categories VALUES (300000, "Clothing", -1);
INSERT INTO Categories VALUES (400000, "Entertainment", -1);
INSERT INTO Categories VALUES (500000, "Electronics", -1);
INSERT INTO Categories VALUES (600000, "Home", -1);
INSERT INTO Categories VALUES (700000, "Sports & Outdoors", -1);
INSERT INTO Categories VALUES (800000, "Health & Cosmetics", -1);

// Automotive
INSERT INTO Categories VALUES (110000, "Parts & Accessories", 100000);
INSERT INTO Categories VALUES (120000, "Tools Equiptment", 100000);
INSERT INTO Categories VALUES (130000, "Vehicle Electronics", 100000);
INSERT INTO Categories VALUES (140000, "Tires & Wheels", 100000);
INSERT INTO Categories VALUES (150000, "Vehicles", 100000);

// Industrial
INSERT INTO Categories VALUES (210000, "Scientific", 200000);
INSERT INTO Categories VALUES (220000, "Safety", 200000);
INSERT INTO Categories VALUES (230000, "Food Service", 200000);
INSERT INTO Categories VALUES (240000, "Material Handling", 200000);

// Clothing
INSERT INTO Categories VALUES (31000, "Women", 30000);
INSERT INTO Categories VALUES (32000, "Men", 30000);
INSERT INTO Categories VALUES (33000, "Girls", 30000);
INSERT INTO Categories VALUES (34000, "Boys", 30000);
