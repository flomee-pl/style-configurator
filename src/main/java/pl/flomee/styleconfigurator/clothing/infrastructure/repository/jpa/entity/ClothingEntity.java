package pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.validator.constraints.UniqueElements;
import pl.flomee.styleconfigurator.clothing.core.model.ClothingPart;
import pl.flomee.styleconfigurator.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.outfit.infrastructure.repository.jpa.entity.OutfitEntity;

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

    @Enumerated(EnumType.STRING)
    @NotNull
    public ClothingPart clothingPart;

    @Enumerated(EnumType.STRING)
    @NotNull
    public Shop shop;

    @ElementCollection(targetClass = Color.class)
    @Enumerated(EnumType.STRING)
    @NotNull
    public List<Color> color;

    @ManyToMany(mappedBy = "clothes")

    public List<OutfitEntity> outfits;
}
