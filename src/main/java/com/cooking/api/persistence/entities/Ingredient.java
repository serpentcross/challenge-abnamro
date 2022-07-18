package com.cooking.api.persistence.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
public class Ingredient extends AbstractPersistableEntity {
    private boolean vegetable;
}