package FinanceApp.Models.User;

import static FinanceApp.Main.Main.scanner;
import static FinanceApp.Models.User.RecordManagement.CalculateBalance.calculateBalance;
import static FinanceApp.Models.User.RecordManagement.Expenditure.addExpenditureRecord;
import static FinanceApp.Models.User.RecordManagement.Income.addIncomeRecord;
import static FinanceApp.Models.User.RecordManagement.View.viewRecords;

public class UserMenu {
    // User menu
    public static void userMenu() {
        while (true) {
            System.out.println("1. Add income record");
            System.out.println("2. Add expenditure record");
            System.out.println("3. View records");
            System.out.println("4. Calculate total income, expenditure, and balance");
            System.out.println("5. Exit");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                addIncomeRecord();
            } else if (choice.equals("2")) {
                addExpenditureRecord();
            } else if (choice.equals("3")) {
                viewRecords();
            } else if (choice.equals("4")) {
                calculateBalance();
            } else if (choice.equals("5")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
