package pl.flomee.styleconfigurator.domain.clothing.application.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.flomee.styleconfigurator.domain.clothing.application.exception.NotFoundException;
import pl.flomee.styleconfigurator.domain.clothing.application.web.request.AddOutfitsRequest;
import pl.flomee.styleconfigurator.domain.clothing.application.web.response.ClothingIdResponse;
import pl.flomee.styleconfigurator.domain.clothing.application.web.response.GetClothingOutfits;
import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.incoming.ClothingService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clothing")
public class ClothingController implements IClothingController {

    private final ClothingService clothingService;

    @Override
    public Clothing getClothingById(@PathVariable UUID id) {
        return clothingService.getClothingById(id)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Clothing> listClothing(
        @RequestParam(required = false) List<String> clothingPart,
        @RequestParam(required = false) List<String> shop,
        @RequestParam(required = false) List<String> color
    ) {
        return clothingService.listClothing(
            clothingPart,
            shop,
            color
        );
    }

    @Override
    public GetClothingOutfits getClothingOutfitsById(UUID id) {
        return clothingService.getClothingOutfitsById(id);
    }

    @Override
    public ClothingIdResponse addClothing(@RequestBody Clothing clothing) {
        return new ClothingIdResponse(
            clothingService.addClothing(clothing).getClothingId()
        );

    }

    @Override
    public void addOutfitsToClothing(@PathVariable UUID id, @RequestBody AddOutfitsRequest outfitsRequest) {
        clothingService.addOutfitsToClothing(id, outfitsRequest);
    }

    @Override
    public void updateClothingPatchById(@PathVariable UUID id, @RequestBody Clothing clothing) {
        clothingService.patchClothingById(id, clothing);
    }

    @Override
    public void deleteClothing(@PathVariable UUID id) {
        clothingService.deleteClothingById(id);
    }
}
