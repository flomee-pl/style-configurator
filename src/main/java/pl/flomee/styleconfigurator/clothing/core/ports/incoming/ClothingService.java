package pl.flomee.styleconfigurator.clothing.core.ports.incoming;

import pl.flomee.styleconfigurator.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.clothing.core.model.ClothingPart;
import pl.flomee.styleconfigurator.clothing.core.model.attributes.*;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Style;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface ClothingService {
    void addClothing(Clothing clothing);
    Optional<Clothing> getClothingById(UUID id);
    List<Clothing> listClothing(ClothingPart clothingPart,
                                Shop shop,
                                List<Color> color);
    void patchClothingById(UUID id, Clothing clothing);
    void deleteClothingById(UUID id);

    Map<String,List<String>> listFilters();
}
