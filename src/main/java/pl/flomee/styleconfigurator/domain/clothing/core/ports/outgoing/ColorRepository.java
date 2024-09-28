package pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing;

import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ColorEntity;

import java.util.Optional;

public interface ColorRepository {
    Optional<ColorEntity> findByName(String name);
}
