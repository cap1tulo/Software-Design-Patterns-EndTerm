package controller;

import model.ExpenseModel;
import view.ExpenseView;
import model.Expense;

import java.util.List;

public class ExpenseController {
    private ExpenseModel model;
    private ExpenseView view;

    public ExpenseController(ExpenseModel model, ExpenseView view) {
        this.model = model;
        this.view = view;
    }

    public void addExpense(String category, double amount, String description) {
        Expense expense = new Expense(category, amount, description);
        model.addExpense(expense);
        updateView();
    }

    public void setBudget(String category, double amount) {
        model.setBudget(category, amount);
        updateView();
    }

    public void showExpensesByCategory(String category) {
        List<Expense> expenses = model.getExpensesByCategory(category);
        view.displayExpenses(expenses);
    }

    private void updateView() {
        view.displayBudgets(model.getFoodBudget(), model.getTransportBudget(), model.getPersonalBudget());
    }
}
