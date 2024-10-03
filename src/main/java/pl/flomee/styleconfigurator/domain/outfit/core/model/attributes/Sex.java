package pl.flomee.styleconfigurator.domain.outfit.core.model.attributes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Sex {
    public Long sexId;
    public String name;
    public String polishName;
}
