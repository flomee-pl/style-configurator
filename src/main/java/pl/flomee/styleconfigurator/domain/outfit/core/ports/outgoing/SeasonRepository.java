package pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing;

import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SeasonEntity;

import java.util.Optional;

public interface SeasonRepository {
    Optional<SeasonEntity> findSeasonByName(String name);
}
