package view;

public class ExpenseView {
    public void displayBudgetUpdate(String category, double amount) {
        System.out.println("\nBudget for " + category + " set to $" + amount);
    }

    public void displayExpenseAdded(String category, double amount, String description) {
        System.out.println("\nAdded expense: " + description + " | Category: " + category + " | Amount: $" + amount);
    }
}
