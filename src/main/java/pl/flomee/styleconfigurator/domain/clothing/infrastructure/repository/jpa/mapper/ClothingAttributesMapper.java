package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ClothingPartEntity;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ColorEntity;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.attributes.ShopEntity;

@Mapper(componentModel = "spring")
public interface ClothingAttributesMapper {
    @Mapping(target = "clothingPartId")
    ClothingPartEntity toEntity(ClothingPart clothingPart);

    @Mapping(target = "clothingPartId")
    ClothingPart toDomain(ClothingPartEntity clothingPartEntity);

    @Mapping(target = "colorId")
    ColorEntity toEntity(Color color);

    @Mapping(target = "colorId")
    Color toDomain(ColorEntity colorEntity);

    @Mapping(target = "shopId")
    ShopEntity toEntity(Shop shop);

    @Mapping(target = "shopId")
    Shop toDomain(ShopEntity shopEntity);
}
