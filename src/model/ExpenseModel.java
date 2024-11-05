package model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseModel {
    private List<Expense> expenses = new ArrayList<>();
    private double foodBudget;
    private double transportBudget;
    private double personalBudget;

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public List<Expense> getExpensesByCategory(String category) {
        List<Expense> categorizedExpenses = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                categorizedExpenses.add(expense);
            }
        }
        return categorizedExpenses;
    }

    public void setBudget(String category, double amount) {
        switch (category.toLowerCase()) {
            case "food": this.foodBudget = amount; break;
            case "transport": this.transportBudget = amount; break;
            case "personal": this.personalBudget = amount; break;
        }
    }

    public double getFoodBudget() { return foodBudget; }
    public double getTransportBudget() { return transportBudget; }
    public double getPersonalBudget() { return personalBudget; }
}
