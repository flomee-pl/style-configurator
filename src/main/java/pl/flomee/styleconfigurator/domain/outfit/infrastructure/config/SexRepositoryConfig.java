package pl.flomee.styleconfigurator.domain.outfit.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.SexRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper.OutfitAttributesMapper;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.SexJpaRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.SexJpaRepositoryAdapter;

@Configuration
public class SexRepositoryConfig {
    @Bean
    public SexRepository sexRepository(
        SexJpaRepository sexJpaRepository,
        OutfitAttributesMapper outfitAttributesMapper
    ) {
        return new SexJpaRepositoryAdapter(sexJpaRepository, outfitAttributesMapper);
    }

}
