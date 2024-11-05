package model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseGroup implements ExpenseComponent {
    private String groupName;
    private List<ExpenseComponent> expenses = new ArrayList<>();

    public ExpenseGroup(String groupName) {
        this.groupName = groupName;
    }

    public void addExpense(ExpenseComponent expense) {
        expenses.add(expense);
    }

    @Override
    public double getAmount() {
        double total = 0;
        for (ExpenseComponent expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    @Override
    public void display() {
        System.out.println("Expense Group: " + groupName + " | Total Amount: $" + getAmount());
        for (ExpenseComponent expense : expenses) {
            expense.display();
        }
    }

    public List<ExpenseComponent> getExpenses() {
        return expenses;
    }

    // Method to calculate the total spending for a specific category
    public double getAmountByCategory(String category) {
        double total = 0;
        for (ExpenseComponent expense : expenses) {
            if (expense instanceof Expense && ((Expense) expense).getCategory().equalsIgnoreCase(category)) {
                total += expense.getAmount();
            }
        }
        return total;
    }
}
