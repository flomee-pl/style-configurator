package pl.flomee.styleconfigurator.domain.outfit.application.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OutfitIdResponse {
    public UUID id;
}
