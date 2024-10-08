package pl.flomee.styleconfigurator.domain.outfit.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.StyleRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper.OutfitAttributesMapper;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.StyleJpaRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.StyleJpaRepositoryAdapter;

@Configuration
public class StyleRepositoryConfig {

    @Bean
    public StyleRepository styleRepository(
        StyleJpaRepository styleJpaRepository,
        OutfitAttributesMapper outfitAttributesMapper
    ) {
        return new StyleJpaRepositoryAdapter(
            styleJpaRepository,
            outfitAttributesMapper
        );
    }
}
