import java.lang.reflect.*;

public class ReflectionInJava {
    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("ReflectionInJava");
        System.out.println("Methods in " + cls.getName() + ":");
        for (Method m : cls.getDeclaredMethods()) {
            System.out.println(" - " + m.getName() + "(" + 
                java.util.Arrays.toString(m.getParameterTypes()) + ")");
        }
        Object obj = cls.getDeclaredConstructor().newInstance();
        Method greet = cls.getMethod("greet", String.class);
        greet.invoke(obj, "Reflection");
    }
}
