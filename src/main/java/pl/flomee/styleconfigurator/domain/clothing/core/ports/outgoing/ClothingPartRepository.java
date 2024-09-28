package pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing;

import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ClothingPartEntity;

import java.util.List;
import java.util.Optional;

public interface ClothingPartRepository {
    Optional<ClothingPartEntity> findByName(String name);

    List<ClothingPart> findAll();

    ClothingPart save(ClothingPart clothingPart);

    void deleteById(Long id);
}
