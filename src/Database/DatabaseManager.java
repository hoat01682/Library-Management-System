package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseManager {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library_management";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public static int getTotalBooks() {
        String query = "SELECT COUNT(*) AS total_books FROM book;";
        return executeCountQuery(query);
    }

    public static int getTotalMembers() {
        String query = "SELECT COUNT(*) AS total FROM member";
        return executeCountQuery(query);
    }

    public static int getIssuedBooks() {
        String query = "SELECT COUNT(*) AS total FROM borrowticket WHERE status='Đã trả hết'";
        return executeCountQuery(query);
    }

    public static double getAverageBooksPerMember() {
        String query = "SELECT AVG(book_count) AS avg_books_per_member \r\n" + //
                        "FROM (\r\n" + //
                        "    SELECT COUNT(*) AS book_count \r\n" + //
                        "    FROM borrowticket \r\n" + //
                        "    GROUP BY member_id\r\n" + //
                        ") AS subquery;";
        return executeDoubleQuery(query);
    }

    public static int getMaxBooksBorrowed() {
        String query = "SELECT MAX(book_count) AS max_books_borrowed \r\n" + //
                        "FROM (\r\n" + //
                        "    SELECT COUNT(*) AS book_count \r\n" + //
                        "    FROM borrowticket \r\n" + //
                        "    GROUP BY member_id\r\n" + //
                        ") AS subquery;";
        return executeIntQuery(query);
    }

    public static int getMinBooksBorrowed() {
        String query = "SELECT MIN(book_count) AS min_books_borrowed \r\n" + //
                        "FROM (\r\n" + //
                        "    SELECT COUNT(*) AS book_count \r\n" + //
                        "    FROM borrowticket \r\n" + //
                        "    GROUP BY member_id\r\n" + //
                        ") AS subquery;";
        return executeIntQuery(query);
    }

    public static double getAverageBorrowDuration() {
        String query = "SELECT AVG(DATEDIFF(return_date, borrow_date)) AS average_duration \r\n" + //
                        "FROM borrowtickets \r\n" + //
                        "WHERE status='Đã trả';'";
        return executeDoubleQuery(query);
    }

    // Helper methods
    private static int executeCountQuery(String query) {
        int count = 0;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
             
            if (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    private static double executeDoubleQuery(String query) {
        double result = 0.0;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
             
            if (rs.next()) {
                result = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static int executeIntQuery(String query) {
        int result = 0;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
             
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}