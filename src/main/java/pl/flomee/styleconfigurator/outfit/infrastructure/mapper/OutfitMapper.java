package pl.flomee.styleconfigurator.outfit.infrastructure.mapper;

import org.mapstruct.Mapper;
import pl.flomee.styleconfigurator.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.outfit.infrastructure.repository.jpa.entity.OutfitEntity;

@Mapper(componentModel = "spring")
public interface OutfitMapper {

    OutfitEntity toEntity(Outfit outfit);

    Outfit toDomain(OutfitEntity outfitEntity);
}
