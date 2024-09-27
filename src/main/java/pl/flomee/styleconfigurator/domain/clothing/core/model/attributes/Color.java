package pl.flomee.styleconfigurator.domain.clothing.core.model.attributes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Color {
    public Long colorId;
    public String name;

}
