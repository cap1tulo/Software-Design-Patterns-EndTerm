package model;

public class ExpenseFactory {
    public static Expense createExpense(String category, double amount, String description) {
        switch (category.toLowerCase()) {
            case "food":
                return new Expense("Food", amount, description);
            case "transport":
                return new Expense("Transport", amount, description);
            case "personal":
                return new Expense("Personal", amount, description);
            default:
                throw new IllegalArgumentException("Unknown category: " + category);
        }
    }
}
