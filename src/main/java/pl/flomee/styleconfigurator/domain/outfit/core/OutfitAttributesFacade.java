package pl.flomee.styleconfigurator.domain.outfit.core;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Style;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.incoming.OutfitAttributesService;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.SeasonRepository;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.SexRepository;
import pl.flomee.styleconfigurator.domain.outfit.core.ports.outgoing.StyleRepository;

import java.util.List;

@RequiredArgsConstructor
public class OutfitAttributesFacade implements OutfitAttributesService {
    private final SeasonRepository seasonRepository;
    private final SexRepository sexRepository;
    private final StyleRepository styleRepository;

    @Override
    public List<Season> listSeasons() {
        return seasonRepository.findAll();
    }

    @Override
    public Season addSeason(Season season) {
        return seasonRepository.save(season);
    }

    @Override
    public void deleteSeasonById(Long id) {
        seasonRepository.deleteById(id);
    }

    @Override
    public List<Sex> listSexes() {
        return sexRepository.findAll();
    }

    @Override
    public Sex addSex(Sex sex) {
        return sexRepository.save(sex);
    }

    @Override
    public void deleteSexById(Long id) {
        sexRepository.deleteById(id);
    }

    @Override
    public List<Style> listStyles() {
        return styleRepository.findAll();
    }

    @Override
    public Style addStyle(Style style) {
        return styleRepository.save(style);
    }

    @Override
    public void deleteStyleById(Long id) {
        styleRepository.deleteById(id);
    }
}

