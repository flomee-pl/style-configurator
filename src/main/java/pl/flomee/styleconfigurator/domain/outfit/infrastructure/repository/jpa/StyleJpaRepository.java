package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.StyleEntity;

import java.util.Optional;

public interface StyleJpaRepository extends JpaRepository<StyleEntity, Long> {
    Optional<StyleEntity> findByName(String name);
}
