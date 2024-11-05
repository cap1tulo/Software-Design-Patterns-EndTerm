import model.ExpenseModel;
import view.ExpenseView;
import controller.ExpenseController;
import model.ExpenseFacade;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseModel model = new ExpenseModel();
        ExpenseView view = new ExpenseView();
        ExpenseFacade facade = new ExpenseFacade(model, view);
        ExpenseController controller = new ExpenseController(model, view);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Expense Tracking System ---");
            System.out.println("1. Set Budget");
            System.out.println("2. Add Expense");
            System.out.println("3. Show Expenses by Category");
            System.out.println("4. Show All Budgets");
            System.out.println("5. Generate Monthly Report");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter category (food/transport/personal): ");
                    String budgetCategory = scanner.nextLine().toLowerCase();
                    System.out.print("Enter budget amount: ");
                    double budgetAmount = scanner.nextDouble();
                    scanner.nextLine();
                    facade.setBudget(budgetCategory, budgetAmount);
                    break;

                case 2:
                    System.out.print("Enter category (food/transport/personal): ");
                    String expenseCategory = scanner.nextLine().toLowerCase();
                    System.out.print("Enter expense amount: ");
                    double expenseAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    facade.addExpense(expenseCategory, expenseAmount, description);
                    break;

                case 3:
                    System.out.print("Enter category to view (food/transport/personal): ");
                    String viewCategory = scanner.nextLine().toLowerCase();
                    System.out.println("\n--- " + viewCategory.substring(0, 1).toUpperCase() + viewCategory.substring(1) + " Expenses ---");
                    controller.showExpensesByCategory(viewCategory);
                    break;

                case 4:
                    System.out.println("\n--- Budgets ---");
                    view.displayBudgets(model.getFoodBudget(), model.getTransportBudget(), model.getPersonalBudget());
                    break;

                case 5:
                    System.out.println("\nGenerating Monthly Report...");
                    System.out.println(facade.generateReport("Monthly"));
                    break;

                case 6:
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

