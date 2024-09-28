package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Style;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.StyleRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper.OutfitAttributesMapper;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.StyleEntity;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class StyleJpaRepositoryAdapter implements StyleRepository {
    private final StyleJpaRepository styleJpaRepository;
    private final OutfitAttributesMapper outfitAttributesMapper;

    @Override
    public Optional<StyleEntity> findStyleByName(String name) {
        return styleJpaRepository.findByName(name);
    }

    @Override
    public List<Style> findAll() {
        return styleJpaRepository.findAll().stream().map(outfitAttributesMapper::toDomain).toList();
    }

    @Override
    public Style save(Style style) {
        return outfitAttributesMapper.toDomain(styleJpaRepository.save(outfitAttributesMapper.toEntity(style)));
    }

    @Override
    public void deleteById(Long id) {
        styleJpaRepository.deleteById(id);
    }
}
