package pl.flomee.styleconfigurator.domain.outfit.core.ports.incoming;

import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Style;

import java.util.List;

public interface OutfitAttributesService {
    List<Season> listSeasons();
    Season addSeason(Season season);
    void deleteSeasonById(Long id);

    List<Sex> listSexes();
    Sex addSex(Sex sex);
    void deleteSexById(Long id);

    List<Style> listStyles();
    Style addStyle(Style style);
    void deleteStyleById(Long id);

}
