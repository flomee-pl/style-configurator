package pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.mapper;

import org.mapstruct.Mapper;
import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.entity.ClothingEntity;

@Mapper(componentModel = "spring")
public interface ClothingMapper {

    ClothingEntity toEntity(Clothing clothing);

    Clothing toDomain(ClothingEntity clothingEntity);
}
