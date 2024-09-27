package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ClothingPartEntity;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ColorEntity;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ShopEntity;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.OutfitEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clothing")
public class ClothingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToOne
    @JoinColumn(name = "clothing_part_id", nullable = false)
    public ClothingPartEntity clothingPart;

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    public ShopEntity shop;

    @ManyToMany
    @JoinTable(
        name = "clothing_color",
        joinColumns = @JoinColumn(name = "clothing_id"),
        inverseJoinColumns = @JoinColumn(name = "color_id")
    )
    public List<ColorEntity> color;

    @ManyToMany(mappedBy = "clothes")

    public List<OutfitEntity> outfits;
}
