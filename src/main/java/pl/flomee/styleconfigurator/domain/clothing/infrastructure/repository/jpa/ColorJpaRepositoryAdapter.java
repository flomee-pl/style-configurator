package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ColorRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ColorEntity;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper.ClothingAttributesMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ColorJpaRepositoryAdapter implements ColorRepository {
    private final ColorJpaRepository colorJpaRepository;
    private final ClothingAttributesMapper clothingAttributesMapper;

    @Override
    public Optional<ColorEntity> findByName(String name) {
        return colorJpaRepository.findByName(name);
    }

    @Override
    public List<Color> findAll() {
        return colorJpaRepository.findAll().stream().map(clothingAttributesMapper::toDomain).toList();
    }

    @Override
    public Color save(Color color) {
        return clothingAttributesMapper.toDomain(colorJpaRepository.save(clothingAttributesMapper.toEntity(color)));
    }

    @Override
    public void deleteById(Long id) {
        colorJpaRepository.deleteById(id);
    }
}
