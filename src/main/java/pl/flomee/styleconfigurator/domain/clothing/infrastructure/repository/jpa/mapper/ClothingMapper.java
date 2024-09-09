package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.ClothingEntity;
import pl.flomee.styleconfigurator.domain.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.OutfitEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ClothingMapper {

    @Mapping(target = "outfits", ignore = true)
    Clothing toDomain(ClothingEntity clothingEntity);

    @Mapping(target = "outfits", ignore = true)
    ClothingEntity toEntity(Clothing clothing);


}
