// Compile this file, then open the .class in JD-GUI or run:
// java -jar cfr.jar DecompileClassFile.class
public class DecompileClassFile {
    private int secret = 42;

    public String getMessage() {
        return "The secret is: " + secret;
    }

    public static void main(String[] args) {
        System.out.println(new DecompileClassFile().getMessage());
    }
}
