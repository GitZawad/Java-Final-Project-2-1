package FinanceApp.Models.Admin;

import static FinanceApp.Main.Main.scanner;
import static FinanceApp.Models.Admin.CategoryManagement.Expenditure.expenditureCategoryManagement;
import static FinanceApp.Models.Admin.CategoryManagement.Income.incomeCategoryManagement;
import static FinanceApp.Models.Admin.UserManagement.UserManagement.userManagement;

public class AdminMenu {
    public static void adminMenu() {
        while (true) {
            System.out.println("Please select the operation you wish to perform. To log out, please enter EXIT.");
            System.out.println("1. User management");
            System.out.println("2. Income category management");
            System.out.println("3. Expenditure category management");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                userManagement();
            } else if (choice.equals("2")) {
                incomeCategoryManagement();
            } else if (choice.equals("3")) {
                expenditureCategoryManagement();
            } else if (choice.equalsIgnoreCase("EXIT")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
