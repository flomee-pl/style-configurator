package pl.flomee.styleconfigurator.clothing.core.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import pl.flomee.styleconfigurator.clothing.core.model.categories.*;

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
    public ClothingPart clothingPart;
    public Shop shop;
    public Sex sex;
    public List<Color> colors;
    public Style style;
    public Season season;

}
