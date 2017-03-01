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
INSERT INTO Categories VALUES (01, "Automotive", 0);
INSERT INTO Categories VALUES (02, "Industrial", 0);
INSERT INTO Categories VALUES (03, "Clothing", 0);
INSERT INTO Categories VALUES (04, "Entertainment", 0);
INSERT INTO Categories VALUES (05, "Electronics", 0);
INSERT INTO Categories VALUES (06, "Home", 0);
INSERT INTO Categories VALUES (07, "Sports & Outdoors", 0);
INSERT INTO Categories VALUES (08, "Health & Cosmetics", 0);

/* Automotive */
INSERT INTO Categories VALUES (0101, "Parts & Accessories", 10);
INSERT INTO Categories VALUES (0201, "Tools Equiptment", 10);
INSERT INTO Categories VALUES (0301, "Vehicle Electronics", 10);
INSERT INTO Categories VALUES (0401, "Tires & Wheels", 10);
INSERT INTO Categories VALUES (0501, "Vehicles", 10);

/* Industrial */
INSERT INTO Categories VALUES (0102, "Scientific", 20);
INSERT INTO Categories VALUES (0202, "Safety", 20);
INSERT INTO Categories VALUES (0302, "Food Service", 20);
INSERT INTO Categories VALUES (0402, "Material Handling", 20);

/* Clothing */
INSERT INTO Categories VALUES (0103, "Women", 30);
INSERT INTO Categories VALUES (0203, "Men", 30);
INSERT INTO Categories VALUES (0403, "Girls", 30);
INSERT INTO Categories VALUES (0503, "Boys", 30);

/* Entertainment */
INSERT INTO Categories VALUES (0104, "Movies", 40);
INSERT INTO Categories VALUES (0204, "TV Shows", 40);
INSERT INTO Categories VALUES (0304, "Music", 40);
INSERT INTO Categories VALUES (0404, "Audiobooks", 40);
INSERT INTO Categories VALUES (0504, "Games", 40);

/* Electronics */
INSERT INTO Categories VALUES (0105, "Home Theater", 50);
INSERT INTO Categories VALUES (0205, "Photo & Video", 50);
INSERT INTO Categories VALUES (0305, "Cell Phones", 50);
INSERT INTO Categories VALUES (0405, "Headphones", 50);
INSERT INTO Categories VALUES (0505, "Wearables", 50);
INSERT INTO Categories VALUES (0605, "Computers", 50);
INSERT INTO Categories VALUES (0705, "Accessories", 50);
INSERT INTO Categories VALUES (0805, "Software", 50);

/* Home */
INSERT INTO Categories VALUES (0106, "Kitchen & Dining", 60);
INSERT INTO Categories VALUES (0206, "Furniture", 60);
INSERT INTO Categories VALUES (0306, "Bedding & Bath", 60);
INSERT INTO Categories VALUES (0406, "Appliances", 60);
INSERT INTO Categories VALUES (0506, "Lawn & Garden", 60);
INSERT INTO Categories VALUES (0706, "Arts & Crafts", 60);
INSERT INTO Categories VALUES (0806, "Pets", 60);
INSERT INTO Categories VALUES (0906, "Home Improvement", 60);

/* Sports & Outdoors */
INSERT INTO Categories VALUES (0107, "Athletic Clothing", 70);
INSERT INTO Categories VALUES (0207, "Exercise & Fitness", 70);
INSERT INTO Categories VALUES (0307, "Hunting & Fishing", 70);
INSERT INTO Categories VALUES (0407, "Fan Shop", 70);
INSERT INTO Categories VALUES (0507, "Outdoor Sports", 70);
INSERT INTO Categories VALUES (0607, "Outdoor Clothing", 70);
INSERT INTO Categories VALUES (0707, "Water Sports", 70);
INSERT INTO Categories VALUES (0807, "Winter Sports", 70);

/* Health & Cosmetics */
INSERT INTO Categories VALUES (0108, "Luxury Beauty", 08);
INSERT INTO Categories VALUES (0208, "Professional Skin Care", 08);
INSERT INTO Categories VALUES (0308, "Salon & Spa", 08);
INSERT INTO Categories VALUES (0408, "Men's Grooming", 08);
INSERT INTO Categories VALUES (0508, "Vitamins", 08);
