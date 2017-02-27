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

/* Automotive */
INSERT INTO Categories VALUES (110000, "Parts & Accessories", 100000);
INSERT INTO Categories VALUES (120000, "Tools Equiptment", 100000);
INSERT INTO Categories VALUES (130000, "Vehicle Electronics", 100000);
INSERT INTO Categories VALUES (140000, "Tires & Wheels", 100000);
INSERT INTO Categories VALUES (150000, "Vehicles", 100000);

/* Industrial */
INSERT INTO Categories VALUES (210000, "Scientific", 200000);
INSERT INTO Categories VALUES (220000, "Safety", 200000);
INSERT INTO Categories VALUES (230000, "Food Service", 200000);
INSERT INTO Categories VALUES (240000, "Material Handling", 200000);

/* Clothing */
INSERT INTO Categories VALUES (31000, "Women", 30000);
INSERT INTO Categories VALUES (32000, "Men", 30000);
INSERT INTO Categories VALUES (33000, "Girls", 30000);
INSERT INTO Categories VALUES (34000, "Boys", 30000);

/* Entertainment */
INSERT INTO Categories VALUES (41000, "Movies", 40000);
INSERT INTO Categories VALUES (42000, "TV Shows", 40000);
INSERT INTO Categories VALUES (43000, "Music", 40000);
INSERT INTO Categories VALUES (44000, "Audiobooks", 40000);
INSERT INTO Categories VALUES (45000, "Games", 40000);

/* Electronics */
INSERT INTO Categories VALUES (51000, "Home Theater", 50000);
INSERT INTO Categories VALUES (52000, "Photo & Video", 50000);
INSERT INTO Categories VALUES (53000, "Cell Phones", 50000);
INSERT INTO Categories VALUES (54000, "Headphones", 50000);
INSERT INTO Categories VALUES (55000, "Wearables", 50000);
INSERT INTO Categories VALUES (56000, "Computers", 50000);
INSERT INTO Categories VALUES (57000, "Accessories", 50000);
INSERT INTO Categories VALUES (58000, "Software", 50000);

/* Home */
INSERT INTO Categories VALUES (61000, "Kitchen & Dining", 60000);
INSERT INTO Categories VALUES (62000, "Furniture", 60000);
INSERT INTO Categories VALUES (63000, "Bedding & Bath", 60000);
INSERT INTO Categories VALUES (64000, "Appliances", 60000);
INSERT INTO Categories VALUES (65000, "Lawn & Garden", 60000);
INSERT INTO Categories VALUES (66000, "Arts & Crafts", 60000);
INSERT INTO Categories VALUES (67000, "Pets", 60000);
INSERT INTO Categories VALUES (68000, "Home Improvement", 60000);
