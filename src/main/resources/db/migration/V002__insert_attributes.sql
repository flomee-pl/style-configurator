-- Wstawianie danych do tabeli clothing_part
INSERT INTO clothing_part (name)
VALUES ('SHIRT'),
       ('PANTS'),
       ('SHOES'),
       ('JACKET'),
       ('DRESS'),
       ('HAT'),
       ('BRACELET'),
       ('NECKLACE'),
       ('RING');

-- Wstawianie danych do tabeli color
INSERT INTO color (name)
VALUES ('BLACK'),
       ('WHITE'),
       ('GREY'),
       ('BLUE'),
       ('RED'),
       ('GREEN');

INSERT INTO shop (name)
VALUES ('ANSWEAR');

-- Wstawianie danych do tabeli season
INSERT INTO season (name)
VALUES ('WINTER'), ('SPRING'), ('SUMMER'), ('AUTUMN');

-- Wstawianie danych do tabeli sex
INSERT INTO sex (name)
VALUES ('MALE'), ('FEMALE'), ('UNISEX');


-- Wstawianie danych do tabeli style
INSERT INTO style (name)
VALUES ('CASUAL'), ('SPORT'), ('ELEGANT'), ('STREETWEAR'), ('SMART'), ('FORMAL');
