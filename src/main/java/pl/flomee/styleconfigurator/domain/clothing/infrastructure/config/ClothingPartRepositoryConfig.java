package pl.flomee.styleconfigurator.domain.clothing.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ClothingPartRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.ClothingPartJpaRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.ClothingPartJpaRepositoryAdapter;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper.ClothingAttributesMapper;

@Configuration
public class ClothingPartRepositoryConfig {

    @Bean
    public ClothingPartRepository clothingPartRepository(
        ClothingPartJpaRepository clothingPartJpaRepository,
        ClothingAttributesMapper clothingAttributesMapper
    ) {
        return new ClothingPartJpaRepositoryAdapter(
            clothingPartJpaRepository,
            clothingAttributesMapper);
    }
}
