package pl.flomee.styleconfigurator.domain.outfit.core;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.outfit.application.web.request.AddClothesRequest;
import pl.flomee.styleconfigurator.domain.outfit.application.web.response.GetOutfitClothes;
import pl.flomee.styleconfigurator.domain.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Style;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.incoming.OutfitService;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.OutfitRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class OutfitFacade implements OutfitService {
    private final OutfitRepository outfitRepository;
    @Override
    public Optional<Outfit> getOutfitById(UUID id) {
        return outfitRepository.findById(id);
    }

    @Override
    public List<Outfit> listOutfit(List<String> sex, List<String> season, List<String> style,List<String> colors, Boolean nonActive) {
        return outfitRepository.listOutfit(sex,season,style,colors, nonActive);
    }

    @Override
    public Outfit addOutfit(Outfit outfit) {
        return outfitRepository.save(outfit);
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


        return null;
    }

    @Override
    public void addClothesToOutfit(UUID id, AddClothesRequest clothesRequest) {
        outfitRepository.addClothesToOutfit(id, clothesRequest);
    }

    @Override
    public GetOutfitClothes getOutfitClothesById(UUID id) {
        return GetOutfitClothes.builder()
            .clothes(outfitRepository.getOutfitClothesById(id))
            .build();
    }

    @Override
    public void deleteClothingFromOutfit(UUID outfitId, UUID clothingId) {
        outfitRepository.deleteClothingFromOutfit(outfitId, clothingId);
    }

}
