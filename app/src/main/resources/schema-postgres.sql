DROP TABLE IF EXISTS TB_CLIENT;
CREATE TABLE TB_CLIENT
    (id serial PRIMARY KEY,
    firstname VARCHAR(255),
    surname VARCHAR(255),
    phone VARCHAR(255),
    age int,
    phoneType VARCHAR(255)
    );