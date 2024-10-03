package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes;

import jakarta.persistence.*;

@Entity
@Table(name = "style")
public class StyleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long styleId;

    @Column(nullable = false, unique = true)
    public String name;

    @Column(nullable = false, unique = true)
    public String polishName;
}
