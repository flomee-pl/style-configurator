package pl.flomee.styleconfigurator.clothing.application;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.flomee.styleconfigurator.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.clothing.core.model.ClothingPart;
import pl.flomee.styleconfigurator.clothing.core.model.attributes.*;
import pl.flomee.styleconfigurator.clothing.core.ports.incoming.ClothingService;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Style;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clothing")
public class ClothingController {

    private final ClothingService clothingService;

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Clothing getClothingById(@PathVariable UUID id) {
        return clothingService.getClothingById(id)
            .orElseThrow(NotFoundException::new);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<Clothing> listClothing(
        @RequestParam(required = false) ClothingPart clothingPart,
        @RequestParam(required = false) Shop shop,
        @RequestParam(required = false) List<Color> color
        ) {
        return clothingService.listClothing(
            clothingPart,
            shop,
            color
            );
    }

    @PostMapping
    @ResponseStatus(OK)
    public void addClothing(@RequestBody Clothing clothing) {
        clothingService.addClothing(clothing);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(OK)
    public void updateClothingPatchById(@PathVariable UUID id, @RequestBody Clothing clothing) {
        clothingService.patchClothingById(id, clothing);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public void deleteClothing(@PathVariable UUID id) {
        clothingService.deleteClothingById(id);
    }
}
