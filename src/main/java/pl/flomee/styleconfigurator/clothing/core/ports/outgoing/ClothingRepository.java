package pl.flomee.styleconfigurator.clothing.core.ports.outgoing;

import pl.flomee.styleconfigurator.clothing.core.model.Clothing;

public interface ClothingRepository {
    void save(Clothing clothing);
}
