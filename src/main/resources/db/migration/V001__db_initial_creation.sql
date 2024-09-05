-- Creating the 'clothing' table
CREATE TABLE clothing
(
    clothing_id        UUID PRIMARY KEY,
    price              NUMERIC(38, 2) NOT NULL,
    affiliate_link     VARCHAR(255)   NOT NULL,
    clothing_image_url VARCHAR(255)   NOT NULL,
    clothing_name      VARCHAR(255)   NOT NULL,
    clothing_part      VARCHAR(255)   NOT NULL CHECK (clothing_part IN
                                                      ('SHIRT', 'PANTS', 'SHOES', 'JACKET', 'DRESS', 'HAT', 'BRACELET',
                                                       'NECKLACE', 'RING')),
    link               VARCHAR(255)   NOT NULL,
    shop               VARCHAR(255)   NOT NULL CHECK (shop IN ('ANSWEAR'))
);

-- Creating the 'clothing_entity_color' table
CREATE TABLE clothing_entity_color
(
    clothing_entity_clothing_id UUID NOT NULL,
    color                       VARCHAR(255) CHECK (color IN ('BLACK', 'WHITE', 'GREY', 'BLUE', 'RED', 'GREEN')),
    CONSTRAINT FK_clothing_entity_color_clothing_id
        FOREIGN KEY (clothing_entity_clothing_id)
            REFERENCES clothing (clothing_id)
);
-- Creating the 'outfits' table
CREATE TABLE outfits
(
    outfit_id        UUID PRIMARY KEY,
    is_active        BOOLEAN      NOT NULL,
    created_at       TIMESTAMP    NOT NULL,
    description      VARCHAR(255) NOT NULL,
    outfit_image_url VARCHAR(255) NOT NULL,
    outfit_name      VARCHAR(255) NOT NULL,
    sex              VARCHAR(255) NOT NULL CHECK (sex IN ('MALE', 'FEMALE', 'UNISEX'))
);

-- Creating the 'outfit_clothing' table
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

-- Creating the 'outfit_entity_season' table
CREATE TABLE outfit_entity_season
(
    outfit_entity_outfit_id UUID NOT NULL,
    season                  VARCHAR(255) CHECK (season IN ('WINTER', 'SPRING', 'SUMMER', 'AUTUMN')),
    CONSTRAINT FK_outfit_entity_season_outfit_id
        FOREIGN KEY (outfit_entity_outfit_id)
            REFERENCES outfits (outfit_id)
);

-- Creating the 'outfit_entity_style' table
CREATE TABLE outfit_entity_style
(
    outfit_entity_outfit_id UUID NOT NULL,
    style                   VARCHAR(255) CHECK (style IN ('CASUAL', 'SPORT', 'ELEGANT', 'STREETWEAR', 'SMART', 'FORMAL')),
    CONSTRAINT FK_outfit_entity_style_outfit_id
        FOREIGN KEY (outfit_entity_outfit_id)
            REFERENCES outfits (outfit_id)
);

