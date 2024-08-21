package pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.clothing.core.ports.outgoing.ClothingRepository;
import pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.entity.ClothingEntity;
import pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.mapper.ClothingMapper;

@RequiredArgsConstructor
public class ClothingJpaRepositoryAdapter implements ClothingRepository {

    private final ClothingMapper clothingMapper;
    private final ClothingJpaRepository clothingJpaRepository;
    @Override
    public void save(Clothing clothing) {
        ClothingEntity clothingEntity = clothingMapper.toEntity(clothing);
        clothingJpaRepository.save(clothingEntity);
    }
}
