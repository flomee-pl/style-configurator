package pl.flomee.styleconfigurator.domain.outfit.core;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.OutfitRepository;
import pl.flomee.styleconfigurator.domain.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Style;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.incoming.OutfitService;

import java.util.*;

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
    public Map<String, List<String>> listFilters() {
        Map<String, List<String>> filters = new HashMap<>();

        filters.put("Sex", List.of(Arrays.toString(Sex.values())));
        filters.put("Style", List.of(Arrays.toString(Style.values())));
        filters.put("Season", List.of(Arrays.toString(Season.values())));

        return filters;
    }
}
