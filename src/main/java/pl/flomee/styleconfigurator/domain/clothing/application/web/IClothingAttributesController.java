package pl.flomee.styleconfigurator.domain.clothing.application.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Tag(name = "Clothing Attributes", description = "API for retrieving clothing attributes")
@RequestMapping("api/v1/clothing/attributes")
public interface IClothingAttributesController {

    @GetMapping("/clothing-parts")
    @ResponseStatus(OK)
    List<ClothingPart> listClothingParts();

    @PostMapping("/clothing-parts")
    @ResponseStatus(OK)
    ClothingPart addClothingPart(@RequestBody ClothingPart clothingPart);

    @DeleteMapping("/clothing-parts/{id}")
    @ResponseStatus(OK)
    void deleteClothingPart(@PathVariable Long id);

    @GetMapping("/colors")
    @ResponseStatus(OK)
    List<Color> listColors();

    @PostMapping("/colors")
    @ResponseStatus(OK)
    Color addColor(@RequestBody Color color);

    @DeleteMapping("/colors/{id}")
    @ResponseStatus(OK)
    void deleteColor(@PathVariable Long id);

    @GetMapping("/shops")
    @ResponseStatus(OK)
    List<Shop> listShops();

    @PostMapping("/shops")
    @ResponseStatus(OK)
    Shop addShop(@RequestBody Shop shop);

    @DeleteMapping("/shops/{id}")
    @ResponseStatus(OK)
    void deleteShop(@PathVariable Long id);

}