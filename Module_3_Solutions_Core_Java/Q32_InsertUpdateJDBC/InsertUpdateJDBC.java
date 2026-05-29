import java.sql.*;

public class InsertUpdateJDBC {
    static class StudentDAO {
        Connection conn;
        StudentDAO(Connection conn) { this.conn = conn; }

        void insert(int id, String name, String grade) throws SQLException {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO students VALUES (?, ?, ?)");
            ps.setInt(1, id); ps.setString(2, name); ps.setString(3, grade);
            ps.executeUpdate();
        }

        void update(int id, String newGrade) throws SQLException {
            PreparedStatement ps = conn.prepareStatement("UPDATE students SET grade=? WHERE id=?");
            ps.setString(1, newGrade); ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db")) {
            conn.createStatement().execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT, grade TEXT)");
            StudentDAO dao = new StudentDAO(conn);
            dao.insert(3, "Charlie", "C");
            dao.update(3, "B");
            System.out.println("Insert and update successful.");
        }
    }
}
