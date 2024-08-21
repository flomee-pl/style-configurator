package pl.flomee.styleconfigurator.outfit.core.ports.outgoing;

import pl.flomee.styleconfigurator.outfit.core.model.Outfit;

public interface OutfitRepository {

    void saveOutfit(Outfit outfit);

}
