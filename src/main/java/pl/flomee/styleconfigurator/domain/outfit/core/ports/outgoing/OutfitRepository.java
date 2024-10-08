package pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing;

import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.domain.outfit.application.web.request.AddClothesRequest;
import pl.flomee.styleconfigurator.domain.outfit.core.model.Outfit;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OutfitRepository {

    Optional<Outfit> findById(UUID id);

    List<Outfit> listOutfit(List<String> sex, List<String> season, List<String> style,List<String> colors, Boolean nonActive);

    Outfit save(Outfit outfit);

    void patchById(UUID id, Outfit outfit);

    void deleteById(UUID id);

    void addClothesToOutfit(UUID id, AddClothesRequest clothesRequest);

    List<Clothing> getOutfitClothesById(UUID id);

    void deleteClothingFromOutfit(UUID outfitId, UUID clothingId);
}
