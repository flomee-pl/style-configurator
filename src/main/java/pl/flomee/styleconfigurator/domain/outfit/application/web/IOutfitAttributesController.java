package pl.flomee.styleconfigurator.domain.outfit.application.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Style;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Tag(name = "Outfit Attributes", description = "API for retrieving outfit attributes")
@RequestMapping("api/v1/outfit/attributes")
public interface IOutfitAttributesController {

    @GetMapping("/season")
    @ResponseStatus(OK)
    List<Season> getSeasons();

    @PostMapping("/season")
    @ResponseStatus(OK)
    Season addSeason(@RequestBody Season season);

    @DeleteMapping("/season/{id}")
    @ResponseStatus(OK)
    void deleteSeason(@PathVariable Long id);

    @GetMapping("/sex")
    @ResponseStatus(OK)
    List<Sex> getSexes();

    @PostMapping("/sex")
    @ResponseStatus(OK)
    Sex addSex(@RequestBody Sex sex);

    @DeleteMapping("/sex/{id}")
    @ResponseStatus(OK)
    void deleteSex(@PathVariable Long id);

    @GetMapping("/style")
    @ResponseStatus(OK)
    List<Style> getStyles();

    @PostMapping("/style")
    @ResponseStatus(OK)
    Style addStyle(@RequestBody Style style);

    @DeleteMapping("/style/{id}")
    @ResponseStatus(OK)
    void deleteStyle(@PathVariable Long id);


}
