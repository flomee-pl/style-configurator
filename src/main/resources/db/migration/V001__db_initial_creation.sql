-- Tworzenie tabeli dla ClothingPart
CREATE TABLE clothing_part
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE shop
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Modyfikacja tabeli clothing, zastąpienie clothing_part VARCHAR relacją
CREATE TABLE clothing
(
    clothing_id        UUID PRIMARY KEY,
    price              NUMERIC(38, 2) NOT NULL,
    affiliate_link     VARCHAR(255)   NOT NULL,
    clothing_image_url VARCHAR(255)   NOT NULL,
    clothing_name      VARCHAR(255)   NOT NULL,
    clothing_part_id   INT            NOT NULL,
    link               VARCHAR(255)   NOT NULL,
    shop_id            INT   NOT NULL,

    CONSTRAINT FK_clothing_part
        FOREIGN KEY (clothing_part_id)
            REFERENCES clothing_part (id),
    CONSTRAINT FK_shop
        FOREIGN KEY (shop_id)
            REFERENCES shop (id)
);

-- Tworzenie tabeli dla Color
CREATE TABLE color
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);


-- Modyfikacja tabeli clothing_entity_color, zastąpienie color VARCHAR relacją
CREATE TABLE clothing_color
(
    clothing_clothing_id UUID NOT NULL,
    color_id             INT  NOT NULL,

    CONSTRAINT FK_clothing_entity_color_clothing_id
        FOREIGN KEY (clothing_clothing_id)
            REFERENCES clothing (clothing_id),

    CONSTRAINT FK_color
        FOREIGN KEY (color_id)
            REFERENCES color (id)
);

-- Tworzenie tabeli dla Sex
CREATE TABLE sex
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);


-- Modyfikacja tabeli outfits, zastąpienie sex VARCHAR relacją
CREATE TABLE outfits
(
    outfit_id        UUID PRIMARY KEY,
    is_active        BOOLEAN      NOT NULL,
    created_at       TIMESTAMP    NOT NULL,
    description      VARCHAR(255) NOT NULL,
    outfit_image_url VARCHAR(255) NOT NULL,
    outfit_name      VARCHAR(255) NOT NULL,
    sex_id           INT          NOT NULL,

    CONSTRAINT FK_sex
        FOREIGN KEY (sex_id)
            REFERENCES sex (id)
);

-- Tworzenie tabeli dla Season
CREATE TABLE season
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);


-- Modyfikacja tabeli outfit_entity_season, zastąpienie season VARCHAR relacją
CREATE TABLE outfit_entity_season
(
    outfit_entity_outfit_id UUID NOT NULL,
    season_id               INT  NOT NULL,

    CONSTRAINT FK_outfit_entity_season_outfit_id
        FOREIGN KEY (outfit_entity_outfit_id)
            REFERENCES outfits (outfit_id),

    CONSTRAINT FK_season
        FOREIGN KEY (season_id)
            REFERENCES season (id)
);

-- Tworzenie tabeli dla Style
CREATE TABLE style
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Modyfikacja tabeli outfit_entity_style, zastąpienie style VARCHAR relacją
CREATE TABLE outfit_entity_style
(
    outfit_entity_outfit_id UUID NOT NULL,
    style_id                INT  NOT NULL,

    CONSTRAINT FK_outfit_entity_style_outfit_id
        FOREIGN KEY (outfit_entity_outfit_id)
            REFERENCES outfits (outfit_id),

    CONSTRAINT FK_style
        FOREIGN KEY (style_id)
            REFERENCES style (id)
);