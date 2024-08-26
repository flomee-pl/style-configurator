package pl.flomee.styleconfigurator.domain.outfit.infrastructure.config;

import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.domain.clothing.core.ClothingFacade;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper.ClothingMapper;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.OutfitRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.OutfitJpaRepositoryAdapter;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper.OutfitMapper;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.OutfitJpaRepository;

@Configuration
public class OutfitRepositoryConfig {

    @Bean
    public OutfitRepository outfitRepository(OutfitMapper outfitMapper,
                                             OutfitJpaRepository outfitJpaRepository,
                                             ClothingFacade clothingService,
                                             EntityManager entityManager,
                                             ClothingMapper clothingMapper) {
        return new OutfitJpaRepositoryAdapter(outfitMapper, outfitJpaRepository, clothingService, clothingMapper, entityManager);
    }
}
