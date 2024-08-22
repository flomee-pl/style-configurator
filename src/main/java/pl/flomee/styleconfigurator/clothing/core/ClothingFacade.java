package pl.flomee.styleconfigurator.clothing.core;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.clothing.core.model.ClothingPart;
import pl.flomee.styleconfigurator.clothing.core.model.attributes.*;
import pl.flomee.styleconfigurator.clothing.core.ports.incoming.ClothingService;
import pl.flomee.styleconfigurator.clothing.core.ports.outgoing.ClothingRepository;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Style;

import java.util.*;

@RequiredArgsConstructor
public class ClothingFacade implements ClothingService {
    private final ClothingRepository clothingRepository;

    @Override
    public Optional<Clothing> getClothingById(UUID id) {
        return clothingRepository.findById(id);
    }

    @Override
    public List<Clothing> listClothing(ClothingPart clothingPart, Shop shop, List<Color> color) {
        return clothingRepository.listClothing(clothingPart, shop, color);
    }

    @Override
    public void addClothing(Clothing clothing) {
        clothingRepository.save(clothing);
    }

    @Override
    public void patchClothingById(UUID id, Clothing clothing) {
        clothingRepository.patchById(id, clothing);
    }

    @Override
    public void deleteClothingById(UUID id) {
        clothingRepository.deleteById(id);
    }

    @Override
    public Map<String, List<String>> listFilters() {
        Map<String, List<String>> filters = new HashMap<>();

        filters.put("Shop", List.of(Arrays.toString(Shop.values())));
        filters.put("Color", List.of(Arrays.toString(Color.values())));

        return filters;
    }

    @Override
    public List<Clothing> saveAll(List<Clothing> clothes) {
        return clothingRepository.saveAll(clothes);
    }


}
