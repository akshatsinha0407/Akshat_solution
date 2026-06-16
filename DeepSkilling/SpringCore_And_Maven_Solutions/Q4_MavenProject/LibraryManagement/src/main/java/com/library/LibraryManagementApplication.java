package com.library;

/**
 * Exercise 4: Creating and Configuring a Maven Project
 *
 * This class demonstrates that the project is correctly set up with
 * Spring Context, Spring AOP, and Spring WebMVC dependencies.
 * Run `mvn dependency:tree` to verify all dependencies are resolved.
 */
public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("=== Exercise 4: Maven Project Configuration ===");
        System.out.println("Maven project created with:");
        System.out.println("  - spring-context 5.3.30");
        System.out.println("  - spring-aop     5.3.30");
        System.out.println("  - spring-webmvc  5.3.30");
        System.out.println("  - maven-compiler-plugin configured for Java 1.8");
        System.out.println("Run: mvn dependency:tree to verify all dependencies.");
    }
}
