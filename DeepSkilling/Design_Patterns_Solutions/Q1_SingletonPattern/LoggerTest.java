// Test class to verify the Singleton Pattern implementation
// Demonstrates that only one instance of Logger is created

public class LoggerTest {

    public static void main(String[] args) {

        // Retrieve instance 1
        Logger logger1 = Logger.getInstance();
        logger1.log("Application started.");

        // Retrieve instance 2
        Logger logger2 = Logger.getInstance();
        logger2.warn("This is a warning.");

        // Retrieve instance 3
        Logger logger3 = Logger.getInstance();
        logger3.error("This is an error.");

        // Verify all references point to the same instance
        System.out.println("\n--- Singleton Verification ---");
        System.out.println("logger1 == logger2 : " + (logger1 == logger2));
        System.out.println("logger2 == logger3 : " + (logger2 == logger3));
        System.out.println("logger1 == logger3 : " + (logger1 == logger3));

        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("\nSingleton Pattern verified: Only ONE instance exists!");
        }
    }
}
