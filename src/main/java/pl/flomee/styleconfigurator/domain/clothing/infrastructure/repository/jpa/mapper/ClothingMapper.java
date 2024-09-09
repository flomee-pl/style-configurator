package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.ClothingEntity;

@Mapper(componentModel = "spring")
public interface ClothingMapper {

    @Mapping(target = "outfits", ignore = true)
    Clothing toDomain(ClothingEntity clothingEntity);

    @Mapping(target = "outfits")
    ClothingEntity toEntity(Clothing clothing);


}
