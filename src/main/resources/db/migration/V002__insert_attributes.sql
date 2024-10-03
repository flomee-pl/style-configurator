-- Wstawianie danych do tabeli clothing_part
INSERT INTO clothing_part (name, polish_name)
VALUES ('SHIRT', 'KOSZULA'),
       ('PANTS', 'SPODNIE'),
       ('SHOES', 'BUTY'),
       ('JACKET', 'KURTKA'),
       ('DRESS', 'SUKIENKA'),
       ('HAT', 'KAPELUSZ'),
       ('BRACELET', 'BRANSOLETKA'),
       ('NECKLACE', 'NASZYJNIK'),
       ('RING', 'PIERŚCIONEK');

-- Wstawianie danych do tabeli color
INSERT INTO color (name, polish_name)
VALUES ('BLACK', 'CZARNY'),
       ('WHITE', 'BIAŁY'),
       ('GREY', 'SZARY'),
       ('BLUE', 'NIEBIESKI'),
       ('RED', 'CZERWONY'),
       ('GREEN', 'ZIELONY');

-- Wstawianie danych do tabeli shop
INSERT INTO shop (name, polish_name)
VALUES ('ANSWEAR', 'ANSWEAR');

-- Wstawianie danych do tabeli season
INSERT INTO season (name, polish_name)
VALUES ('WINTER', 'ZIMA'),
       ('SPRING', 'WIOSNA'),
       ('SUMMER', 'LATO'),
       ('AUTUMN', 'JESIEŃ');

-- Wstawianie danych do tabeli sex
INSERT INTO sex (name, polish_name)
VALUES ('MALE', 'MĘŻCZYZNA'),
       ('FEMALE', 'KOBIETA'),
       ('UNISEX', 'UNISEX');

-- Wstawianie danych do tabeli style
INSERT INTO style (name, polish_name)
VALUES ('CASUAL', 'CODZIENNY'),
       ('SPORT', 'SPORTOWY'),
       ('ELEGANT', 'ELEGANCKI'),
       ('STREETWEAR', 'ULICZNY'),
       ('SMART', 'SMART'),
       ('FORMAL', 'FORMALNY');