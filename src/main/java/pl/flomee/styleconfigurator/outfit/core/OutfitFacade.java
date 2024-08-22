package pl.flomee.styleconfigurator.outfit.core;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.clothing.core.ports.incoming.ClothingService;
import pl.flomee.styleconfigurator.clothing.infrastructure.repository.jpa.entity.ClothingEntity;
import pl.flomee.styleconfigurator.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Style;
import pl.flomee.styleconfigurator.outfit.core.ports.incoming.OutfitService;
import pl.flomee.styleconfigurator.outfit.core.ports.outgoing.OutfitRepository;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class OutfitFacade implements OutfitService {
    private final OutfitRepository outfitRepository;
    private final ClothingService clothingService;
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
        List<Clothing> existingClothes = new ArrayList<>();
        List<Clothing> newClothes = new ArrayList<>();

        for (Clothing clothing : outfit.getClothes()) {
            if (clothing.getClothingId() != null &&
                clothingService.getClothingById(clothing.getClothingId()).isPresent()) {
                existingClothes.add(clothingService.getClothingById(clothing.getClothingId()).get());
            } else {
                newClothes.add(clothing);
            }
        }

        List<Clothing> savedNewClothes = clothingService.saveAll(newClothes);

        List<Clothing> combinedClothes = new ArrayList<>();
        combinedClothes.addAll(existingClothes);
        combinedClothes.addAll(savedNewClothes);

        outfit.setClothes(combinedClothes);

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
