package pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.clothing.core.model.ClothingPart;
import pl.flomee.styleconfigurator.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.clothing.core.ports.outgoing.ClothingRepository;
import pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.entity.ClothingEntity;
import pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.mapper.ClothingMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ClothingJpaRepositoryAdapter implements ClothingRepository {

    private final ClothingMapper clothingMapper;
    private final ClothingJpaRepository clothingJpaRepository;

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<Clothing> findById(UUID id) {
        return clothingJpaRepository.findById(id).map(clothingMapper::toDomain);
    }

    @Override
    public List<Clothing> listClothing(ClothingPart clothingPart, Shop shop, List<Color> colors) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClothingEntity> query = cb.createQuery(ClothingEntity.class);
        Root<ClothingEntity> clothing = query.from(ClothingEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (clothingPart != null) {
            predicates.add(cb.equal(clothing.get("clothingPart"), clothingPart));
        }
        if (shop != null) {
            predicates.add(cb.equal(clothing.get("shop"), shop));
        }
        if (colors != null && !colors.isEmpty()) {
            Join<ClothingEntity, Color> colorJoin = clothing.join("color");
            predicates.add(colorJoin.in(colors));
        }


        query.where(cb.and(predicates.toArray(new Predicate[0])));

        List<ClothingEntity> clothingEntities = entityManager.createQuery(query).getResultList();

        return clothingEntities.stream().map(clothingMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void save(Clothing clothing) {
        ClothingEntity clothingEntity = clothingMapper.toEntity(clothing);
        clothingJpaRepository.save(clothingEntity);
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
            clothingEntity.setClothingPart(clothing.getClothingPart());
        }
        if (clothing.getShop() != null) {
            clothingEntity.setShop(clothing.getShop());
        }
        if (!clothing.getColor().isEmpty()) {
            clothingEntity.setColor(clothing.getColor());
        }
        if (clothing.getOutfits() != null && !clothing.getOutfits().isEmpty()) {
            clothingEntity.setOutfits(clothing.getOutfits());
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


}
