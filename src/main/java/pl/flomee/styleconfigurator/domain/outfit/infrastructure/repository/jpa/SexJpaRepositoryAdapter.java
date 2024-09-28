package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.SexRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper.OutfitAttributesMapper;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SexEntity;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SexJpaRepositoryAdapter implements SexRepository {
    private final SexJpaRepository sexJpaRepository;
    private final OutfitAttributesMapper outfitAttributesMapper;

    @Override
    public Optional<SexEntity> findSexByName(String name) {
        return sexJpaRepository.findByName(name);
    }

    @Override
    public List<Sex> findAll() {
        return sexJpaRepository.findAll().stream()
            .map(outfitAttributesMapper::toDomain)
            .toList();
    }

    @Override
    public Sex save(Sex sex) {
        return outfitAttributesMapper.toDomain(sexJpaRepository.save(outfitAttributesMapper.toEntity(sex)));
    }

    @Override
    public void deleteById(Long id) {
        sexJpaRepository.deleteById(id);
    }
}
