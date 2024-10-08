package pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing;

import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SexEntity;

import java.util.List;
import java.util.Optional;

public interface SexRepository {
    Optional<SexEntity> findSexByName(String name);

    List<Sex> findAll();

    Sex save(Sex sex);

    void deleteById(Long id);
}
