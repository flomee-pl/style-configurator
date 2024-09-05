package pl.flomee.styleconfigurator.domain.clothing.application.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@Tag(name = "Clothing Attributes", description = "API for retrieving clothing attributes")
@RequestMapping("api/v1/clothing/attributes")
public interface IClothingAttributesController {

    @Operation(summary = "Get available clothing categories",
        description = "Retrieve a list of available clothing categories such as colors, shops, and clothing parts",
        parameters = {
            @Parameter(name = "language", description = "Language of the category names (PL/EN)", required = false)
        })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved categories",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class)))
    })
    @GetMapping
    @ResponseStatus(OK)
    Map<String, List<String>> getCategories(@RequestParam(required = false, defaultValue = "EN") String language);
}