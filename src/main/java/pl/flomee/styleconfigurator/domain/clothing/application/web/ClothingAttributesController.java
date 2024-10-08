package pl.flomee.styleconfigurator.domain.clothing.application.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.incoming.ClothingAttributesService;

import java.util.List;

@RestController
@RequestMapping("api/v1/clothing/attributes")
@RequiredArgsConstructor
public class ClothingAttributesController implements IClothingAttributesController {

    private final ClothingAttributesService clothingAttributesService;

    @Override
    public List<ClothingPart> listClothingParts() {
        return clothingAttributesService.listClothingParts();
    }

    @Override
    public ClothingPart addClothingPart(ClothingPart clothingPart) {
        return clothingAttributesService.addClothingPart(clothingPart);
    }

    @Override
    public void deleteClothingPart(Long id) {
        clothingAttributesService.deleteClothingPartById(id);
    }

    @Override
    public List<Color> listColors() {
        return clothingAttributesService.listColors();
    }

    @Override
    public Color addColor(Color color) {
        return clothingAttributesService.addColor(color);
    }

    @Override
    public void deleteColor(Long id) {
        clothingAttributesService.deleteColorById(id);
    }

    @Override
    public List<Shop> listShops() {
        return clothingAttributesService.listShops();
    }

    @Override
    public Shop addShop(Shop shop) {
        return clothingAttributesService.addShop(shop);
    }

    @Override
    public void deleteShop(Long id) {
        clothingAttributesService.deleteShopById(id);
    }
}
