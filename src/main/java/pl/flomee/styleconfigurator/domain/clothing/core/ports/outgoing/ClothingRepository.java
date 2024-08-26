package pl.flomee.styleconfigurator.domain.clothing.core.ports.outgoing;

import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.domain.clothing.core.model.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClothingRepository {
    Optional<Clothing> findById(UUID id);

    List<Clothing> listClothing(ClothingPart clothingPart,
                                Shop shop,

                                List<Color> color
    );

    void save(Clothing clothing);

    void patchById(UUID id, Clothing clothing);

    void deleteById(UUID id);

    void deleteAll();

    List<Clothing> findAll();

    List<Clothing> saveAll(List<Clothing> clothes);
}
