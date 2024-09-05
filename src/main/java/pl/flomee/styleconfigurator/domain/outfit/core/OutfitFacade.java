package pl.flomee.styleconfigurator.domain.outfit.core;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.OutfitRepository;
import pl.flomee.styleconfigurator.domain.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Style;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.incoming.OutfitService;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class OutfitFacade implements OutfitService {
    private final OutfitRepository outfitRepository;
    @Override
    public Optional<Outfit> getOutfitById(UUID id) {
        return outfitRepository.findById(id);
    }

    @Override
    public List<Outfit> listOutfit(Sex sex, List<Season> season, List<Style> style) {
        return outfitRepository.listOutfit(sex,season,style);
    }

    @Override
    public void addOutfit(Outfit outfit) {
        outfitRepository.save(outfit);
    }

    @Override
    public void patchOutfitById(UUID id, Outfit outfit) {
        outfitRepository.patchById(id,outfit);
    }

    @Override
    public void deleteOutfitById(UUID id) {
        outfitRepository.deleteById(id);
    }

    @Override
    public Map<String, List<String>> listFilters(String language) {
        Map<String, List<String>> filters = new HashMap<>();

        filters.put("Sex", mapEnumValues(Sex.values(), language));
        filters.put("Style", mapEnumValues(Style.values(), language));
        filters.put("Season", mapEnumValues(Season.values(), language));

        return filters;
    }

    private <E extends Enum<E>> List<String> mapEnumValues(E[] enumValues, String language) {
        return Arrays.stream(enumValues)
            .map(value -> "PL".equalsIgnoreCase(language) ? toPolish(value) : value.name())
            .collect(Collectors.toList());
    }

    private String toPolish(Enum<?> enumValue) {
        if (enumValue instanceof Season) {
            return ((Season) enumValue).toPolish();
        } else if (enumValue instanceof Sex) {
            return ((Sex) enumValue).toPolish();
        } else if (enumValue instanceof Style) {
            return ((Style) enumValue).toPolish();
        }
        return enumValue.name();  // defaultowo zwraca nazwę angielską
    }
}
