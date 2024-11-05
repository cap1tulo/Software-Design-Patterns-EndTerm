package model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseModel {
    private ExpenseGroup monthlyExpenses;
    private List<Observer> observers = new ArrayList<>();
    private double foodBudget;
    private double transportBudget;
    private double personalBudget;

    public ExpenseModel() {
        this.monthlyExpenses = new ExpenseGroup("Monthly Expenses");
    }

    public void addExpense(Expense expense) {
        monthlyExpenses.addExpense(expense);
        notifyObservers(expense);
    }

    public void setBudget(String category, double amount) {
        switch (category.toLowerCase()) {
            case "food": this.foodBudget = amount; break;
            case "transport": this.transportBudget = amount; break;
            case "personal": this.personalBudget = amount; break;
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(Expense expense) {
        double budget = switch (expense.getCategory()) {
            case "food" -> foodBudget;
            case "transport" -> transportBudget;
            case "personal" -> personalBudget;
            default -> 0;
        };
        double currentSpending = monthlyExpenses.getAmount();

        for (Observer observer : observers) {
            observer.update(expense.getCategory(), currentSpending, budget);
        }
    }

    public ExpenseGroup getMonthlyExpensesGroup() {
        return monthlyExpenses;
    }

    public double getFoodBudget() {
        return foodBudget;
    }

    public double getTransportBudget() {
        return transportBudget;
    }

    public double getPersonalBudget() {
        return personalBudget;
    }
}
