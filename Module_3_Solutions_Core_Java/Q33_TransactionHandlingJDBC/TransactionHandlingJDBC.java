import java.sql.*;

public class TransactionHandlingJDBC {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:bank.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            conn.createStatement().execute("CREATE TABLE IF NOT EXISTS accounts (id INTEGER PRIMARY KEY, balance REAL)");
            conn.createStatement().execute("INSERT OR IGNORE INTO accounts VALUES (1, 1000.0),(2, 500.0)");
            conn.setAutoCommit(false);
            try {
                PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance=balance-? WHERE id=?");
                debit.setDouble(1, 200); debit.setInt(2, 1); debit.executeUpdate();
                PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance=balance+? WHERE id=?");
                credit.setDouble(1, 200); credit.setInt(2, 2); credit.executeUpdate();
                conn.commit();
                System.out.println("Transfer successful.");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transfer failed. Rolled back.");
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
