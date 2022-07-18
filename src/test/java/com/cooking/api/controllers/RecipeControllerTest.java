package com.cooking.api.controllers;

import com.cooking.api.decorators.RecipeDecorator;
import com.cooking.api.dto.IngredientDto;
import com.cooking.api.dto.RecipeDto;

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

@WebMvcTest(RecipeController.class)
public class RecipeControllerTest extends AbstractControllerTest {

    @MockBean
    private RecipeDecorator recipeDecorator;

    @Test
    @Override
    public void testMustReturnCorrectObjectByGivenId() throws Exception {

        given(recipeDecorator.getOne(any(UUID.class))).willReturn(
            objectMapper.readValue(new ClassPathResource("mocks/recipe/recipe.json").getFile(), RecipeDto.class)
        );

        mockMvc
            .perform(get("/recipes/{id}", "58a5822a-06ef-4b58-93cc-26761ea5a203")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding(StandardCharsets.UTF_8))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(jsonPath("$.name").value("Vegetarian cutlets"))
            .andExpect(jsonPath("$.instruction").value("Tomato, Cabbage, Nuts"))
            .andExpect(jsonPath("$.servingAmount").value(6))
            .andExpect(jsonPath("$.vegetarian").value(true))
            .andExpect(jsonPath("$.ingredients[0].name").value("Tomato"))
            .andExpect(jsonPath("$.ingredients[1].name").value("Cabbage"))
            .andExpect(jsonPath("$.ingredients[2].name").value("Nuts"));
        ;
    }

    @Test
    @Override
    public void testMustSuccesfullyReturnListOfObjects() throws Exception {

        given(recipeDecorator.getAll(null, null, null, null)).willReturn(
            objectMapper.readValue(new ClassPathResource("mocks/recipe/recipes.json").getFile(), new TypeReference<>() {})
        );

        mockMvc
            .perform(get("/recipes")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding(StandardCharsets.UTF_8))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(jsonPath("$", hasSize(5)))
            .andExpect(jsonPath("$[0].name").value("Caesar Salad"))
            .andExpect(jsonPath("$[0].vegetarian").value(false))
            .andExpect(jsonPath("$[1].name").value("Meatballs Spaghetti"))
            .andExpect(jsonPath("$[1].vegetarian").value(false))
            .andExpect(jsonPath("$[2].name").value("Vitamin salad"))
            .andExpect(jsonPath("$[2].vegetarian").value(true))
            .andExpect(jsonPath("$[3].name").value("Boiled potato"))
            .andExpect(jsonPath("$[3].vegetarian").value(true))
            .andExpect(jsonPath("$[4].name").value("Fried rice"))
            .andExpect(jsonPath("$[4].vegetarian").value(true));

    }

    @Test
    public void testMustSuccesfullyReturnFilteredObjects() throws Exception {

        given(recipeDecorator.getAll(true, 2, null, null)).willReturn(
            objectMapper.readValue(new ClassPathResource("mocks/recipe/recipes_filtered.json").getFile(), new TypeReference<>() {})
        );

        mockMvc
            .perform(get("/recipes")
            .param("vegetarian", "true")
            .param("servings", "2")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding(StandardCharsets.UTF_8))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].name").value("Vitamin salad"))
            .andExpect(jsonPath("$[0].vegetarian").value(true))
            .andExpect(jsonPath("$[1].name").value("Fried rice"))
            .andExpect(jsonPath("$[1].vegetarian").value(true));

    }

    @Test
    @Override
    public void testMustDeleteObjectByGivenId() throws Exception {

        doNothing().when(recipeDecorator).deleteOne(any(UUID.class));

        mockMvc
            .perform(delete("/recipes/{id}", "278eac50-02ae-482d-9c05-4fcef2e468ef")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding(StandardCharsets.UTF_8))
            .andExpect(status().isNoContent());

        verify(recipeDecorator, times(1)).deleteOne(any(UUID.class));
        verifyNoMoreInteractions(recipeDecorator);

    }

    @Test

    @Override
    public void testMustSuccessfullyPersistObjectByGivenData() throws Exception {

        RecipeDto recipeDto = objectMapper.readValue(new ClassPathResource("mocks/recipe/recipe_new.json").getFile(), RecipeDto.class);

        given(recipeDecorator.createOne(any(RecipeDto.class))).willReturn(recipeDto);

        mockMvc
            .perform(post("/recipes")
            .content("\n" +
                "  {\n" +
                "    \"name\": \"Carrot soup.\",\n" +
                "    \"instruction\": \"Cook from water, potato and carrot.\",\n" +
                "    \"servingAmount\": 6,\n" +
                "    \"ingredients\": [\n" +
                "      {\n" +
                "        \"id\": \"21cde316-87fc-432f-9440-c999386890c0\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"d9d83e87-8c34-4959-a2e0-672304b6a0d7\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding(StandardCharsets.UTF_8))
            .andExpect(status().isCreated());

        verify(recipeDecorator, times(1)).createOne(any(RecipeDto.class));
        verifyNoMoreInteractions(recipeDecorator);

    }

    @Test
    @Override
    public void testMustSuccessfullyUpdatePersistedObject() throws Exception {

        RecipeDto recipeDto = objectMapper.readValue(new ClassPathResource("mocks/recipe/recipe_updated.json").getFile(), RecipeDto.class);

        given(recipeDecorator.updateOne(any(UUID.class), any(RecipeDto.class))).willReturn(recipeDto);

        mockMvc
            .perform(put("/recipes/{id}", "fb13f32d-7c14-4048-a517-d6d3dbf2d528")
            .content("{\n" +
                    "  \"name\": \"Beef soup.\",\n" +
                    "  \"instruction\": \"Cook from water, potato and beef.\",\n" +
                    "  \"servingAmount\": 4,\n" +
                    "  \"ingredients\": [\n" +
                    "    {\n" +
                    "      \"id\": \"3534fa81-4d88-43fe-bf01-6ee2deef3987\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"id\": \"d9d83e87-8c34-4959-a2e0-672304b6a0d7\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding(StandardCharsets.UTF_8))
            .andExpect(status().isOk())
            .andDo(print());
    }

}
