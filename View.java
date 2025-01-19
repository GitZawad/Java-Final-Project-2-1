package FinanceApp.Models.User.RecordManagement;
import java.sql.*;

import static FinanceApp.Main.Main.connection;

public class View {
    // View records
    public static void viewRecords() {
        try {
            String query = "SELECT r.amount, r.record_date, c.name AS category FROM records r " +
                    "JOIN categories c ON r.category_id = c.category_id " +
                    "WHERE r.user_id = 'user01'"; // Assuming user01 for now

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            boolean hasRecords = false;
            while (rs.next()) {
                hasRecords = true;
                System.out.println("Category: " + rs.getString("category") +
                        ", Amount: " + rs.getDouble("amount") +
                        ", Date: " + rs.getString("record_date"));
            }

            if (!hasRecords) {
                System.out.println("No records available.");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching records: " + e.getMessage());
        }
    }
}
