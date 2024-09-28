package pl.flomee.styleconfigurator.domain.outfit.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.domain.outfit.core.OutfitAttributesFacade;
import pl.flomee.styleconfigurator.domain.outfit.core.OutfitFacade;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.OutfitRepository;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.SeasonRepository;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.SexRepository;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.StyleRepository;

@Configuration
public class OutfitDomainConfig {

    @Bean
    public OutfitFacade outfitFacade(OutfitRepository outfitRepository) {
        return new OutfitFacade(outfitRepository);
    }

    @Bean
    public OutfitAttributesFacade outfitAttributesFacade(
        SeasonRepository seasonRepository,
        SexRepository sexRepository,
        StyleRepository styleRepository
    ) {
        return new OutfitAttributesFacade(
            seasonRepository,
            sexRepository,
            styleRepository
        );
    }
}
