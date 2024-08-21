package pl.flomee.styleconfigurator.outfit.infrastructure.repository.jpa.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.entity.ClothingEntity;

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

    @ManyToMany
    @JoinTable(
        name = "outfit_clothing",
        joinColumns = @JoinColumn(name = "outfitId"),
        inverseJoinColumns = @JoinColumn(name = "clothingId")
    )
    public List<ClothingEntity> clothes;
}
