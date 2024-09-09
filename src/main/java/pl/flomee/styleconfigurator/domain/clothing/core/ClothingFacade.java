package pl.flomee.styleconfigurator.domain.clothing.core;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.clothing.application.web.request.AddOutfitsRequest;
import pl.flomee.styleconfigurator.domain.clothing.application.web.response.GetClothingOutfits;
import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.domain.clothing.core.model.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.incoming.ClothingService;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ClothingRepository;

import java.util.*;
import java.util.stream.Collectors;

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
    public Map<String, List<String>> listFilters(String language) {
        Map<String, List<String>> filters = new HashMap<>();

        filters.put("Shop", mapEnumValues(Shop.values(), language));
        filters.put("Color", mapEnumValues(Color.values(), language));

        return filters;
    }

    private <E extends Enum<E>> List<String> mapEnumValues(E[] enumValues, String language) {
        return Arrays.stream(enumValues)
            .map(value -> "PL".equalsIgnoreCase(language) ? toPolish(value) : value.name())
            .collect(Collectors.toList());
    }

    private String toPolish(Enum<?> enumValue) {
        if (enumValue instanceof Shop) {
            return ((Shop) enumValue).toPolish();
        } else if (enumValue instanceof Color) {
            return ((Color) enumValue).toPolish();
        }
        return enumValue.name();  // defaultowo zwraca nazwę angielską
    }

    @Override
    public List<Clothing> saveAll(List<Clothing> clothes) {
        return clothingRepository.saveAll(clothes);
    }

    @Override
    public void addOutfitsToClothing(UUID id, AddOutfitsRequest outfits) {
        clothingRepository.addOutfitsToClothing(id, outfits);
    }

    @Override
    public GetClothingOutfits getClothingOutfitsById(UUID id) {
        return GetClothingOutfits.builder()
            .outfits(clothingRepository.getClothingOutfitsById(id))
            .build();
    }


}
