package pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing;

import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ShopEntity;

import java.util.List;
import java.util.Optional;

public interface ShopRepository {
    Optional<ShopEntity> findByName(String name);

    List<Shop> findAll();

    Shop save(Shop shop);

    void deleteById(Long id);
}
