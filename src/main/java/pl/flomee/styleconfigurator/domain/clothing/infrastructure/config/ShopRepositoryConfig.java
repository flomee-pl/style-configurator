package pl.flomee.styleconfigurator.domain.clothing.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ShopRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.ShopJpaRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.ShopJpaRepositoryAdapter;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper.ClothingAttributesMapper;

@Configuration
public class ShopRepositoryConfig {

    @Bean
    public ShopRepository shopRepository(
        ShopJpaRepository shopJpaRepository,
        ClothingAttributesMapper clothingAttributesMapper
    ) {
        return new ShopJpaRepositoryAdapter(
            shopJpaRepository,
            clothingAttributesMapper);
    }
}
