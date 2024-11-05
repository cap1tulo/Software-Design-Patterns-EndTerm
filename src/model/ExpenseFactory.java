package model;

public class ExpenseFactory {
    public static Expense createExpense(String category, double amount, String description) {
        return new Expense(category, amount, description);
    }
}
