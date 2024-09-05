package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.ClothingEntity;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Style;

import java.time.LocalDateTime;
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

    @NotNull
    @NotBlank
    public String outfitName;

    @NotNull
    @NotBlank
    public String description;

    @NotNull
    @NotBlank
    public String outfitImageUrl;

    @Enumerated(EnumType.STRING)
    @NotNull
    public Sex sex;

    @ElementCollection(targetClass = Style.class)
    @Enumerated(EnumType.STRING)
    @NotNull
    public List<Style> style;

    @ElementCollection(targetClass = Season.class)
    @Enumerated(EnumType.STRING)
    @NotNull
    public List<Season> season;

    @NotNull
    public Boolean isActive;

    public LocalDateTime createdAt;
    @PrePersist
    protected void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    @ManyToMany()
    @JoinTable(
        name = "outfit_clothing",
        joinColumns = @JoinColumn(name = "outfitId"),
        inverseJoinColumns = @JoinColumn(name = "clothingId")
    )
    public List<ClothingEntity> clothes;
}
