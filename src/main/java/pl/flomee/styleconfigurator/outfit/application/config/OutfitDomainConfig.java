package pl.flomee.styleconfigurator.outfit.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.outfit.core.OutfitFacade;
import pl.flomee.styleconfigurator.outfit.core.ports.outgoing.OutfitRepository;

@Configuration
public class OutfitDomainConfig {

    @Bean
    public OutfitFacade outfitFacade(OutfitRepository outfitRepository) {
        return new OutfitFacade(outfitRepository);
    }
}
