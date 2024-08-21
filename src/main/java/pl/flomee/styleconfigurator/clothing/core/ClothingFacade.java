package pl.flomee.styleconfigurator.clothing.core;

import lombok.RequiredArgsConstructor;
import pl.flomee.styleconfigurator.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.clothing.core.ports.incoming.ClothingService;
import pl.flomee.styleconfigurator.clothing.core.ports.outgoing.ClothingRepository;

@RequiredArgsConstructor
public class ClothingFacade implements ClothingService {
    private final ClothingRepository clothingRepository;

    @Override
    public void addClothing(Clothing clothing) {
        clothingRepository.save(clothing);
    }
}
