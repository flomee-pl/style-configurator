package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ColorEntity;

import java.util.Optional;

public interface ColorJpaRepository extends JpaRepository<ColorEntity, Long> {
    Optional<ColorEntity> findByName(String name);
}
