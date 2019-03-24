package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void testGetCountry() {
        Country Country = app.getID(1);
        assertEquals(Country.name, "Kabul");
        assertEquals(Country.country_code, "AFG");
        assertEquals(Country.district, "Kabol");
        assertEquals(Country.population, "1780000");

    }
}





