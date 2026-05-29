// Note: Java Modules require separate source directories and module-info.java files.
// This file demonstrates the concept. Full setup:
// src/com.utils/module-info.java  -> module com.utils { exports com.utils; }
// src/com.utils/com/utils/Greeter.java
// src/com.greetings/module-info.java -> module com.greetings { requires com.utils; }
// src/com.greetings/com/greetings/Main.java

// Compile: javac --module-source-path src -d mods $(find src -name "*.java")
// Run:     java --module-path mods -m com.greetings/com.greetings.Main

public class JavaModules {
    public static void main(String[] args) {
        System.out.println("See comments for full Java Modules setup instructions.");
    }
}
