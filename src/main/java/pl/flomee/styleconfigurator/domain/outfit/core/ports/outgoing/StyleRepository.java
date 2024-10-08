package pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing;

import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Style;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.StyleEntity;

import java.util.List;
import java.util.Optional;

public interface StyleRepository {
    Optional<StyleEntity> findStyleByName(String name);

    List<Style> findAll();

    Style save(Style style);

    void deleteById(Long id);
}
