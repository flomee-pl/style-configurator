package pl.flomee.styleconfigurator.domain.clothing.core;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.clothing.application.web.request.AddOutfitsRequest;
import pl.flomee.styleconfigurator.domain.clothing.application.web.response.GetClothingOutfits;
import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.incoming.ClothingService;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ClothingRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

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
    public Clothing addClothing(Clothing clothing) {
        return clothingRepository.save(clothing);
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
        return null;
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
