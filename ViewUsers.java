package FinanceApp.Models.Admin.UserManagement;

import java.sql.*;

import static FinanceApp.Main.Main.connection;

public class ViewUsers {
    // View all users
    static void viewAllUsers() {
        try {
            String query = "SELECT user_id FROM users";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("User ID: " + rs.getString("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
