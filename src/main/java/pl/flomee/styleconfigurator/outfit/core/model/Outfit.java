package pl.flomee.styleconfigurator.outfit.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import pl.flomee.styleconfigurator.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Style;

import java.util.List;
import java.util.UUID;

@Data
public class Outfit {
    public UUID outfitId;

    @NotNull
    @NotBlank
    public String outfitName;

    @NotNull
    @NotBlank
    public String description;

    @NotNull
    @NotBlank
    public String outfitImageUrl;

    @NotNull
    public Sex sex;

    @NotNull
    public List<Style> style;

    @NotNull
    public List<Season> season;

    @NotNull
    public Boolean isActive;
    @JsonIgnoreProperties("outfits")
    public List<Clothing> clothes;
}
