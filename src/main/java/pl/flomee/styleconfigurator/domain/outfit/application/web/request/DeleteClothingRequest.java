package pl.flomee.styleconfigurator.domain.outfit.application.web.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteClothingRequest {
    private UUID clothingId;
}
