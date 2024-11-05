package view;

import model.Expense;
import java.util.List;

public class ExpenseView {

    public void displayExpenses(List<Expense> expenses) {
        for (Expense expense : expenses) {
            System.out.println("Category: " + expense.getCategory() +
                    ", Amount: " + expense.getAmount() +
                    ", Description: " + expense.getDescription());
        }
    }

    public void displayBudgets(double foodBudget, double transportBudget, double personalBudget) {
        System.out.println("Food Budget: " + foodBudget);
        System.out.println("Transport Budget: " + transportBudget);
        System.out.println("Personal Budget: " + personalBudget);
    }
}
