package model;

import java.util.ArrayList;
import java.util.List;

public class ExpenseGroup extends Expense {
    private List<Expense> expenses = new ArrayList<>();

    public ExpenseGroup(String category) {
        super(category, 0, "");
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}
