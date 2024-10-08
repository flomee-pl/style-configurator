package pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing;

import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SeasonEntity;

import java.util.List;
import java.util.Optional;

public interface SeasonRepository {
    Optional<SeasonEntity> findSeasonByName(String name);

    List<Season> findAll();

    Season save(Season season);

    void deleteById(Long id);
}
