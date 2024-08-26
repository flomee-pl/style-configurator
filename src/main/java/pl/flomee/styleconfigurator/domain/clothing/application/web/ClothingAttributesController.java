package pl.flomee.styleconfigurator.domain.clothing.application.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.incoming.ClothingService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/clothing/attributes")
@RequiredArgsConstructor
public class ClothingAttributesController implements IClothingAttributesController {

    private final ClothingService clothingService;

    @Override
    public Map<String, List<String>> getCategories() {
        return clothingService.listFilters();
    }
}
