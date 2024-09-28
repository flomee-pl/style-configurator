package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ColorRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ColorEntity;

import java.util.Optional;

@RequiredArgsConstructor
public class ColorJpaRepositoryAdapter implements ColorRepository {
    private final ColorJpaRepository colorJpaRepository;
    @Override
    public Optional<ColorEntity> findByName(String name) {
        return colorJpaRepository.findByName(name);
    }
}
