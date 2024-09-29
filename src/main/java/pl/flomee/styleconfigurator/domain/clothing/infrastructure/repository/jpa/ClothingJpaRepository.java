package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.ClothingEntity;

import java.util.List;
import java.util.UUID;

public interface ClothingJpaRepository extends JpaRepository<ClothingEntity, UUID> {

    @Query("SELECT c FROM ClothingEntity c " +
        "LEFT JOIN c.clothingPart cp " +
        "LEFT JOIN c.shop s " +
        "LEFT JOIN c.color cl " +
        "WHERE (:clothingPart IS NULL OR (cp.name IN :clothingPart)) " +
        "AND (:shop IS NULL OR (s.name IN :shop)) " +
        "AND (:nonActive IS NULL OR (cl.name IN :nonActive))")
    List<ClothingEntity> findByFilters(
        @Param("clothingPart") List<String> clothingPart,
        @Param("shop") List<String> shop,
        @Param("nonActive") List<String> colors);
}
