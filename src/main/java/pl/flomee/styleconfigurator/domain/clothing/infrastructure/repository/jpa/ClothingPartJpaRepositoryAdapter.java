package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ClothingPartRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ClothingPartEntity;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper.ClothingAttributesMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ClothingPartJpaRepositoryAdapter implements ClothingPartRepository {
    private final ClothingPartJpaRepository clothingPartJpaRepository;
    private final ClothingAttributesMapper clothingAttributesMapper;

    @Override
    public Optional<ClothingPartEntity> findByName(String name) {
        return clothingPartJpaRepository.findByName(name);
    }

    @Override
    public List<ClothingPart> findAll() {
        return clothingPartJpaRepository.findAll().stream().map(clothingAttributesMapper::toDomain).toList();
    }

    @Override
    public ClothingPart save(ClothingPart clothingPart) {
        return clothingAttributesMapper.toDomain(
            clothingPartJpaRepository.save(clothingAttributesMapper.toEntity(clothingPart)));
    }

    @Override
    public void deleteById(Long id) {
        clothingPartJpaRepository.deleteById(id);
    }
}
