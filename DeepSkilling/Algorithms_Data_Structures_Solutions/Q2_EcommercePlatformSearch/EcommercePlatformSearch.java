// Exercise 2: E-commerce Platform Search Function


public class EcommercePlatformSearch {

   
    static class Product {
        int productId;
        String productName;
        String category;

        Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return "Product{id=" + productId + ", name='" + productName + "', category='" + category + "'}";
        }
    }


    // LINEAR SEARCH
    // Time Complexity:
    //   Best Case    : O(1)  - element found at index 0
    //   Average Case : O(n)  - element found somewhere in middle
    //   Worst Case   : O(n)  - element is last or not present
    // -------------------------------------------------------
    static int linearSearch(Product[] products, String targetName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(targetName)) {
                return i; // found at index i
            }
        }
        return -1; // not found
    }

 
    static int binarySearch(Product[] sortedProducts, String targetName) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sortedProducts[mid].productName.compareToIgnoreCase(targetName);

            if (cmp == 0) {
                return mid; // found
            } else if (cmp < 0) {
                low = mid + 1; // target is in the right half
            } else {
                high = mid - 1; // target is in the left half
            }
        }
        return -1; // not found
    }

    // Helper: sort array by productName using simple insertion sort
    static void sortByName(Product[] products) {
        for (int i = 1; i < products.length; i++) {
            Product key = products[i];
            int j = i - 1;
            while (j >= 0 && products[j].productName.compareToIgnoreCase(key.productName) > 0) {
                products[j + 1] = products[j];
                j--;
            }
            products[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        // Unsorted array for linear search
        Product[] products = {
            new Product(101, "Wireless Mouse",    "Electronics"),
            new Product(102, "Java Programming",  "Books"),
            new Product(103, "Office Chair",      "Furniture"),
            new Product(104, "Running Shoes",     "Sports"),
            new Product(105, "Bluetooth Speaker", "Electronics"),
            new Product(106, "Notebook",          "Stationery"),
            new Product(107, "Yoga Mat",          "Sports"),
            new Product(108, "Desk Lamp",         "Furniture"),
        };

        System.out.println("=== E-commerce Platform Search Function ===\n");

        // ---- Linear Search Demo ----
        System.out.println("--- Linear Search (unsorted array) ---");
        String target = "Running Shoes";
        int idx = linearSearch(products, target);
        if (idx != -1) {
            System.out.println("Found '" + target + "' at index " + idx + ": " + products[idx]);
        } else {
            System.out.println("'" + target + "' not found.");
        }

        target = "Laptop";
        idx = linearSearch(products, target);
        System.out.println("Search for '" + target + "': " + (idx != -1 ? "Found at index " + idx : "Not found"));

        // ---- Binary Search Demo ----
        System.out.println("\n--- Binary Search (sorted array) ---");

        // Copy and sort array
        Product[] sortedProducts = products.clone();
        sortByName(sortedProducts);

        System.out.println("Sorted product names:");
        for (Product p : sortedProducts) {
            System.out.println("  " + p.productName);
        }

        target = "Yoga Mat";
        idx = binarySearch(sortedProducts, target);
        System.out.println("\nSearch for '" + target + "': " + (idx != -1 ? "Found at index " + idx + " -> " + sortedProducts[idx] : "Not found"));

        target = "Keyboard";
        idx = binarySearch(sortedProducts, target);
        System.out.println("Search for '" + target + "': " + (idx != -1 ? "Found at index " + idx : "Not found"));

       
        System.out.println("\n--- Time Complexity Comparison ---");
        System.out.println("Algorithm       | Best    | Average  | Worst");
        System.out.println("----------------|---------|----------|---------");
        System.out.println("Linear Search   | O(1)    | O(n)     | O(n)");
        System.out.println("Binary Search   | O(1)    | O(log n) | O(log n)");
        System.out.println("\nConclusion: Binary Search is significantly faster for large sorted datasets.");
        System.out.println("For an unsorted or small dataset, Linear Search is simpler and sufficient.");
    }
}
