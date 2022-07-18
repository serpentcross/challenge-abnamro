package com.cooking.api.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public abstract class AbstractPersistableEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    public UUID id;

    protected String name;

}