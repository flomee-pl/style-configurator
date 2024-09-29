package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.clothing.application.web.request.AddOutfitsRequest;
import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ClothingRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.ClothingEntity;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper.ClothingAttributesMapper;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper.ClothingMapper;
import pl.flomee.styleconfigurator.domain.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper.OutfitMapper;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.OutfitJpaRepository;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.OutfitEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ClothingJpaRepositoryAdapter implements ClothingRepository {

    private final ClothingMapper clothingMapper;
    private final ClothingJpaRepository clothingJpaRepository;
    private final ClothingPartJpaRepository clothingPartJpaRepository;
    private final ColorJpaRepository colorJpaRepository;
    private final ShopJpaRepository shopJpaRepository;
    private final OutfitJpaRepository outfitJpaRepository;
    private final OutfitMapper outfitMapper;
    private final ClothingAttributesMapper clothingAttributesMapper;

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<Clothing> findById(UUID id) {
        return clothingJpaRepository.findById(id).map(clothingMapper::toDomain);
    }

    @Override
    public List<Clothing> listClothing(List<String> clothingPart, List<String> shop, List<String> colors) {

        return clothingJpaRepository.findByFilters(
            clothingPart,
            shop,
            colors
        ).stream().map(clothingMapper::toDomain).toList();
    }

    @Override
    public Clothing save(Clothing clothing) {
        ClothingEntity clothingEntity = clothingMapper.toEntity(clothing);
        clothingEntity.setClothingPart(
            clothingPartJpaRepository.findByName(
                clothing.getClothingPart().getName()
            ).orElseThrow(EntityNotFoundException::new));

        clothingEntity.setShop(
            shopJpaRepository.findByName(
                clothing.getShop().getName()
            ).orElseThrow(EntityNotFoundException::new));

        clothingEntity.setColor(clothing.getColor().stream().map(
                color -> colorJpaRepository.findByName(
                        color.getName())
                    .orElseThrow(EntityNotFoundException::new))
            .toList()
        );
        return clothingMapper.toDomain(clothingJpaRepository.save(clothingEntity));
    }

    @Override
    public void patchById(UUID id, Clothing clothing) {
        ClothingEntity clothingEntity = clothingJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (clothing.getClothingName() != null) {
            clothingEntity.setClothingName(clothing.getClothingName());
        }
        if (clothing.getClothingImageUrl() != null) {
            clothingEntity.setClothingImageUrl(clothing.getClothingImageUrl());
        }
        if (clothing.getPrice() != null) {
            clothingEntity.setPrice(clothing.getPrice());
        }
        if (clothing.getLink() != null) {
            clothingEntity.setLink(clothing.getLink());
        }
        if (clothing.getClothingPart() != null) {
            clothingEntity.setClothingPart(clothingAttributesMapper.toEntity(clothing.getClothingPart()));
        }
        if (clothing.getShop() != null) {
            clothingEntity.setShop(clothingAttributesMapper.toEntity(clothing.getShop()));
        }
        if (clothing.getColor() != null && !clothing.getColor().isEmpty()) {
            clothingEntity.setColor(clothing.getColor().stream().map(clothingAttributesMapper::toEntity).toList());
        }
        clothingJpaRepository.save(clothingEntity);

    }

    @Override
    public void deleteById(UUID id) {
        clothingJpaRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        clothingJpaRepository.deleteAll();
    }

    @Override
    public List<Clothing> findAll() {
        return clothingJpaRepository.findAll()
            .stream()
            .map(clothingMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public List<Clothing> saveAll(List<Clothing> clothes) {
        return clothingJpaRepository.saveAll(clothes
                .stream()
                .map(clothingMapper::toEntity)
                .collect(Collectors.toList()))
            .stream()
            .map(clothingMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void addOutfitsToClothing(UUID id, AddOutfitsRequest outfits) {
        ClothingEntity clothingEntity = clothingJpaRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);

        List<OutfitEntity> outfitEntities = outfitJpaRepository.findAllById(outfits.getOutfitIds());

        outfitEntities.forEach(outfitEntity -> {
            if (!clothingEntity.getOutfits().contains(outfitEntity)) {
                clothingEntity.getOutfits().add(outfitEntity);
                outfitEntity.getClothes().add(clothingEntity);
            }
        });

        clothingJpaRepository.save(clothingEntity);
    }

    @Override
    public List<Outfit> getClothingOutfitsById(UUID id) {
        ClothingEntity clothingEntity = clothingJpaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return clothingEntity.getOutfits().stream().map(outfitMapper::toDomain).toList();

    }
}
