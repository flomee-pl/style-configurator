package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes;

import jakarta.persistence.*;

@Entity
@Table(name = "season")
public class SeasonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long seasonId;

    @Column(nullable = false, unique = true)
    public String name;

}
