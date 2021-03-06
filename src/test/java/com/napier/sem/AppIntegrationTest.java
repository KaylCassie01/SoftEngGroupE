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
        Country mycountry = app.getCountry("ABW");
        assertEquals(mycountry.name, "Aruba");
     //  assertEquals(mycountry.code, "AFG");
       // assertEquals(mycountry.region, "Kabol");
       // assertEquals(mycountry.population, "1780000");

    }
}





