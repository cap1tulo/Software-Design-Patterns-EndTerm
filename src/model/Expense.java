package model;

public class Expense implements ExpenseComponent {
    private String category;
    private double amount;
    private String description;

    public Expense(String category, double amount, String description) {
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void display() {
        System.out.println("Expense: " + description + " | Category: " + category + " | Amount: $" + amount);
    }
}
