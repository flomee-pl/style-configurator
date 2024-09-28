package pl.flomee.styleconfigurator.domain.clothing.core;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.incoming.ClothingAttributesService;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ClothingPartRepository;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ColorRepository;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing.ShopRepository;

import java.util.List;

@RequiredArgsConstructor
public class ClothingAttributesFacade implements ClothingAttributesService {
    private final ClothingPartRepository clothingPartRepository;
    private final ColorRepository colorRepository;
    private final ShopRepository shopRepository;

    @Override
    public List<ClothingPart> listClothingParts() {
        return clothingPartRepository.findAll();
    }

    @Override
    public ClothingPart addClothingPart(ClothingPart clothingPart) {
        return clothingPartRepository.save(clothingPart);
    }

    @Override
    public void deleteClothingPartById(Long id) {
        clothingPartRepository.deleteById(id);
    }

    @Override
    public List<Color> listColors() {
        return colorRepository.findAll();
    }

    @Override
    public Color addColor(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public void deleteColorById(Long id) {
        colorRepository.deleteById(id);
    }

    @Override
    public List<Shop> listShops() {
        return shopRepository.findAll();
    }

    @Override
    public Shop addShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public void deleteShopById(Long id) {
        shopRepository.deleteById(id);
    }
}
