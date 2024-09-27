package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes;

import jakarta.persistence.*;

@Entity
@Table(name = "color")
public class ColorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long colorId;

    @Column(nullable = false, unique = true)
    public String name;
}
