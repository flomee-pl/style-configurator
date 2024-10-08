package pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing;

import pl.flomee.styleconfigurator.domain.clothing.application.web.request.AddOutfitsRequest;
import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.domain.outfit.core.model.Outfit;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClothingRepository {
    Optional<Clothing> findById(UUID id);

    List<Clothing> listClothing(List<String> clothingPart,
                                List<String> shop,
                                List<String> color
    );

    Clothing save(Clothing clothing);

    void patchById(UUID id, Clothing clothing);

    void deleteById(UUID id);

    void deleteAll();

    List<Clothing> findAll();

    List<Clothing> saveAll(List<Clothing> clothes);

    void addOutfitsToClothing(UUID id, AddOutfitsRequest outfits);

    List<Outfit> getClothingOutfitsById(UUID id);
}
