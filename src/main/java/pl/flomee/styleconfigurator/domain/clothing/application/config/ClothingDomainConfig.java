package pl.flomee.styleconfigurator.domain.clothing.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.domain.clothing.core.ClothingFacade;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ClothingRepository;

@Configuration
public class ClothingDomainConfig {
    @Bean
    public ClothingFacade clothingFacade(ClothingRepository clothingRepository) {
        return new ClothingFacade(clothingRepository);
    }


}
