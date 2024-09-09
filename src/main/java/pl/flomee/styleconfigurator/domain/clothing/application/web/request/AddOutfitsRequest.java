package pl.flomee.styleconfigurator.domain.clothing.application.web.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOutfitsRequest {
    private List<UUID> outfitIds;
}
