package pl.flomee.styleconfigurator.outfit.core.ports.incoming;

import pl.flomee.styleconfigurator.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Style;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface OutfitService {
    Optional<Outfit> getOutfitById(UUID id);

    List<Outfit> listOutfit(Sex sex, List<Season> season, List<Style> style);

    void addOutfit(Outfit outfit);

    void patchOutfitById(UUID id, Outfit outfit);

    void deleteOutfitById(UUID id);

    Map<String, List<String>> listFilters();
}
