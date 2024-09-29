package pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.ClothingJpaRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.ClothingEntity;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper.ClothingMapper;
import pl.flomee.styleconfigurator.domain.outfit.application.web.request.AddClothesRequest;
import pl.flomee.styleconfigurator.domain.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.OutfitRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper.OutfitAttributesMapper;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper.OutfitMapper;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.OutfitEntity;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SeasonEntity;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SexEntity;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.StyleEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class OutfitJpaRepositoryAdapter implements OutfitRepository {
    private final OutfitMapper outfitMapper;
    private final OutfitJpaRepository outfitJpaRepository;
    private final SeasonJpaRepository seasonJpaRepository;
    private final SexJpaRepository sexJpaRepository;
    private final StyleJpaRepository styleJpaRepository;
    private final ClothingJpaRepository clothingJpaRepository;
    private final ClothingMapper clothingMapper;
    private final OutfitAttributesMapper outfitAttributesMapper;

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<Outfit> findById(UUID id) {
        return outfitJpaRepository.findById(id).map(outfitMapper::toDomain);
    }

    @Override
    public List<Outfit> listOutfit(List<String> sex, List<String> season, List<String> style, Boolean nonActive) {

        return outfitJpaRepository.findByFilters(sex, season, style, nonActive)
            .stream()
            .map(outfitMapper::toDomain)
            .toList();
    }

    @Override
    public Outfit save(Outfit outfit) {
        OutfitEntity outfitEntity = outfitMapper.toEntity(outfit);
        outfitEntity.setSex(
            sexJpaRepository.findByName(
                    outfit.getSex().getName())
                .orElseThrow(EntityNotFoundException::new));

        outfitEntity.setSeason(outfit.getSeason().stream().map(
            season -> seasonJpaRepository.findByName(season.getName())
                .orElseThrow(EntityNotFoundException::new)).toList());

        outfitEntity.setStyle(outfit.getStyle().stream().map(
            style -> styleJpaRepository.findByName(style.getName())
                .orElseThrow(EntityNotFoundException::new)).toList());
        return outfitMapper.toDomain(outfitJpaRepository.save(outfitEntity));
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
            outfitEntity.setSex(outfitAttributesMapper.toEntity( outfit.getSex()));
        }
        if (outfit.getStyle() != null && !outfit.getStyle().isEmpty()) {
            outfitEntity.setStyle(outfit.getStyle().stream().map(outfitAttributesMapper::toEntity).toList());
        }
        if (outfit.getSeason() != null && !outfit.getSeason().isEmpty()) {
            outfitEntity.setSeason(outfit.getSeason().stream().map(outfitAttributesMapper::toEntity).toList());
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

    @Override
    public void addClothesToOutfit(UUID id, AddClothesRequest clothes) {
        OutfitEntity outfitEntity = outfitJpaRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);

        List<ClothingEntity> clothingEntities = clothingJpaRepository.findAllById(clothes.getClothesIds());

        clothingEntities.forEach(clothingEntity -> {
            if (!outfitEntity.getClothes().contains(clothingEntity)) {
                outfitEntity.getClothes().add(clothingEntity);
                clothingEntity.getOutfits().add(outfitEntity);
            }
        });

        outfitJpaRepository.save(outfitEntity);
    }

    @Override
    public List<Clothing> getOutfitClothesById(UUID id) {
        OutfitEntity outfitEntity = outfitJpaRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);
        return outfitEntity.getClothes().stream().map(clothingMapper::toDomain).toList();
    }

    @Override
    public void deleteClothingFromOutfit(UUID outfitId, UUID clothingId) {
        OutfitEntity outfitEntity = outfitJpaRepository.findById(outfitId)
            .orElseThrow(EntityNotFoundException::new);
        ClothingEntity clothingEntity = clothingJpaRepository.findById(clothingId)
            .orElseThrow(EntityNotFoundException::new);

        outfitEntity.getClothes().remove(clothingEntity);
        clothingEntity.getOutfits().remove(outfitEntity);

        outfitJpaRepository.save(outfitEntity);
    }
}
