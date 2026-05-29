// After compiling: run -> javap -c JavapBytecode
public class JavapBytecode {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        JavapBytecode obj = new JavapBytecode();
        System.out.println("Sum: " + obj.add(3, 4));
        System.out.println("Compile this file and run: javap -c JavapBytecode");
    }
}
