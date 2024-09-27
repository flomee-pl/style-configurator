package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.ClothingEntity;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SeasonEntity;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SexEntity;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.StyleEntity;

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

    @ManyToOne
    @JoinColumn(name = "sex_id", nullable = false)
    public SexEntity sex;

    @ManyToMany
    @JoinTable(
        name = "outfit_style",
        joinColumns = @JoinColumn(name = "outfit_id"),
        inverseJoinColumns = @JoinColumn(name = "style_id")
    )
    public List<StyleEntity> style;

    @ManyToMany
    @JoinTable(
        name = "outfit_season",
        joinColumns = @JoinColumn(name = "outfit_id"),
        inverseJoinColumns = @JoinColumn(name = "season_id")
    )
    public List<SeasonEntity> season;

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
