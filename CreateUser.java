package FinanceApp.Models.Admin.UserManagement;

import java.sql.*;


import static FinanceApp.Main.Main.connection;
import static FinanceApp.Main.Main.scanner;

public class CreateUser {
    static void createUser() {
        System.out.println("Enter new user ID:");
        String userId = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        try {
            String query = "INSERT INTO users (user_id, password, role) VALUES (?, ?, 'user')";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, userId);
            ps.setString(2, password);
            ps.executeUpdate();
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
