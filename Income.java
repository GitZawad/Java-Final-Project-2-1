package FinanceApp.Models.User.RecordManagement;
import java.sql.*;

import static FinanceApp.Main.Main.connection;
import static FinanceApp.Main.Main.scanner;

public class Income {
    // Add income record
    public static void addIncomeRecord() {
        System.out.println("Enter category:");
        String category = scanner.nextLine();
        System.out.println("Enter amount:");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter date (yyyy-mm-dd):");
        String date = scanner.nextLine();

        try {
            // Check if category exists
            String query = "SELECT category_id FROM categories WHERE name = ? AND type = 'income'";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();

            int categoryId;
            if (rs.next()) {
                // Category exists, retrieve its ID
                categoryId = rs.getInt("category_id");
            } else {
                // Category does not exist, insert it
                String insertCategoryQuery = "INSERT INTO categories (name, type) VALUES (?, 'income')";
                PreparedStatement insertCategoryPs = connection.prepareStatement(insertCategoryQuery, Statement.RETURN_GENERATED_KEYS);
                insertCategoryPs.setString(1, category);
                insertCategoryPs.executeUpdate();

                ResultSet generatedKeys = insertCategoryPs.getGeneratedKeys();
                if (generatedKeys.next()) {
                    categoryId = generatedKeys.getInt(1);
                    System.out.println("Category added and ID retrieved: " + categoryId);
                } else {
                    System.out.println("Failed to add new category.");
                    return;
                }
            }

            // Add income record
            String insertQuery = "INSERT INTO records (user_id, category_id, amount, record_date) VALUES (?, ?, ?, ?)";
            PreparedStatement insertPs = connection.prepareStatement(insertQuery);
            insertPs.setString(1, "user01"); // Assuming user1 for now
            insertPs.setInt(2, categoryId);
            insertPs.setDouble(3, amount);
            insertPs.setDate(4, java.sql.Date.valueOf(date)); // Use java.sql.Date for DATE columns
            insertPs.executeUpdate();
            System.out.println("Income record added.");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
