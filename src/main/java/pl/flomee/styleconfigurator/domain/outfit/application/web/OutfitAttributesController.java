package pl.flomee.styleconfigurator.domain.outfit.application.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.incoming.OutfitService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/outfit/attributes")
@RequiredArgsConstructor
public class OutfitAttributesController implements IOutfitAttributesController {
    private final OutfitService outfitService;

    @Override
    public Map<String, List<String>> getCategories(@RequestParam(required = false, defaultValue = "EN") String language) {
        return outfitService.listFilters(language);
    }
}
