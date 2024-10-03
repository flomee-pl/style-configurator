package pl.flomee.styleconfigurator.domain.outfit.infrastructure.config;

import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.ClothingJpaRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper.ClothingMapper;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.OutfitRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper.OutfitAttributesMapper;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper.OutfitMapper;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.*;

@Configuration
public class OutfitRepositoryConfig {

    @Bean
    public OutfitRepository outfitRepository(OutfitMapper outfitMapper,
                                             OutfitJpaRepository outfitJpaRepository,
                                             SeasonJpaRepository seasonJpaRepository,
                                             SexJpaRepository sexJpaRepository,
                                             StyleJpaRepository styleJpaRepository,
                                             ClothingJpaRepository clothingJpaRepository,
                                             ClothingMapper clothingMapper
    ) {
        return new OutfitJpaRepositoryAdapter(outfitMapper,
            outfitJpaRepository,
            seasonJpaRepository,
            sexJpaRepository,
            styleJpaRepository,
            clothingJpaRepository,
            clothingMapper
            );
    }
}
