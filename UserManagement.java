package FinanceApp.Models.Admin.UserManagement;

import static FinanceApp.Main.Main.scanner;
import static FinanceApp.Models.Admin.UserManagement.CreateUser.createUser;
import static FinanceApp.Models.Admin.UserManagement.DeleteUser.deleteUser;
import static FinanceApp.Models.Admin.UserManagement.ViewUsers.viewAllUsers;

public class UserManagement {
    // User management
    public static void userManagement() {
        System.out.println("1. Create user");
        System.out.println("2. Delete user");
        System.out.println("3. View all users");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            createUser();
        } else if (choice.equals("2")) {
            deleteUser();
        } else if (choice.equals("3")) {
            viewAllUsers();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
