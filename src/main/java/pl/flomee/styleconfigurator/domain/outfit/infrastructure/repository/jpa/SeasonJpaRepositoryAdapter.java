package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.SeasonRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper.OutfitAttributesMapper;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SeasonEntity;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SeasonJpaRepositoryAdapter implements SeasonRepository {
    private final SeasonJpaRepository seasonJpaRepository;
    private final OutfitAttributesMapper outfitAttributesMapper;

    @Override
    public Optional<SeasonEntity> findSeasonByName(String name) {
        return seasonJpaRepository.findByName(name);
    }

    @Override
    public List<Season> findAll() {
        return seasonJpaRepository.findAll().stream()
            .map(outfitAttributesMapper::toDomain)
            .toList();
    }

    @Override
    public Season save(Season season) {
        return outfitAttributesMapper.toDomain(seasonJpaRepository.save(outfitAttributesMapper.toEntity(season)));
    }

    @Override
    public void deleteById(Long id) {
        seasonJpaRepository.deleteById(id);
    }
}
