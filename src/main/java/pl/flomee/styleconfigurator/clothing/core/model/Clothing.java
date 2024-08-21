package pl.flomee.styleconfigurator.clothing.core.model;

import lombok.Getter;
import lombok.Setter;
import pl.flomee.styleconfigurator.clothing.core.model.categories.*;
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
    public Sex sex;
    public List<Color> colors;
    public List<Style> style;
    public List<Season> season;
    public List<OutfitEntity> outfits;
}
