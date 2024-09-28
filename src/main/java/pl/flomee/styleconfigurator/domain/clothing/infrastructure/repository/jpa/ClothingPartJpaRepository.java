package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ClothingPartEntity;

import java.util.Optional;

public interface ClothingPartJpaRepository extends JpaRepository<ClothingPartEntity, Long> {
    Optional<ClothingPartEntity> findByName(String name);
}
