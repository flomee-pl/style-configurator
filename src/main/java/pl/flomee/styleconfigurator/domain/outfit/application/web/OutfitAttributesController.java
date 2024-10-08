package pl.flomee.styleconfigurator.domain.outfit.application.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Style;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.incoming.OutfitAttributesService;

import java.util.List;

@RestController
@RequestMapping("api/v1/outfit/attributes")
@RequiredArgsConstructor
public class OutfitAttributesController implements IOutfitAttributesController {
    private final OutfitAttributesService outfitAttributesService;

    @Override
    public List<Season> getSeasons() {
        return outfitAttributesService.listSeasons();
    }

    @Override
    public Season addSeason(Season season) {
        return outfitAttributesService.addSeason(season);
    }

    @Override
    public void deleteSeason(Long id) {
        outfitAttributesService.deleteSeasonById(id);
    }

    @Override
    public List<Sex> getSexes() {
        return outfitAttributesService.listSexes();
    }

    @Override
    public Sex addSex(Sex sex) {
        return outfitAttributesService.addSex(sex);
    }

    @Override
    public void deleteSex(Long id) {
        outfitAttributesService.deleteSexById(id);
    }

    @Override
    public List<Style> getStyles() {
        return outfitAttributesService.listStyles();
    }

    @Override
    public Style addStyle(Style style) {
        return outfitAttributesService.addStyle(style);
    }

    @Override
    public void deleteStyle(Long id) {
        outfitAttributesService.deleteStyleById(id);
    }
}
