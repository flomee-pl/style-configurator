package pl.flomee.styleconfigurator.clothing.application;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.flomee.styleconfigurator.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.clothing.core.ports.incoming.ClothingService;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clothing")
public class ClothingController {

    private final ClothingService clothingService;

    @PostMapping
    @ResponseStatus(OK)
    public void addClothing(@RequestBody Clothing clothing) {
        clothingService.addClothing(clothing);
    }
}
