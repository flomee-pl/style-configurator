package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ShopEntity;

import java.util.Optional;

public interface ShopJpaRepository extends JpaRepository<ShopEntity, Long> {
    Optional<ShopEntity> findByName(String name);
}
