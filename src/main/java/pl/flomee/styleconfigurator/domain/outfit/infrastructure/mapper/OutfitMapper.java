package pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.flomee.styleconfigurator.domain.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.OutfitEntity;

@Mapper(componentModel = "spring")
public interface OutfitMapper {

    @Mapping(target = "clothes")
    OutfitEntity toEntity(Outfit outfit);

    @Mapping(target = "clothes", ignore = true)
    Outfit toDomain(OutfitEntity outfitEntity);
}
