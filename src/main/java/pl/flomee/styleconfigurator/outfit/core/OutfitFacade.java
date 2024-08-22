package pl.flomee.styleconfigurator.outfit.core;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Style;
import pl.flomee.styleconfigurator.outfit.core.ports.incoming.OutfitService;
import pl.flomee.styleconfigurator.outfit.core.ports.outgoing.OutfitRepository;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class OutfitFacade implements OutfitService {
    private final OutfitRepository outfitRepository;
    @Override
    public void addOutfit(Outfit outfit) {
        outfitRepository.save(outfit);
    }

    @Override
    public Outfit getOutfitById(UUID id) {
        return outfitRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteOutfitById(UUID id) {
        outfitRepository.deleteById(id);
    }

    @Override
    public List<Outfit> listOutfit(Sex sex, List<Season> season, List<Style> style) {
        return outfitRepository.listOutfit(sex,season,style);
    }

    @Override
    public void patchOutfitById(UUID id, Outfit outfit) {
        outfitRepository.patchById(id,outfit);
    }
}
