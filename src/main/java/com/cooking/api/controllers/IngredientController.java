package com.cooking.api.controllers;

import com.cooking.api.decorators.IngredientDecorator;
import com.cooking.api.dto.IngredientDto;
import com.cooking.api.exceptions.ExceptionDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientDecorator ingredientDecorator;

    @Operation(
        operationId = "one",
        summary = "Get one ingredient by given id.",
        tags = { "ingredient-controller" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Operation was successful!", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientDto.class)),
                @Content(mediaType = "*/*", schema = @Schema(implementation = IngredientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Error! One or several parameters do not match proper values!", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class)),
                @Content(mediaType = "*/*", schema = @Schema(implementation = ExceptionDto.class))
            }),
            @ApiResponse(responseCode = "404", description = "Error! No entity was found by given identifier!", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class)),
                @Content(mediaType = "*/*", schema = @Schema(implementation = ExceptionDto.class))
            })
        }
    )
    @GetMapping("/{id}")
    public IngredientDto one(@PathVariable UUID id) throws Exception {
        return ingredientDecorator.getOne(id);
    }

    @Operation(
        operationId = "all",
        summary = "Get all available ingredients.",
        tags = { "ingredient-controller" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Operation was successful!", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientDto.class)),
                @Content(mediaType = "*/*", schema = @Schema(implementation = IngredientDto.class))
            }),
            @ApiResponse(responseCode = "204", description = "Unfortunately, nothing was found!", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)),
                @Content(mediaType = "*/*", schema = @Schema(implementation = String.class))
            })
        }
    )
    @GetMapping
    public List<IngredientDto> all() {
        return ingredientDecorator.getAll();
    }

    @Operation(
        operationId = "create",
        summary = "Create one ingredient by given name.",
        tags = { "ingredient-controller" },
        responses = {
            @ApiResponse(responseCode = "201", description = "An item has been created!", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientDto.class)),
                @Content(mediaType = "*/*", schema = @Schema(implementation = IngredientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Error! One or several parameters do not match proper values!", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class)),
                @Content(mediaType = "*/*", schema = @Schema(implementation = ExceptionDto.class))
            }),
            @ApiResponse(responseCode = "409", description = "Error! Given name already exists!", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class)),
                @Content(mediaType = "*/*", schema = @Schema(implementation = ExceptionDto.class))
            })
        }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IngredientDto create(@RequestParam String name, @RequestParam boolean vegetable) {
        return ingredientDecorator.createOne(name, vegetable);
    }

    @Operation(
        operationId = "delete",
        summary = "Delete one ingredient by given id.",
        tags = { "ingredient-controller" },
        responses = {
            @ApiResponse(responseCode = "204", description = "An item has been deleted!", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientDto.class)),
                @Content(mediaType = "*/*", schema = @Schema(implementation = IngredientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Error! One or several parameters do not match proper values!", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class)),
                @Content(mediaType = "*/*", schema = @Schema(implementation = ExceptionDto.class))
            }),
            @ApiResponse(responseCode = "409", description = "Error! Given id is used in another entity!", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class)),
                @Content(mediaType = "*/*", schema = @Schema(implementation = ExceptionDto.class))
            })
        }
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        ingredientDecorator.deleteOne(id);
    }

    @Operation(
        operationId = "update",
        summary = "Update one ingredient by given name and id.",
        tags = { "ingredient-controller" },
        responses = {
            @ApiResponse(responseCode = "200", description = "An item has been created!", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = IngredientDto.class)),
                @Content(mediaType = "*/*", schema = @Schema(implementation = IngredientDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Error! One or several parameters do not match proper values!", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class)),
                @Content(mediaType = "*/*", schema = @Schema(implementation = ExceptionDto.class))
            }),
            @ApiResponse(responseCode = "409", description = "Error! Given name already exists!", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class)),
                @Content(mediaType = "*/*", schema = @Schema(implementation = ExceptionDto.class))
            })
        }
    )
    @PutMapping("/{id}")
    public IngredientDto update(@PathVariable UUID id, @RequestBody IngredientDto ingredientDto) {
        return ingredientDecorator.updateOne(id, ingredientDto);
    }

}