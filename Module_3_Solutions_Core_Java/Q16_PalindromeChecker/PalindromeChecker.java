import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine().toLowerCase().replaceAll("[^a-z0-9]", "");
        String rev = new StringBuilder(s).reverse().toString();
        System.out.println(s.equals(rev) ? "It is a palindrome." : "Not a palindrome.");
    }
}
