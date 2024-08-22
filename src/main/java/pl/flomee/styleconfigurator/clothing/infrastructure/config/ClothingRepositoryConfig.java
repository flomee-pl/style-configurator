package pl.flomee.styleconfigurator.clothing.infrastructure.config;

import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.clothing.core.ports.outgoing.ClothingRepository;
import pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.ClothingJpaRepository;
import pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.ClothingJpaRepositoryAdapter;
import pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.mapper.ClothingMapper;

@Configuration
public class ClothingRepositoryConfig {

    @Bean
    public ClothingRepository clothingRepository(ClothingMapper clothingMapper,
                                                 ClothingJpaRepository clothingJpaRepository,
                                                 EntityManager entityManager){
        return new ClothingJpaRepositoryAdapter(clothingMapper, clothingJpaRepository,entityManager);
    }


}
