package pl.flomee.styleconfigurator.outfit.infrastructure.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Style;
import pl.flomee.styleconfigurator.outfit.core.ports.outgoing.OutfitRepository;
import pl.flomee.styleconfigurator.outfit.infrastructure.mapper.OutfitMapper;
import pl.flomee.styleconfigurator.outfit.infrastructure.repository.jpa.entity.OutfitEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class OutfitJpaRepositoryAdapter implements OutfitRepository {
    private final OutfitMapper outfitMapper;
    private final OutfitJpaRepository outfitJpaRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<Outfit> findById(UUID id) {
        return outfitJpaRepository.findById(id).map(outfitMapper::toDomain);
    }

    @Override
    public List<Outfit> listOutfit(Sex sex, List<Season> season, List<Style> style) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<OutfitEntity> query = cb.createQuery(OutfitEntity.class);
        Root<OutfitEntity> outfit = query.from(OutfitEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (sex != null) {
            predicates.add(cb.equal(outfit.get("sex"), sex));
        }
        if (season != null && !season.isEmpty()) {
            Join<OutfitEntity, Season> seasonJoin = outfit.join("season");
            predicates.add(seasonJoin.in(season));
        }
        if (style != null && !style.isEmpty()) {
            Join<OutfitEntity, Style> styleJoin = outfit.join("style");
            predicates.add(styleJoin.in(style));
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        List<OutfitEntity> outfitEntities = entityManager.createQuery(query).getResultList();
        return outfitEntities.stream()
            .map(outfitMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void save(Outfit outfit) {
        outfitJpaRepository.save(outfitMapper.toEntity(outfit));
    }

    @Override
    public void patchById(UUID id, Outfit outfit) {
        OutfitEntity outfitEntity = outfitJpaRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);

        if (outfit.getOutfitName() != null) {
            outfitEntity.setOutfitName(outfit.getOutfitName());
        }
        if (outfit.getDescription() != null) {
            outfitEntity.setDescription(outfit.getDescription());
        }
        if (outfit.getOutfitImageUrl() != null) {
            outfitEntity.setOutfitImageUrl(outfit.getOutfitImageUrl());
        }
        if (outfit.getSex() != null) {
            outfitEntity.setSex(outfit.getSex());
        }
        if (outfit.getStyle() !=null && !outfit.getStyle().isEmpty()) {
            outfitEntity.setStyle(outfit.getStyle());
        }
        if (outfit.getSeason() != null && !outfit.getSeason().isEmpty()) {
            outfitEntity.setSeason(outfit.getSeason());
        }
        if (outfit.getIsActive() != null) {
            outfitEntity.setIsActive(outfit.getIsActive());
        }

        outfitJpaRepository.save(outfitEntity);
    }

    @Override
    public void deleteById(UUID id) {
        outfitJpaRepository.deleteById(id);
    }
}
