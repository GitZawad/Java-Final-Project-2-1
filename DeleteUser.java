package FinanceApp.Models.Admin.UserManagement;

import java.sql.*;

import static FinanceApp.Main.Main.connection;
import static FinanceApp.Main.Main.scanner;

public class DeleteUser {
    // Delete user
    static void deleteUser() {
        System.out.println("Enter user ID to delete:");
        String userId = scanner.nextLine();

        try {
            String query = "DELETE FROM users WHERE user_id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, userId);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("User deleted successfully!");
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
