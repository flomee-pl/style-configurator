package pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing;

import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SexEntity;

import java.util.Optional;

public interface SexRepository {
    Optional<SexEntity> findSexByName(String name);
}
