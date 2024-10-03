package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes;


import jakarta.persistence.*;

@Entity
@Table(name = "shop")
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long shopId;

    @Column(nullable = false, unique = true)
    public String name;
    @Column(nullable = false, unique = true)
    public String polishName;
}
