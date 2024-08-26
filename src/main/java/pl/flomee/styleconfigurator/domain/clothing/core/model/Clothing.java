package pl.flomee.styleconfigurator.domain.clothing.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.OutfitEntity;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Clothing {
    public UUID clothingId;

    @NotNull
    @NotBlank
    public String clothingName;

    @NotNull
    @NotBlank
    public String clothingImageUrl;

    @NotNull
    public BigDecimal price;

    @NotNull
    @NotBlank
    public String link;

    @NotNull
    @NotBlank
    public String affiliateLink;

    @NotNull
    public ClothingPart clothingPart;

    @NotNull
    public Shop shop;

    @NotNull
    public List<Color> color;

    @JsonIgnoreProperties("clothes")
    public List<OutfitEntity> outfits;
}
