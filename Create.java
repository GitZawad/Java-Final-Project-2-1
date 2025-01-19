package FinanceApp.Models.Admin.CategoryManagement;
import java.sql.*;


import static FinanceApp.Main.Main.connection;
import static FinanceApp.Main.Main.scanner;

public class Create {
    static void createCategory(String type) {
        System.out.println("Enter category name:");
        String categoryName = scanner.nextLine();

        try {
            String query = "INSERT INTO categories (name, type) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, categoryName);
            ps.setString(2, type);
            ps.executeUpdate();
            System.out.println("Category added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
