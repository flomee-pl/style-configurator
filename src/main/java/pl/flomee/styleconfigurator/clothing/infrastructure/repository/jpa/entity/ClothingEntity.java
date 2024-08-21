package pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import pl.flomee.styleconfigurator.clothing.core.model.categories.*;
import pl.flomee.styleconfigurator.clothing.core.model.ClothingPart;
import pl.flomee.styleconfigurator.outfit.infrastructure.repository.jpa.entity.OutfitEntity;

import java.util.List;
import java.util.UUID;

@Getter
@Setter

@Entity
@Table(name = "clothing")
public class ClothingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID clothingId;
    public String clothingName;
    public String clothingImageUrl;
    public Long price;
    public String link;
    public String affiliateLink;

    @Enumerated(EnumType.STRING)
    public ClothingPart clothingPart;

    @Enumerated(EnumType.STRING)
    public Shop shop;

    @Enumerated(EnumType.STRING)
    public Sex sex;

    @ElementCollection(targetClass = Color.class)
    @Enumerated(EnumType.STRING)
    public List<Color> colors;

    @Enumerated(EnumType.STRING)
    public List<Style> style;

    @Enumerated(EnumType.STRING)
    public List<Season> season;

    @ManyToMany(mappedBy = "clothes")
    public List<OutfitEntity> outfits;
}
