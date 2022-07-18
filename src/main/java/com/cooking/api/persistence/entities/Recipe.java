package com.cooking.api.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.List;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Recipe extends AbstractPersistableEntity {

    private String instruction;

    private int servingAmount;

    private boolean vegetarian;

    @Fetch(FetchMode.JOIN)
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name="ingredient_recipe", joinColumns=@JoinColumn(name="recipe"), inverseJoinColumns=@JoinColumn(name="ingredient"))
    private List<Ingredient> ingredients;

}