// Singleton Pattern - Logger Class


public class Logger {

    // Step 1: Private static instance of itself
    private static Logger instance;

    // Step 2: Private constructor to prevent instantiation from outside
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Step 3: Public static method to get the single instance (lazy initialization)
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Logging methods
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }

    public void warn(String message) {
        System.out.println("[WARN]: " + message);
    }

    public void error(String message) {
        System.out.println("[ERROR]: " + message);
    }
}
