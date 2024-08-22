package pl.flomee.styleconfigurator.outfit.core.model;

import lombok.Data;
import pl.flomee.styleconfigurator.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Style;

import java.util.List;
import java.util.UUID;

@Data
public class Outfit {
    public UUID id;
    public String outfitName;
    public String description;
    public String outfitImageUrl;
    public Sex sex;
    public List<Style> style;
    public List<Season> season;
    public Boolean isActive;
    public List<Clothing> clothes;
}
