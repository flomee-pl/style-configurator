package pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing;

import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ClothingPartEntity;

import java.util.Optional;

public interface ClothingPartRepository {
    Optional<ClothingPartEntity> findByName(String name);
}
