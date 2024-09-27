package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "clothing_part")
public class ClothingPartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long clothingPartId;

    @Column(nullable = false, unique = true)
    public String name;
}
