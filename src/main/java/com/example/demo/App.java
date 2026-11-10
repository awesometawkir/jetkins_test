package com.example.demo;

/**
 * Tiny demo app used as a Jenkins + Maven + JDK learning sample.
 */
public class App {
    public static void main(String[] args) {
        System.out.println(greet("Jenkins"));
    }

    public static String greet(String name) {
        if (name == null || name.isBlank()) {
            return "Hello, world!";
        }
        return "Hello, " + name + "!";
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
