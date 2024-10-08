package pl.flomee.styleconfigurator.domain.outfit.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.SeasonRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper.OutfitAttributesMapper;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.SeasonJpaRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.SeasonJpaRepositoryAdapter;

@Configuration
public class SeasonRepositoryConfig {
    @Bean
    public SeasonRepository seasonRepository(
        SeasonJpaRepository seasonJpaRepository,
        OutfitAttributesMapper outfitAttributesMapper
    ) {
        return new SeasonJpaRepositoryAdapter(
            seasonJpaRepository,
            outfitAttributesMapper
        );
    }

}
