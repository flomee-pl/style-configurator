package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.SeasonRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SeasonEntity;

import java.util.Optional;

@RequiredArgsConstructor
public class SeasonJpaRepositoryAdapter implements SeasonRepository {
    private final SeasonJpaRepository seasonJpaRepository;
    @Override
    public Optional<SeasonEntity> findSeasonByName(String name) {
        return seasonJpaRepository.findByName(name);
    }
}
