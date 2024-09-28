package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa;


import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ShopRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ShopEntity;

import java.util.Optional;

@RequiredArgsConstructor
public class ShopJpaRepositoryAdapter implements ShopRepository {
    private final ShopJpaRepository shopJpaRepository;
    @Override
    public Optional<ShopEntity> findByName(String name) {
        return shopJpaRepository.findByName(name);
    }
}
