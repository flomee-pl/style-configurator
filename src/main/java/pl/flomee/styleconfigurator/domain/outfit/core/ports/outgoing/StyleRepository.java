package pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing;

import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.StyleEntity;

import java.util.Optional;

public interface StyleRepository {
    Optional<StyleEntity> findStyleByName(String name);
}
