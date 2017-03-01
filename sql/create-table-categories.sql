USE fusion;

/* ------------------- Create Table ------------------- */

CREATE TABLE Categories (
    id integer NOT NULL,
    name varchar(50) NOT NULL,
    parentID integer,
    PRIMARY KEY (id)
);

/* ------------------ Populate Table ------------------ */

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

/* Parts & Accessories */
INSERT INTO Categories VALUES (010101, "Performance Parts",     0101);
INSERT INTO Categories VALUES (020101, "Replacement Parts",     0101);
INSERT INTO Categories VALUES (030101, "Truck Accessories",     0101);
INSERT INTO Categories VALUES (040101, "Interior",              0101);
INSERT INTO Categories VALUES (050101, "Exterior",              0101);
INSERT INTO Categories VALUES (060101, "Tires & Wheels",        0101);

/* Tools & Equiptment */
INSERT INTO Categories VALUES (010201, "Tool Boxes & Sets", 0201);
INSERT INTO Categories VALUES (020201, "Measuring Tools", 0201);
INSERT INTO Categories VALUES (030201, "Compressors", 0201);
INSERT INTO Categories VALUES (040201, "Hand Tools", 0201);

/* Vehicle Electronics */
INSERT INTO Categories VALUES (010301, "GPS", 0301);
INSERT INTO Categories VALUES (020301, "Car Electronics", 0301);
INSERT INTO Categories VALUES (030301, "Avaion Electronics", 0301);

/* Tires & Wheels */
INSERT INTO Categories VALUES (010401, "Rims", 0401);
INSERT INTO Categories VALUES (020401, "Accessories", 0401);
INSERT INTO Categories VALUES (030401, "Tires", 0401);
INSERT INTO Categories VALUES (040401, "Repair", 0401);

/* Vehicles */
INSERT INTO Categories VALUES (010501, "Cars", 0501);
INSERT INTO Categories VALUES (010501, "Trucks", 0501);
INSERT INTO Categories VALUES (010501, "SUVs", 0501);
INSERT INTO Categories VALUES (010501, "Vans", 0501);

/*-------------------------------------------------------------------*/

/* Industrial */
INSERT INTO Categories VALUES (0102, "Scientific",          02);
INSERT INTO Categories VALUES (0202, "Safety",              02);
INSERT INTO Categories VALUES (0302, "Food Service",        02);
INSERT INTO Categories VALUES (0402, "Material Handling",   02);

/*-------------------------------------------------------------------*/

/* Clothing */
INSERT INTO Categories VALUES (0103, "Women",   03);
INSERT INTO Categories VALUES (0203, "Men",     03);
INSERT INTO Categories VALUES (0403, "Girls",   03);
INSERT INTO Categories VALUES (0503, "Boys",    03);

/*-------------------------------------------------------------------*/

/* Entertainment */
INSERT INTO Categories VALUES (0104, "Movies & TV",     04);
INSERT INTO Categories VALUES (0204, "Music",           04);
INSERT INTO Categories VALUES (0304, "Games",           04);

/*-------------------------------------------------------------------*/

/* Electronics */
INSERT INTO Categories VALUES (0105, "Home Theater",    05);
INSERT INTO Categories VALUES (0205, "Photo & Video",   05);
INSERT INTO Categories VALUES (0305, "Cell Phones",     05);
INSERT INTO Categories VALUES (0405, "Computers",       05);
INSERT INTO Categories VALUES (0505, "Accessories",     05);

/*-------------------------------------------------------------------*/

/* Home */
INSERT INTO Categories VALUES (0106, "Kitchen & Dining",        06);
INSERT INTO Categories VALUES (0206, "Furniture & Appliances",  06);
INSERT INTO Categories VALUES (0306, "Bedding & Bath",          06);
INSERT INTO Categories VALUES (0406, "Lawn & Garden",           06);
INSERT INTO Categories VALUES (0506, "Arts & Crafts",           06);
INSERT INTO Categories VALUES (0606, "Pets",                    06);

/*-------------------------------------------------------------------*/

/* Sports & Outdoors */
INSERT INTO Categories VALUES (0107, "Exercise & Fitness",  07);
INSERT INTO Categories VALUES (0207, "Fan Shop",            07);
INSERT INTO Categories VALUES (0307, "Outdoor Sports",      07);
INSERT INTO Categories VALUES (0407, "Outdoor Clothing",    07);
INSERT INTO Categories VALUES (0507, "Water Sports",        07);
INSERT INTO Categories VALUES (0607, "Winter Sports",       07);

/*-------------------------------------------------------------------*/

/* Health & Cosmetics */
INSERT INTO Categories VALUES (0108, "Luxury Beauty",           08);
INSERT INTO Categories VALUES (0208, "Professional Skin Care",  08);
INSERT INTO Categories VALUES (0308, "Salon & Spa",             08);
INSERT INTO Categories VALUES (0408, "Men's Grooming",          08);
INSERT INTO Categories VALUES (0508, "Vitamins",                08);
