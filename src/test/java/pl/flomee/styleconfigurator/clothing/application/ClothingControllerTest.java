package pl.flomee.styleconfigurator.clothing.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.flomee.styleconfigurator.domain.clothing.application.web.ClothingController;
import pl.flomee.styleconfigurator.domain.clothing.core.model.Clothing;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.ClothingPart;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Color;
import pl.flomee.styleconfigurator.domain.clothing.core.model.attributes.Shop;
import pl.flomee.styleconfigurator.domain.clothing.core.ports.incoming.ClothingService;
import pl.flomee.styleconfigurator.domain.clothing.infrastructure.repository.jpa.ClothingJpaRepositoryAdapter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClothingController.class)
class ClothingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClothingJpaRepositoryAdapter clothingJpaRepositoryAdapter;

    @MockBean
    ClothingService clothingService;

    @BeforeEach
    void setUp() {

    }


    @Test
    void getClothingById() throws Exception {
        Clothing testClothing = clothingJpaRepositoryAdapter.findAll().get(0);

        given(clothingService.getClothingById(testClothing.getClothingId())).willReturn(Optional.of(testClothing));

        mockMvc.perform(get("/api/v1/clothing/{clothingId}", testClothing.getClothingId())
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.clothingId", is(testClothing.getClothingId().toString())))
            .andExpect(jsonPath("$.link", is(testClothing.getLink())));
    }

    @Test
    void getClothingByIdNotFound() throws Exception {

        given(clothingService.getClothingById(any(UUID.class))).willReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/clothing/{clothingId}", UUID.randomUUID()))
            .andExpect(status().isNotFound());

    }

    @Test
    void listClothing() {
    }

    @Test
    void addClothing() {
    }

    @Test
    void updateClothingPatchById() {
    }

    @Test
    void deleteClothing() {
    }
}