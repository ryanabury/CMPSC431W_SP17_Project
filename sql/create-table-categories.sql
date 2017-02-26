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
INSERT INTO Categories VALUES (10000, "Automotive", -1);
INSERT INTO Categories VALUES (20000, "Industrial", -1);
INSERT INTO Categories VALUES (30000, "Clothing", -1);
INSERT INTO Categories VALUES (40000, "Entertainment", -1);
INSERT INTO Categories VALUES (50000, "Electronics", -1);
INSERT INTO Categories VALUES (60000, "Home", -1);
INSERT INTO Categories VALUES (70000, "Sports & Outdoors", -1);
INSERT INTO Categories VALUES (80000, "Health & Cosmetics", -1);
