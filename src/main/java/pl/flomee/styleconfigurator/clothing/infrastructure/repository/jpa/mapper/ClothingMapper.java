package pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.mapper;

import org.mapstruct.Mapper;
import pl.flomee.styleconfigurator.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.entity.ClothingEntity;

@Mapper(componentModel = "spring")
public interface ClothingMapper {

    ClothingEntity toEntity(Clothing clothing);

    Clothing toDomain(ClothingEntity clothingEntity);
}
