package pl.flomee.styleconfigurator.outfit.core.model;

import pl.flomee.styleconfigurator.clothing.core.model.Clothing;

import java.util.List;
import java.util.UUID;

public class Outfit {
    public UUID id;
    public String outfitName;
    public String description;
    public String outfitImageUrl;
    public List<Clothing> clothes;
}
