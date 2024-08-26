package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.ClothingEntity;

import java.util.UUID;

public interface ClothingJpaRepository extends JpaRepository<ClothingEntity, UUID> {
}
