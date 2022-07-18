package com.cooking.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractControllerTest {


    @Autowired
    private WebApplicationContext wac;

    protected MockMvc mockMvc;
    protected final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    public abstract void testMustReturnCorrectObjectByGivenId() throws Exception;

    public abstract void testMustSuccesfullyReturnListOfObjects() throws Exception;

    public abstract void testMustDeleteObjectByGivenId() throws Exception;

    public abstract void testMustSuccessfullyPersistObjectByGivenData() throws Exception;

    public abstract void testMustSuccessfullyUpdatePersistedObject() throws Exception;

}