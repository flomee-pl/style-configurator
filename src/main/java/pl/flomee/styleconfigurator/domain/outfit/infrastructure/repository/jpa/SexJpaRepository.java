package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SexEntity;

import java.util.Optional;

public interface SexJpaRepository extends JpaRepository<SexEntity, Long> {
    Optional<SexEntity> findByName(String name);
}
