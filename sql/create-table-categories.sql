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
INSERT INTO Categories VALUES (10, "Automotive", -1);
INSERT INTO Categories VALUES (20, "Industrial", -1);
INSERT INTO Categories VALUES (30, "Clothing", -1);
INSERT INTO Categories VALUES (40, "Entertainment", -1);
INSERT INTO Categories VALUES (50, "Electronics", -1);
INSERT INTO Categories VALUES (60, "Home", -1);
INSERT INTO Categories VALUES (70, "Sports & Outdoors", -1);
INSERT INTO Categories VALUES (80, "Health & Cosmetics", -1);

/* Automotive */
INSERT INTO Categories VALUES (110, "Parts & Accessories", 10);
INSERT INTO Categories VALUES (120, "Tools Equiptment", 10);
INSERT INTO Categories VALUES (130, "Vehicle Electronics", 10);
INSERT INTO Categories VALUES (140, "Tires & Wheels", 10);
INSERT INTO Categories VALUES (150, "Vehicles", 10);

/* Industrial */
INSERT INTO Categories VALUES (210, "Scientific", 20);
INSERT INTO Categories VALUES (220, "Safety", 20);
INSERT INTO Categories VALUES (230, "Food Service", 20);
INSERT INTO Categories VALUES (240, "Material Handling", 20);

/* Clothing */
INSERT INTO Categories VALUES (31, "Women", 30);
INSERT INTO Categories VALUES (32, "Men", 30);
INSERT INTO Categories VALUES (33, "Girls", 30);
INSERT INTO Categories VALUES (34, "Boys", 30);

/* Entertainment */
INSERT INTO Categories VALUES (41, "Movies", 40);
INSERT INTO Categories VALUES (42, "TV Shows", 40);
INSERT INTO Categories VALUES (43, "Music", 40);
INSERT INTO Categories VALUES (44, "Audiobooks", 40);
INSERT INTO Categories VALUES (45, "Games", 40);

/* Electronics */
INSERT INTO Categories VALUES (51, "Home Theater", 50);
INSERT INTO Categories VALUES (52, "Photo & Video", 50);
INSERT INTO Categories VALUES (53, "Cell Phones", 50);
INSERT INTO Categories VALUES (54, "Headphones", 50);
INSERT INTO Categories VALUES (55, "Wearables", 50);
INSERT INTO Categories VALUES (56, "Computers", 50);
INSERT INTO Categories VALUES (57, "Accessories", 50);
INSERT INTO Categories VALUES (58, "Software", 50);

/* Home */
INSERT INTO Categories VALUES (61, "Kitchen & Dining", 60);
INSERT INTO Categories VALUES (62, "Furniture", 60);
INSERT INTO Categories VALUES (63, "Bedding & Bath", 60);
INSERT INTO Categories VALUES (64, "Appliances", 60);
INSERT INTO Categories VALUES (65, "Lawn & Garden", 60);
INSERT INTO Categories VALUES (66, "Arts & Crafts", 60);
INSERT INTO Categories VALUES (67, "Pets", 60);
INSERT INTO Categories VALUES (68, "Home Improvement", 60);

/* Sports & Outdoors */
INSERT INTO Categories VALUES (71, "Athletic Clothing", 70);
INSERT INTO Categories VALUES (72, "Exercise & Fitness", 70);
INSERT INTO Categories VALUES (73, "Hunting & Fishing", 70);
INSERT INTO Categories VALUES (74, "Fan Shop", 70);
INSERT INTO Categories VALUES (75, "Outdoor Sports", 70);
INSERT INTO Categories VALUES (76, "Outdoor Clothing", 70);
INSERT INTO Categories VALUES (77, "Water Sports", 70);
INSERT INTO Categories VALUES (78, "Winter Sports", 70);

/* Health & Cosmetics */
INSERT INTO Categories VALUES (81, "Luxury Beauty", 80);
INSERT INTO Categories VALUES (82, "Professional Skin Care", 80);
INSERT INTO Categories VALUES (83, "Salon & Spa", 80);
INSERT INTO Categories VALUES (84, "Men's Grooming", 80);
INSERT INTO Categories VALUES (85, "Vitamins", 80);
