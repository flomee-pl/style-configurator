package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes;

import jakarta.persistence.*;

@Entity
@Table(name = "sex")
public class SexEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long sexId;
    @Column(nullable = false, unique = true)
    public String name;
}
