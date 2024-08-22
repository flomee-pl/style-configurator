package pl.flomee.styleconfigurator.clothing.core.model;

import lombok.Getter;
import lombok.Setter;
import pl.flomee.styleconfigurator.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.outfit.infrastructure.repository.jpa.entity.OutfitEntity;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Clothing {
    public UUID clothingId;
    public String clothingName;
    public String clothingImageUrl;
    public Long price;
    public String link;
    public String affiliateLink;
    public ClothingPart clothingPart;
    public Shop shop;
    public List<Color> color;
    public List<OutfitEntity> outfits;
}
