package pl.flomee.styleconfigurator.clothing.core.ports.outgoing;

import pl.flomee.styleconfigurator.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.clothing.core.model.ClothingPart;
import pl.flomee.styleconfigurator.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.clothing.core.model.attributes.Shop;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClothingRepository {
    void save(Clothing clothing);

    Optional<Clothing> findById(UUID id);

    void deleteById(UUID id);

    void patchById(UUID id, Clothing clothing);

    List<Clothing> listClothing(ClothingPart clothingPart,
                                Shop shop,

                                List<Color> color
    );

}
