package pl.flomee.styleconfigurator.domain.clothing.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ColorRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.ColorJpaRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.ColorJpaRepositoryAdapter;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper.ClothingAttributesMapper;

@Configuration
public class ColorRepositoryConfig {

    @Bean
    public ColorRepository colorRepository(
        ColorJpaRepository colorJpaRepository,
        ClothingAttributesMapper clothingAttributesMapper
    ) {
        return new ColorJpaRepositoryAdapter(
            colorJpaRepository,
            clothingAttributesMapper
        );
    }
}
