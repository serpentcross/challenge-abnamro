package com.cooking.api.controllers;

import com.cooking.api.decorators.IngredientDecorator;
import com.cooking.api.dto.IngredientDto;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;

import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IngredientController.class)
public class IngredientControllerTest extends AbstractControllerTest {

    @MockBean
    private IngredientDecorator ingredientDecorator;

    @Test
    @Override
    public void testMustReturnCorrectObjectByGivenId() throws Exception {

        given(ingredientDecorator.getOne(any(UUID.class))).willReturn(
            objectMapper.readValue(new ClassPathResource("mocks/ingredient/ingredient.json").getFile(), IngredientDto.class)
        );

        mockMvc
            .perform(get("/ingredients/{id}", "ab02d219-5b8f-43c5-970e-3373f904423b")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding(StandardCharsets.UTF_8))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Noodles"))
            .andExpect(jsonPath("$.vegetable").value(false))
            .andDo(print());

    }

    @Test
    @Override
    public void testMustSuccesfullyReturnListOfObjects() throws Exception {

        given(ingredientDecorator.getAll()).willReturn(
            objectMapper.readValue(new ClassPathResource("mocks/ingredient/ingredients.json").getFile(), new TypeReference<>() {})
        );

        mockMvc
            .perform(get("/ingredients")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding(StandardCharsets.UTF_8))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(5)))
            .andExpect(jsonPath("$[0].name").value("Yogurt"))
            .andExpect(jsonPath("$[0].vegetable").value(false))
            .andExpect(jsonPath("$[1].name").value("Beans"))
            .andExpect(jsonPath("$[1].vegetable").value(true))
            .andExpect(jsonPath("$[2].name").value("Carrot"))
            .andExpect(jsonPath("$[2].vegetable").value(true))
            .andExpect(jsonPath("$[3].name").value("Chicken"))
            .andExpect(jsonPath("$[3].vegetable").value(false))
            .andDo(print());

    }

    @Test
    @Override
    public void testMustDeleteObjectByGivenId() throws Exception {

        doNothing().when(ingredientDecorator).deleteOne(any(UUID.class));

        mockMvc
            .perform(delete("/ingredients/{id}", "b6a94103-605a-463e-910e-a1eb518dd55e")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding(StandardCharsets.UTF_8))
            .andExpect(status().isNoContent())
            .andDo(print());

        verify(ingredientDecorator, times(1)).deleteOne(any(UUID.class));
        verifyNoMoreInteractions(ingredientDecorator);

    }

    @Test
    @Override
    public void testMustSuccessfullyPersistObjectByGivenData() throws Exception {

        mockMvc
            .perform(post("/ingredients")
            .param("name", "Garlic")
            .param("vegetable", "true")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding(StandardCharsets.UTF_8))
            .andExpect(status().isCreated())
            .andDo(print());

        verify(ingredientDecorator, times(1)).createOne(any(String.class), any(Boolean.class));
        verifyNoMoreInteractions(ingredientDecorator);

    }

    @Test
    @Override
    public void testMustSuccessfullyUpdatePersistedObject() throws Exception {

        IngredientDto ingredientDto = objectMapper.readValue(new ClassPathResource("mocks/ingredient/ingredient_updated.json").getFile(), IngredientDto.class);

        given(ingredientDecorator.updateOne(any(UUID.class), any(IngredientDto.class))).willReturn(ingredientDto);

        mockMvc
            .perform(put("/ingredients/{id}", "ab02d219-5b8f-43c5-970e-3373f904423b")
            .content("{\n" +
                    "  \"id\": \"ab02d219-5b8f-43c5-970e-3373f904423b\",\n" +
                    "  \"name\": \"Peas\",\n" +
                    "  \"vegetable\" : true\n" +
                    "}")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding(StandardCharsets.UTF_8))
            .andExpect(status().isOk())
            .andDo(print());

    }

}