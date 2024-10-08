package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes;

import jakarta.persistence.*;

@Entity
@Table(name = "sex")
public class SexEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long sexId;
    @Column(nullable = false, unique = true)
    public String name;

    @Column(nullable = false, unique = true)
    public String polishName;
}
