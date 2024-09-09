package pl.flomee.styleconfigurator.domain.clothing.application.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.flomee.styleconfigurator.domain.outfit.core.model.Outfit;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetClothingOutfits {
    public List<Outfit> outfits;
}
