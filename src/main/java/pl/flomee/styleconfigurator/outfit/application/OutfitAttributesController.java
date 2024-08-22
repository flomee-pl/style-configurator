package pl.flomee.styleconfigurator.outfit.application;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.flomee.styleconfigurator.outfit.core.ports.incoming.OutfitService;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/outfit/attributes")
@RequiredArgsConstructor
public class OutfitAttributesController {
    private final OutfitService outfitService;

    @GetMapping
    @ResponseStatus(OK)
    public Map<String, List<String>> getCategories() {
        return outfitService.listFilters();
    }
}
