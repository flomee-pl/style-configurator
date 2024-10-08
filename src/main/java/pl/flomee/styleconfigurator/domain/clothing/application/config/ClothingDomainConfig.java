package pl.flomee.styleconfigurator.domain.clothing.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.domain.clothing.core.ClothingAttributesFacade;
import pl.flomee.styleconfigurator.domain.clothing.core.ClothingFacade;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ClothingPartRepository;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ClothingRepository;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ColorRepository;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ShopRepository;

@Configuration
public class ClothingDomainConfig {
    @Bean
    public ClothingFacade clothingFacade(ClothingRepository clothingRepository) {
        return new ClothingFacade(clothingRepository);
    }

    @Bean
    public ClothingAttributesFacade clothingAttributesFacade(
        ClothingPartRepository clothingPartRepository,
        ColorRepository colorRepository,
        ShopRepository shopRepository
    ) {
        return new ClothingAttributesFacade(
            clothingPartRepository,
            colorRepository,
            shopRepository
        );
    }

}
