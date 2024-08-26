package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.OutfitEntity;

import java.util.UUID;

public interface OutfitJpaRepository extends JpaRepository<OutfitEntity, UUID> {
}
