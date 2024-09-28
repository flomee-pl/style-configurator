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

    @GetMapping("/seasons")
    @ResponseStatus(OK)
    List<Season> getSeasons();

    @PostMapping("/seasons")
    @ResponseStatus(OK)
    Season addSeason(@RequestBody Season season);

    @DeleteMapping("/seasons/{id}")
    @ResponseStatus(OK)
    void deleteSeason(@PathVariable Long id);

    @GetMapping("/sexes")
    @ResponseStatus(OK)
    List<Sex> getSexes();

    @PostMapping("/sexes")
    @ResponseStatus(OK)
    Sex addSex(@RequestBody Sex sex);

    @DeleteMapping("/sexes/{id}")
    @ResponseStatus(OK)
    void deleteSex(@PathVariable Long id);

    @GetMapping("/styles")
    @ResponseStatus(OK)
    List<Style> getStyles();

    @PostMapping("/styles")
    @ResponseStatus(OK)
    Style addStyle(@RequestBody Style style);

    @DeleteMapping("/styles/{id}")
    @ResponseStatus(OK)
    void deleteStyle(@PathVariable Long id);


}
