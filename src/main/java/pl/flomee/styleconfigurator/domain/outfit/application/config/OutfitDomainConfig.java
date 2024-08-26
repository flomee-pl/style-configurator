package pl.flomee.styleconfigurator.domain.outfit.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.OutfitRepository;
import pl.flomee.styleconfigurator.domain.outfit.core.OutfitFacade;

@Configuration
public class OutfitDomainConfig {

    @Bean
    public OutfitFacade outfitFacade(OutfitRepository outfitRepository) {
        return new OutfitFacade(outfitRepository);
    }
}
