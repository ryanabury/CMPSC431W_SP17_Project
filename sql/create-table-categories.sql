USE fusion;

CREATE TABLE Categories (
    id integer NOT NULL,
    name varchar(50) NOT NULL,
    parentID integer,
    PRIMARY KEY (id)
);
