// Exercise 7: Financial Forecasting
// Demonstrates recursive algorithm to predict future values based on past growth rates
// Also includes memoization optimization to avoid redundant computation

import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    // -------------------------------------------------------
    // RECURSIVE APPROACH (plain recursion)
    // Calculates the future value after 'years' periods,
    // given an initial principal and an annual growth rate.
    //
    // Formula (compound interest / growth):
    //   futureValue(principal, rate, n) =
    //       principal                          if n == 0
    //       futureValue(principal, rate, n-1) * (1 + rate)   otherwise
    //
    // Time Complexity : O(n)  – one recursive call per year
    // Space Complexity: O(n)  – call stack depth equals n
    // -------------------------------------------------------
    static double futureValueRecursive(double principal, double rate, int years) {
        if (years == 0) {
            return principal; // base case
        }
        return futureValueRecursive(principal, rate, years - 1) * (1 + rate);
    }

    // -------------------------------------------------------
    // OPTIMIZED APPROACH — Memoization (Top-Down DP)
    // Stores already-computed results so sub-problems are not
    // recalculated.  Useful when the same year's value is
    // needed multiple times across different queries.
    //
    // Time Complexity : O(n)  – each sub-problem computed once
    // Space Complexity: O(n)  – memo table + call stack
    // -------------------------------------------------------
    static Map<Integer, Double> memo = new HashMap<>();

    static double futureValueMemo(double principal, double rate, int years) {
        if (years == 0) return principal;
        if (memo.containsKey(years)) return memo.get(years);

        double result = futureValueMemo(principal, rate, years - 1) * (1 + rate);
        memo.put(years, result);
        return result;
    }

    // -------------------------------------------------------
    // ITERATIVE APPROACH (for comparison / reference)
    // Time Complexity : O(n)
    // Space Complexity: O(1)  – no stack overhead
    // -------------------------------------------------------
    static double futureValueIterative(double principal, double rate, int years) {
        double value = principal;
        for (int i = 0; i < years; i++) {
            value *= (1 + rate);
        }
        return value;
    }

    // Print a year-by-year forecast table using recursion
    static void printForecastTable(double principal, double rate, int totalYears) {
        System.out.printf("%-6s %-20s%n", "Year", "Projected Value ($)");
        System.out.println("-------------------------------");
        for (int y = 0; y <= totalYears; y++) {
            double val = futureValueRecursive(principal, rate, y);
            System.out.printf("%-6d %-20.2f%n", y, val);
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Financial Forecasting Tool ===\n");

        double principal  = 10_000.0;  // initial investment
        double growthRate = 0.08;      // 8% annual growth rate
        int    years      = 10;

        // ---- Recursive result ----
        System.out.printf("Principal   : $%.2f%n", principal);
        System.out.printf("Growth Rate : %.0f%%%n", growthRate * 100);
        System.out.printf("Projection  : %d years%n%n", years);

        double recursive = futureValueRecursive(principal, growthRate, years);
        System.out.printf("Recursive  result after %d years : $%.2f%n", years, recursive);

        // ---- Memoized result ----
        memo.clear();
        double memoized = futureValueMemo(principal, growthRate, years);
        System.out.printf("Memoized   result after %d years : $%.2f%n", years, memoized);

        // ---- Iterative result ----
        double iterative = futureValueIterative(principal, growthRate, years);
        System.out.printf("Iterative  result after %d years : $%.2f%n%n", years, iterative);

        // ---- Year-by-year table ----
        System.out.println("--- Year-by-Year Forecast (Recursive) ---");
        printForecastTable(principal, growthRate, years);

        // ---- Complexity Analysis ----
        System.out.println("\n--- Time & Space Complexity Analysis ---");
        System.out.println("Approach     | Time  | Space | Notes");
        System.out.println("-------------|-------|-------|-----------------------------");
        System.out.println("Recursive    | O(n)  | O(n)  | Simple; stack overflow risk for large n");
        System.out.println("Memoization  | O(n)  | O(n)  | Avoids re-computation; safe for repeated queries");
        System.out.println("Iterative    | O(n)  | O(1)  | Most efficient; best for large n");

        System.out.println("\nOptimization tip: For large forecasting periods, use the iterative");
        System.out.println("approach or switch to the closed-form formula: FV = P * (1+r)^n");
        System.out.printf("Closed-form  result after %d years : $%.2f%n",
                years, principal * Math.pow(1 + growthRate, years));
    }
}
