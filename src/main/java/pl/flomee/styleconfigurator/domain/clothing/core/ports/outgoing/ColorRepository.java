package pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing;

import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ColorEntity;

import java.util.List;
import java.util.Optional;

public interface ColorRepository {
    Optional<ColorEntity> findByName(String name);

    List<Color> findAll();

    Color save(Color color);

    void deleteById(Long id);
}
