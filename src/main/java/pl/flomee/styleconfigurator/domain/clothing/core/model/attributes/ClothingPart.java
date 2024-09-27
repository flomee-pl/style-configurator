package pl.flomee.styleconfigurator.domain.clothing.core.model.attributes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClothingPart {
    public Long clothingPartId;
    public String name;

}
