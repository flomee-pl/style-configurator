package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.StyleRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.StyleEntity;

import java.util.Optional;

@RequiredArgsConstructor
public class StyleJpaRepositoryAdapter implements StyleRepository {
    private final StyleJpaRepository styleJpaRepository;
    @Override
    public Optional<StyleEntity> findStyleByName(String name) {
        return styleJpaRepository.findByName(name);
    }
}
