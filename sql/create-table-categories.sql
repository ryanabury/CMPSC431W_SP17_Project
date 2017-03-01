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
INSERT INTO Categories VALUES (01, "Automotive",            0);
INSERT INTO Categories VALUES (02, "Industrial",            0);
INSERT INTO Categories VALUES (03, "Clothing",              0);
INSERT INTO Categories VALUES (04, "Entertainment",         0);
INSERT INTO Categories VALUES (05, "Electronics",           0);
INSERT INTO Categories VALUES (06, "Home",                  0);
INSERT INTO Categories VALUES (07, "Sports & Outdoors",     0);
INSERT INTO Categories VALUES (08, "Health & Cosmetics",    0);

/* Automotive */
INSERT INTO Categories VALUES (0101, "Parts & Accessories",     01);
INSERT INTO Categories VALUES (0201, "Tools Equiptment",        01);
INSERT INTO Categories VALUES (0301, "Vehicle Electronics",     01);
INSERT INTO Categories VALUES (0401, "Tires & Wheels",          01);
INSERT INTO Categories VALUES (0501, "Vehicles",                01);

/* Industrial */
INSERT INTO Categories VALUES (0102, "Scientific",          02);
INSERT INTO Categories VALUES (0202, "Safety",              02);
INSERT INTO Categories VALUES (0302, "Food Service",        02);
INSERT INTO Categories VALUES (0402, "Material Handling",   02);

/* Clothing */
INSERT INTO Categories VALUES (0103, "Women",   03);
INSERT INTO Categories VALUES (0203, "Men",     03);
INSERT INTO Categories VALUES (0403, "Girls",   03);
INSERT INTO Categories VALUES (0503, "Boys",    03);

/* Entertainment */
INSERT INTO Categories VALUES (0104, "Movies",      04);
INSERT INTO Categories VALUES (0204, "TV Shows",    04);
INSERT INTO Categories VALUES (0304, "Music",       04);
INSERT INTO Categories VALUES (0404, "Audiobooks",  04);
INSERT INTO Categories VALUES (0504, "Games",       04);

/* Electronics */
INSERT INTO Categories VALUES (0105, "Home Theater",    05);
INSERT INTO Categories VALUES (0205, "Photo & Video",   05);
INSERT INTO Categories VALUES (0305, "Cell Phones",     05);
INSERT INTO Categories VALUES (0405, "Headphones",      05);
INSERT INTO Categories VALUES (0505, "Wearables",       05);
INSERT INTO Categories VALUES (0605, "Computers",       05);
INSERT INTO Categories VALUES (0705, "Accessories",     05);
INSERT INTO Categories VALUES (0805, "Software",        05);

/* Home */
INSERT INTO Categories VALUES (0106, "Kitchen & Dining",    06);
INSERT INTO Categories VALUES (0206, "Furniture",           06);
INSERT INTO Categories VALUES (0306, "Bedding & Bath",      06);
INSERT INTO Categories VALUES (0406, "Appliances",          06);
INSERT INTO Categories VALUES (0506, "Lawn & Garden",       06);
INSERT INTO Categories VALUES (0706, "Arts & Crafts",       06);
INSERT INTO Categories VALUES (0806, "Pets",                06);
INSERT INTO Categories VALUES (0906, "Home Improvement",    06);

/* Sports & Outdoors */
INSERT INTO Categories VALUES (0107, "Athletic Clothing",   07);
INSERT INTO Categories VALUES (0207, "Exercise & Fitness",  07);
INSERT INTO Categories VALUES (0307, "Hunting & Fishing",   07);
INSERT INTO Categories VALUES (0407, "Fan Shop",            07);
INSERT INTO Categories VALUES (0507, "Outdoor Sports",      07);
INSERT INTO Categories VALUES (0607, "Outdoor Clothing",    07);
INSERT INTO Categories VALUES (0707, "Water Sports",        07);
INSERT INTO Categories VALUES (0807, "Winter Sports",       07);

/* Health & Cosmetics */
INSERT INTO Categories VALUES (0108, "Luxury Beauty",           08);
INSERT INTO Categories VALUES (0208, "Professional Skin Care",  08);
INSERT INTO Categories VALUES (0308, "Salon & Spa",             08);
INSERT INTO Categories VALUES (0408, "Men's Grooming",          08);
INSERT INTO Categories VALUES (0508, "Vitamins",                08);
