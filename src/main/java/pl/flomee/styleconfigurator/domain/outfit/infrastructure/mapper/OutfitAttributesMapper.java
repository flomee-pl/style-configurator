package pl.flomee.styleconfigurator.domain.outfit.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Style;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SeasonEntity;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.SexEntity;
import pl.flomee.styleconfigurator.domain.outfit.infrastructure.repository.jpa.entity.attributes.StyleEntity;

@Mapper(componentModel = "spring")
public interface OutfitAttributesMapper {

    @Mapping(target = "seasonId")
    SeasonEntity toEntity(Season season);

    @Mapping(target = "seasonId")
    Season toDomain(SeasonEntity seasonEntity);

    @Mapping(target = "sexId")
    SexEntity toEntity(Sex sex);

    @Mapping(target = "sexId")
    Sex toDomain(SexEntity sexEntity);

    @Mapping(target = "styleId")
    StyleEntity toEntity(Style style);

}
