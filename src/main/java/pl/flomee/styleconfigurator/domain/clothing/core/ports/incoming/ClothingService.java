package pl.flomee.styleconfigurator.domain.clothing.core.ports.incoming;

import pl.flomee.styleconfigurator.domain.clothing.application.web.request.AddOutfitsRequest;
import pl.flomee.styleconfigurator.domain.clothing.application.web.response.GetClothingOutfits;
import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.domain.clothing.core.model.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface ClothingService {
    Optional<Clothing> getClothingById(UUID id);
    List<Clothing> listClothing(ClothingPart clothingPart,
                                Shop shop,
                                List<Color> color);

    void addClothing(Clothing clothing);


    void patchClothingById(UUID id, Clothing clothing);

    void deleteClothingById(UUID id);

    Map<String, List<String>> listFilters(String language);

    List<Clothing> saveAll(List<Clothing> clothes);

    void addOutfitsToClothing(UUID id, AddOutfitsRequest outfits);

    GetClothingOutfits getClothingOutfitsById(UUID id);
}
