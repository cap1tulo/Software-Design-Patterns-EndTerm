package view;

public class ExpenseView {
    public void displayBudgetUpdate(String category, double amount) {
        System.out.println("Budget for " + category + " set to $" + amount);
    }

    public void displayExpenseAdded(String category, double amount, String description) {
        System.out.println("Added expense: " + description + " | Category: " + category + " | Amount: $" + amount);
    }
}
