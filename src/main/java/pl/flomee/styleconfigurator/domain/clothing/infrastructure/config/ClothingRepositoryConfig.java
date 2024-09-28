package pl.flomee.styleconfigurator.domain.clothing.infrastructure.config;

import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ClothingRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.*;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper.ClothingAttributesMapper;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper.ClothingMapper;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper.OutfitMapper;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.OutfitJpaRepository;

@Configuration
public class ClothingRepositoryConfig {

    @Bean
    public ClothingRepository clothingRepository(ClothingMapper clothingMapper,
                                                 ClothingJpaRepository clothingJpaRepository,
                                                 ClothingPartJpaRepository clothingPartJpaRepository,
                                                 ColorJpaRepository colorJpaRepository,
                                                 ShopJpaRepository shopJpaRepository,
                                                 OutfitJpaRepository outfitJpaRepository,
                                                 OutfitMapper outfitMapper,
                                                 ClothingAttributesMapper clothingAttributesMapper,
                                                 EntityManager entityManager

    ) {
        return new ClothingJpaRepositoryAdapter(clothingMapper,
            clothingJpaRepository,
            clothingPartJpaRepository,
            colorJpaRepository,
            shopJpaRepository,
            outfitJpaRepository,
            outfitMapper,
            clothingAttributesMapper,
            entityManager);
    }


}
