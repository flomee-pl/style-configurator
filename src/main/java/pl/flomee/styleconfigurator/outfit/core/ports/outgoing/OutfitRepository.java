package pl.flomee.styleconfigurator.outfit.core.ports.outgoing;

import pl.flomee.styleconfigurator.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Style;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OutfitRepository {

    void save(Outfit outfit);

    Optional<Outfit> findById(UUID id);

    void deleteById(UUID id);

    List<Outfit> listOutfit(Sex sex, List<Season> season, List<Style> style);

    void patchById(UUID id, Outfit outfit);
}
