package pl.flomee.styleconfigurator.domain.outfit.application.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import pl.flomee.styleconfigurator.domain.outfit.application.web.request.AddClothesRequest;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Season;
import pl.flomee.styleconfigurator.domain.outfit.core.model.Outfit;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Sex;
import pl.flomee.styleconfigurator.domain.outfit.core.model.attributes.Style;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@Tag(name = "Outfit", description = "API for managing outfits")
public interface IOutfitController {

    @Operation(summary = "Get an outfit by ID", description = "Retrieve details of an outfit by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Outfit found",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Outfit.class))),
        @ApiResponse(responseCode = "404", description = "Outfit not found")
    })
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    Outfit getOutfit(@Parameter(description = "ID of the outfit to retrieve", required = true) @PathVariable UUID id);

    @Operation(summary = "List outfits", description = "List all outfits or filter by sex, season, and style")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of outfits",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Outfit.class)))
    })
    @GetMapping
    @ResponseStatus(OK)
    List<Outfit> listOutfit(
        @Parameter(description = "Filter by sex") @RequestParam(required = false) Sex sex,
        @Parameter(description = "Filter by season") @RequestParam(required = false) List<Season> season,
        @Parameter(description = "Filter by style") @RequestParam(required = false) List<Style> style
    );

    @Operation(summary = "Add a new outfit", description = "Create a new outfit")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Outfit created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping
    @ResponseStatus(OK)
    void addOutfit(
        @Parameter(description = "Details of the outfit to create", required = true) @Validated @RequestBody Outfit outfit);

    @Operation(summary = "Add clothes to an outfit by ID", description = "Add clothes to an existing outfit by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Clothes added to outfit successfully"),
        @ApiResponse(responseCode = "404", description = "Outfit not found")
    })
    @PostMapping("{id}")
    @ResponseStatus(OK)
    void addClothesToOutfit(
        @Parameter(description = "ID of the outfit to add clothes to", required = true) @PathVariable UUID id,
        @Parameter(description = "List of clothes IDs to be added to outfit item", required = true) @RequestBody AddClothesRequest clothes);

    @Operation(summary = "Update an outfit by ID", description = "Update specific details of an existing outfit by its ID, it overwrites the existing data")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Outfit updated successfully"),
        @ApiResponse(responseCode = "404", description = "Outfit not found")
    })
    @PatchMapping("/{id}")
    @ResponseStatus(OK)
    void updateOutfitPatchById(
        @Parameter(description = "ID of the outfit to update", required = true) @PathVariable UUID id,
        @Parameter(description = "Details to update", required = true) @Validated @RequestBody Outfit outfit);

    @Operation(summary = "Delete an outfit by ID", description = "Delete an outfit by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Outfit deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Outfit not found")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    void deleteOutfit(
        @Parameter(description = "ID of the outfit to delete", required = true) @PathVariable UUID id);
}