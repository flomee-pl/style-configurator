package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.OutfitEntity;

import java.util.List;
import java.util.UUID;

public interface OutfitJpaRepository extends JpaRepository<OutfitEntity, UUID> {

    @Query("SELECT o FROM OutfitEntity o " +
        "LEFT JOIN o.sex s " +
        "LEFT JOIN o.style st " +
        "LEFT JOIN o.season se " +
        "LEFT JOIN o.clothes c " +
        "LEFT JOIN c.color col " +
        "WHERE (:sex IS NULL OR (s.name IN :sex)) " +
        "AND (:season IS NULL OR (se IS NOT NULL AND se.name IN :season)) " +
        "AND (:style IS NULL OR (st IS NOT NULL AND st.name IN :style)) " +
        "AND (:color IS NULL OR (col IS NOT NULL AND col.name IN :color)) " +
        "AND (:nonActive = true OR o.isActive = true)")
    List<OutfitEntity> findByFilters(
        @Param("sex") List<String> sex,
        @Param("season") List<String> season,
        @Param("style") List<String> style,
        @Param("color") List<String> color,
        @Param("nonActive") Boolean nonActive
    );
}
