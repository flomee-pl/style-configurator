package pl.flomee.styleconfigurator.domain.outfit.core.ports.incoming;

import pl.flomee.styleconfigurator.domain.outfit.application.web.request.AddClothesRequest;
import pl.flomee.styleconfigurator.domain.outfit.application.web.response.GetOutfitClothes;
import pl.flomee.styleconfigurator.domain.outfit.core.model.Outfit;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface OutfitService {
    Optional<Outfit> getOutfitById(UUID id);

    List<Outfit> listOutfit(List<String> sex, List<String> season, List<String> style, Boolean nonActive);

    Outfit addOutfit(Outfit outfit);

    void patchOutfitById(UUID id, Outfit outfit);

    void deleteOutfitById(UUID id);

    Map<String, List<String>> listFilters(String language);

    void addClothesToOutfit(UUID id, AddClothesRequest clothesRequest);

    GetOutfitClothes getOutfitClothesById(UUID id);

    void deleteClothingFromOutfit(UUID outfitId, UUID clothingId);
}
