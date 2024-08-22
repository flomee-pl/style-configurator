package pl.flomee.styleconfigurator.outfit.infrastructure.repository.jpa.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.entity.ClothingEntity;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Style;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "outfits")
public class OutfitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID outfitId;
    public String outfitName;
    public String description;
    public String outfitImageUrl;

    @Enumerated(EnumType.STRING)
    public Sex sex;

    @ElementCollection(targetClass = Style.class)
    @Enumerated(EnumType.STRING)
    public List<Style> style;

    @ElementCollection(targetClass = Season.class)
    @Enumerated(EnumType.STRING)
    public List<Season> season;

    public Boolean isActive;

    @ManyToMany
    @JoinTable(
        name = "outfit_clothing",
        joinColumns = @JoinColumn(name = "outfitId"),
        inverseJoinColumns = @JoinColumn(name = "clothingId")
    )
    public List<ClothingEntity> clothes;
}
