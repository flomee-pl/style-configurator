package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ClothingPartRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ClothingPartEntity;

import java.util.Optional;

@RequiredArgsConstructor
public class ClothingPartJpaRepositoryAdapter implements ClothingPartRepository {
    private final ClothingPartJpaRepository clothingPartJpaRepository;

    @Override
    public Optional<ClothingPartEntity> findByName(String name) {
        return clothingPartJpaRepository.findByName(name);
    }
}
