package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void greetWithName() {
        assertEquals("Hello, Jenkins!", App.greet("Jenkins"));
    }

    @Test
    void greetBlankFallsBack() {
        assertEquals("Hello, world!", App.greet("  "));
    }

    @Test
    void addNumbers() {
        assertEquals(5, App.add(2, 3));
    }
}
