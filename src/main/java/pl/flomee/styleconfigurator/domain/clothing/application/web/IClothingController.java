package pl.flomee.styleconfigurator.domain.clothing.application.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pl.flomee.styleconfigurator.domain.clothing.application.web.request.AddOutfitsRequest;
import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.domain.clothing.core.model.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.OK;

@Tag(name = "Clothing", description = "API for managing clothing items")
@RequestMapping("/api/v1/clothing")
public interface IClothingController {

    @Operation(summary = "Get clothing by ID", description = "Retrieve a clothing item by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved clothing item",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Clothing.class))),
        @ApiResponse(responseCode = "404", description = "Clothing item not found")
    })
    @GetMapping("/{id}")
    @ResponseStatus(OK)
    Clothing getClothingById(@Parameter(description = "UUID of the clothing item", required = true)
                             @PathVariable UUID id);

    @Operation(summary = "List clothing", description = "Retrieve a list of clothing items filtered by parameters")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved list of clothing items",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Clothing.class)))
    })
    @GetMapping
    @ResponseStatus(OK)
    List<Clothing> listClothing(
        @Parameter(description = "Clothing part to filter by") @RequestParam(required = false) ClothingPart clothingPart,
        @Parameter(description = "Shop to filter by") @RequestParam(required = false) Shop shop,
        @Parameter(description = "Colors to filter by") @RequestParam(required = false) List<Color> color
    );

    @Operation(summary = "Add new clothing", description = "Create a new clothing item")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Clothing item created successfully")
    })
    @PostMapping
    @ResponseStatus(OK)
    void addClothing(@Parameter(description = "Details of the clothing item to be created", required = true)
                     @RequestBody Clothing clothing);

    @Operation(summary = "Add outfits to clothing", description = "Add outfits to an existing clothing item by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Outfits added to clothing item successfully"),
        @ApiResponse(responseCode = "404", description = "Clothing item not found")
    })
    @PostMapping("/{id}")
    @ResponseStatus(OK)
    void addOutfitsToClothing(@Parameter(description = "UUID of the clothing item", required = true)
                              @PathVariable UUID id,
                              @Parameter(description = "List of outfit IDs to be added to the clothing item", required = true)
                              @RequestBody AddOutfitsRequest outfits);

    @Operation(summary = "Update clothing item", description = "Patch an existing clothing item by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Clothing item updated successfully"),
        @ApiResponse(responseCode = "404", description = "Clothing item not found")
    })
    @PatchMapping("/{id}")
    @ResponseStatus(OK)
    void updateClothingPatchById(@Parameter(description = "UUID of the clothing item", required = true)
                                 @PathVariable UUID id,
                                 @Parameter(description = "Updated clothing item details", required = true)
                                 @RequestBody Clothing clothing);

    @Operation(summary = "Delete clothing item", description = "Delete an existing clothing item by its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Clothing item deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Clothing item not found")
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    void deleteClothing(@Parameter(description = "UUID of the clothing item", required = true)
                        @PathVariable UUID id);
}