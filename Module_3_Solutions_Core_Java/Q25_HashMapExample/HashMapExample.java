import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many entries? ");
        int n = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
            System.out.print("Name: "); String name = sc.nextLine();
            map.put(id, name);
        }
        System.out.print("Enter ID to search: ");
        int key = sc.nextInt();
        System.out.println(map.containsKey(key) ? "Name: " + map.get(key) : "Not found.");
    }
}
