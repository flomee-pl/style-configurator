package pl.flomee.styleconfigurator.domain.outfit.application.web;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.flomee.styleconfigurator.domain.outfit.application.exception.NotFoundException;
import pl.flomee.styleconfigurator.domain.outfit.application.web.request.AddClothesRequest;
import pl.flomee.styleconfigurator.domain.outfit.application.web.request.DeleteClothingRequest;
import pl.flomee.styleconfigurator.domain.outfit.application.web.response.GetOutfitClothes;
import pl.flomee.styleconfigurator.domain.outfit.application.web.response.OutfitIdResponse;
import pl.flomee.styleconfigurator.domain.outfit.core.model.Outfit;
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
        @RequestParam(required = false) List<String> sex,
        @RequestParam(required = false) List<String> season,
        @RequestParam(required = false) List<String> style,
        @RequestParam(required = false) List<String> color,
        @RequestParam(required = false, defaultValue = "false") Boolean nonActive
    ) {
        return outfitService.listOutfit(sex, season, style, color, nonActive);
    }

    @Override
    public GetOutfitClothes getOutfitClothesById(UUID id) {
        return outfitService.getOutfitClothesById(id);
    }

    @Override
    public OutfitIdResponse addOutfit(@Validated @RequestBody Outfit outfit) {
        Outfit savedOutfit = outfitService.addOutfit(outfit);
        return new OutfitIdResponse(savedOutfit.getOutfitId());
    }

    @Override
    public void addClothesToOutfit(@PathVariable UUID id, @RequestBody AddClothesRequest clothesRequest) {
        outfitService.addClothesToOutfit(id, clothesRequest);
    }

    @Override
    public void updateOutfitPatchById(@PathVariable UUID id, @RequestBody Outfit outfit) {
        outfitService.patchOutfitById(id, outfit);
    }

    @Override
    public void deleteOutfit(@PathVariable UUID id) {
        outfitService.deleteOutfitById(id);
    }

    @Override
    public void deleteClothingFromOutfit(UUID outfitId, DeleteClothingRequest request) {
        outfitService.deleteClothingFromOutfit(outfitId, request.getClothingId());
    }

}

