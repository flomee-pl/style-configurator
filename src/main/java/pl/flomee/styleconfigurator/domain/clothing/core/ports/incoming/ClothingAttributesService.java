package pl.flomee.styleconfigurator.domain.clothing.core.ports.incoming;

import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;

import java.util.List;

public interface ClothingAttributesService {
    List<ClothingPart> listClothingParts();
    ClothingPart addClothingPart(ClothingPart clothingPart);
    void deleteClothingPartById(Long id);

    List<Color> listColors();
    Color addColor(Color color);
    void deleteColorById(Long id);

    List<Shop> listShops();
    Shop addShop(Shop shop);
    void deleteShopById(Long id);
}
