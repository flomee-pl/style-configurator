package pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.flomee.styleconfigurator.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.entity.ClothingEntity;

@Mapper(componentModel = "spring")
public interface ClothingMapper {

    @Mapping(target = "outfits", ignore = true)
    ClothingEntity toEntity(Clothing clothing);

    Clothing toDomain(ClothingEntity clothingEntity);
}
