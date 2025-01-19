package FinanceApp.Main;

import java.sql.*;
import java.util.*;


import static FinanceApp.Models.Admin.AdminMenu.adminMenu;
import static FinanceApp.Models.User.UserMenu.userMenu;

public class Main {
    public static Connection connection;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize MySQL connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/finance_db", "root", "1234");
            System.out.println("Connected to MySQL Database.");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return;
        }

        // Admin account pre-setup
        // Add admin to the database if not already present
        try {
            String query = "INSERT IGNORE INTO users (user_id, password, role) VALUES ('001', '001', 'admin')";
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Main menu
        while (true) {
            System.out.println("Welcome to the finance assistant. Please select your role.");
            System.out.println("1. Administrator");
            System.out.println("2. User");
            String roleChoice = scanner.nextLine();

            if (roleChoice.equals("1")) {
                if (login("admin")) {
                    adminMenu();
                }
            } else if (roleChoice.equals("2")) {
                if (login("user")) {
                    userMenu();
                }
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

    // Login function
    private static boolean login(String role) {
        System.out.println("Please enter your account number:");
        String username = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        try {
            String query = "SELECT * FROM users WHERE user_id = ? AND password = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (role.equals("admin") && rs.getString("role").equals("admin")) {
                    System.out.println("Welcome Admin.");
                    return true;
                } else if (role.equals("user") && rs.getString("role").equals("user")) {
                    System.out.println("Welcome User.");
                    return true;
                } else {
                    System.out.println("Incorrect role.");
                    return false;
                }
            } else {
                System.out.println("Username or password is incorrect.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
