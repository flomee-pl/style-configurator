package pl.flomee.styleconfigurator.domain.outfit.application.web.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddClothesRequest {
    private List<UUID> clothesIds;
}
