package pl.flomee.styleconfigurator.domain.outfit.application.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetOutfitClothes {
    public List<Clothing> clothes;
}
