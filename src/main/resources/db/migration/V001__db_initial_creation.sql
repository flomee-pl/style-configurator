-- Tworzenie tabeli dla ClothingPart
CREATE TABLE clothing_part
(
    clothing_part_id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE shop
(
    shop_id   SERIAL PRIMARY KEY,
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
            REFERENCES clothing_part (clothing_part_id),
    CONSTRAINT FK_shop
        FOREIGN KEY (shop_id)
            REFERENCES shop (shop_id)
);

-- Tworzenie tabeli dla Color
CREATE TABLE color
(
    color_id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);


-- Modyfikacja tabeli clothing_entity_color, zastąpienie color VARCHAR relacją
CREATE TABLE clothing_color
(
    clothing_id UUID NOT NULL,
    color_id             INT  NOT NULL,

    CONSTRAINT FK_clothing_color_clothing_id
        FOREIGN KEY (clothing_id)
            REFERENCES clothing (clothing_id),

    CONSTRAINT FK_color
        FOREIGN KEY (color_id)
            REFERENCES color (color_id)
);

-- Tworzenie tabeli dla Sex
CREATE TABLE sex
(
    sex_id   SERIAL PRIMARY KEY,
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
            REFERENCES sex (sex_id)
);

-- Tworzenie tabeli dla Season
CREATE TABLE season
(
    season_id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);


-- Modyfikacja tabeli outfit_entity_season, zastąpienie season VARCHAR relacją
CREATE TABLE outfit_season
(
    outfit_id UUID NOT NULL,
    season_id               INT  NOT NULL,

    CONSTRAINT FK_outfit_season_outfit_id
        FOREIGN KEY (outfit_id)
            REFERENCES outfits (outfit_id),

    CONSTRAINT FK_season
        FOREIGN KEY (season_id)
            REFERENCES season (season_id)
);

-- Tworzenie tabeli dla Style
CREATE TABLE style
(
    style_id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Modyfikacja tabeli outfit_entity_style, zastąpienie style VARCHAR relacją
CREATE TABLE outfit_style
(
    outfit_id UUID NOT NULL,
    style_id                INT  NOT NULL,

    CONSTRAINT FK_outfit_style_outfit_id
        FOREIGN KEY (outfit_id)
            REFERENCES outfits (outfit_id),

    CONSTRAINT FK_style
        FOREIGN KEY (style_id)
            REFERENCES style (style_id)
);

CREATE TABLE outfit_clothing
(
    clothing_id UUID NOT NULL,
    outfit_id   UUID NOT NULL,
    CONSTRAINT FK_outfit_clothing_clothing_id
        FOREIGN KEY (clothing_id)
            REFERENCES clothing (clothing_id),
    CONSTRAINT FK_outfit_clothing_outfit_id
        FOREIGN KEY (outfit_id)
            REFERENCES outfits (outfit_id)
);