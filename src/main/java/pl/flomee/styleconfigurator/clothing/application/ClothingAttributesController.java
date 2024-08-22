package pl.flomee.styleconfigurator.clothing.application;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.flomee.styleconfigurator.clothing.core.ports.incoming.ClothingService;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/v1/clothing/attributes")
@RequiredArgsConstructor
public class ClothingAttributesController {

    private final ClothingService clothingService;

    @GetMapping
    @ResponseStatus(OK)
    public Map<String, List<String>> getCategories() {
        return clothingService.listFilters();
    }
}
