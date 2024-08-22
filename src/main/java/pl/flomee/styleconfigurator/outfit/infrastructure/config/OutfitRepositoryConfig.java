package pl.flomee.styleconfigurator.outfit.infrastructure.config;

import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.outfit.core.ports.outgoing.OutfitRepository;
import pl.flomee.styleconfigurator.outfit.infrastructure.mapper.OutfitMapper;
import pl.flomee.styleconfigurator.outfit.infrastructure.repository.jpa.OutfitJpaRepository;
import pl.flomee.styleconfigurator.outfit.infrastructure.repository.jpa.OutfitJpaRepositoryAdapter;

@Configuration
public class OutfitRepositoryConfig {

    @Bean
    public OutfitRepository outfitRepository(OutfitMapper outfitMapper,
                                             OutfitJpaRepository outfitJpaRepository,
                                             EntityManager entityManager) {
        return new OutfitJpaRepositoryAdapter(outfitMapper, outfitJpaRepository,entityManager);
    }
}
