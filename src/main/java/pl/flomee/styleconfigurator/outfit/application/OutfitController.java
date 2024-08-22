package pl.flomee.styleconfigurator.outfit.application;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.flomee.styleconfigurator.clothing.core.ports.incoming.ClothingService;
import pl.flomee.styleconfigurator.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.outfit.core.model.attributes.Style;
import pl.flomee.styleconfigurator.outfit.core.ports.incoming.OutfitService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/outfit")
public class OutfitController {
    private final OutfitService outfitService;

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Outfit getOutfit(@PathVariable UUID id) {
        return outfitService.getOutfitById(id);
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<Outfit> listOutfit(
        @RequestParam(required = false) Sex sex,
        @RequestParam(required = false) List<Season> season,
        @RequestParam(required = false) List<Style> style
    ) {
        return outfitService.listOutfit(sex, season, style);
    }
    @PostMapping
    @ResponseStatus(OK)
    public void addOutfit(@RequestBody Outfit outfit) {
        outfitService.addOutfit(outfit);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(OK)
    public void updateOutfitPatchById(@PathVariable UUID id, @RequestBody Outfit outfit) {
        outfitService.patchOutfitById(id, outfit);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public void deleteOutfit(@PathVariable UUID id) {
        outfitService.deleteOutfitById(id);
    }

}

