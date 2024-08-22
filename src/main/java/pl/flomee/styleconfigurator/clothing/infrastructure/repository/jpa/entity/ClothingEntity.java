package pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.flomee.styleconfigurator.clothing.core.model.attributes.*;
import pl.flomee.styleconfigurator.clothing.core.model.ClothingPart;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Style;
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

    @ElementCollection(targetClass = Color.class)
    @Enumerated(EnumType.STRING)
    public List<Color> color;

    @ManyToMany(mappedBy = "clothes")
    public List<OutfitEntity> outfits;
}
