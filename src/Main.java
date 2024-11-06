import model.ExpenseModel;
import view.ExpenseView;
import controller.ExpenseController;
import model.BudgetAlert;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseModel model = new ExpenseModel();
        ExpenseView view = new ExpenseView();
        ExpenseController controller = new ExpenseController(model, view);

        // Add BudgetAlert as an observer to ExpenseModel
        BudgetAlert budgetAlert = new BudgetAlert();
        model.addObserver(budgetAlert);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Expense Tracking System ---");
            System.out.println("1. Set Budget");
            System.out.println("2. Add Expense");
            System.out.println("3. Show Monthly Expenses");
            System.out.println("4. Show Budget");
            System.out.println("5. Report for the Month");
            System.out.println("6. Category-Based Report");
            System.out.println("7. Exit");
            System.out.print("\nChoose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter category (food/transport/personal): ");
                    String budgetCategory = scanner.nextLine();
                    System.out.print("Enter budget amount: ");
                    double budgetAmount = scanner.nextDouble();
                    controller.setBudget(budgetCategory, budgetAmount);
                    break;

                case 2:
                    System.out.print("Enter category (food/transport/personal): ");
                    String expenseCategory = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    double expenseAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    controller.addExpense(expenseCategory, expenseAmount, description);
                    break;

                case 3:
                    controller.displayMonthlyExpenses();
                    break;

                case 4:
                    controller.displayAllBudgets();
                    break;

                case 5:
                    System.out.println(controller.generateMonthlyBudgetReport());
                    break;

                case 6:
                    System.out.println(controller.generateCategoryReport());
                    break;

                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
