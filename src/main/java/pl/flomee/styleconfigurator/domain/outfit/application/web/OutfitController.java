package pl.flomee.styleconfigurator.domain.outfit.application.web;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.flomee.styleconfigurator.domain.outfit.application.exception.NotFoundException;
import pl.flomee.styleconfigurator.domain.outfit.application.web.request.AddClothesRequest;
import pl.flomee.styleconfigurator.domain.outfit.application.web.response.GetOutfitClothes;
import pl.flomee.styleconfigurator.domain.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Style;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.incoming.OutfitService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/outfit")
public class OutfitController implements IOutfitController {
    private final OutfitService outfitService;

    @Override
    public Outfit getOutfit(@PathVariable UUID id) {
        return outfitService.getOutfitById(id)
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Outfit> listOutfit(
        @RequestParam(required = false) Sex sex,
        @RequestParam(required = false) List<Season> season,
        @RequestParam(required = false) List<Style> style
    ) {
        return outfitService.listOutfit(sex, season, style);
    }

    @Override
    public GetOutfitClothes getOutfitClothesById(UUID id) {
        return outfitService.getOutfitClothesById(id);
    }

    @Override
    public void addOutfit(@Validated @RequestBody Outfit outfit) {
        outfitService.addOutfit(outfit);
    }

    @Override
    public void addClothesToOutfit(@PathVariable UUID id, @RequestBody AddClothesRequest clothesRequest) {
        outfitService.addClothesToOutfit(id, clothesRequest);
    }

    @Override
    public void updateOutfitPatchById(@PathVariable UUID id, @Validated @RequestBody Outfit outfit) {
        outfitService.patchOutfitById(id, outfit);
    }

    @Override
    public void deleteOutfit(@PathVariable UUID id) {
        outfitService.deleteOutfitById(id);
    }

}

