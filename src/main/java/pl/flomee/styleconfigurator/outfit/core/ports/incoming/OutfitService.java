package pl.flomee.styleconfigurator.outfit.core.ports.incoming;

import pl.flomee.styleconfigurator.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Style;

import java.util.List;
import java.util.UUID;

public interface OutfitService {
    void addOutfit(Outfit outfit);

    Outfit getOutfitById(UUID id);

    void deleteOutfitById(UUID id);

    List<Outfit> listOutfit(Sex sex, List<Season> season, List<Style> style);

    void patchOutfitById(UUID id, Outfit outfit);
}
