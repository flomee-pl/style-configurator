package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.SexRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SexEntity;

import java.util.Optional;
@RequiredArgsConstructor
public class SexJpaRepositoryAdapter implements SexRepository {
    private final SexJpaRepository sexJpaRepository;
    @Override
    public Optional<SexEntity> findSexByName(String name) {
        return sexJpaRepository.findByName(name);
    }
}
