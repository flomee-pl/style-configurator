package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SeasonEntity;

import java.util.Optional;

public interface SeasonJpaRepository extends JpaRepository<SeasonEntity, Long> {
    Optional<SeasonEntity> findByName(String name);
}
