package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa;


import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ShopRepository;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ShopEntity;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper.ClothingAttributesMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ShopJpaRepositoryAdapter implements ShopRepository {
    private final ShopJpaRepository shopJpaRepository;
    private final ClothingAttributesMapper clothingAttributesMapper;
    @Override
    public Optional<ShopEntity> findByName(String name) {
        return shopJpaRepository.findByName(name);
    }

    @Override
    public List<Shop> findAll() {
        return shopJpaRepository.findAll().stream().map(clothingAttributesMapper::toDomain).toList();
    }

    @Override
    public Shop save(Shop shop) {
        return clothingAttributesMapper.toDomain(shopJpaRepository.save(clothingAttributesMapper.toEntity(shop)));
    }

    @Override
    public void deleteById(Long id) {
        shopJpaRepository.deleteById(id);
    }
}
