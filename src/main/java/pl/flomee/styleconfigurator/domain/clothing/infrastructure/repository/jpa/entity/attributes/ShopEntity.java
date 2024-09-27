package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "shop")
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long shopId;

    @Column(nullable = false, unique = true)
    public String name;
}
