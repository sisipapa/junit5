DROP TABLE IF EXISTS product;

CREATE TABLE product
(
    idx     IDENTITY        PRIMARY KEY,
    name   VARCHAR(255)    NOT NULL,
    description   VARCHAR(255)    NOT NULL
);