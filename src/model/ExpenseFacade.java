package model;

import view.ExpenseView;
import java.util.List;

public class ExpenseFacade {
    private ExpenseModel model;
    private ExpenseView view;

    public ExpenseFacade(ExpenseModel model, ExpenseView view) {
        this.model = model;
        this.view = view;
    }

    public void addExpense(String category, double amount, String description) {
        Expense expense = ExpenseFactory.createExpense(category, amount, description);
        model.addExpense(expense);
        view.displayExpenses(List.of(expense));
    }

    public void setBudget(String category, double amount) {
        model.setBudget(category, amount);
        view.displayBudgets(model.getFoodBudget(), model.getTransportBudget(), model.getPersonalBudget());
    }

    public String generateReport(String period) {
        ReportStrategy reportStrategy;

        if ("Monthly".equalsIgnoreCase(period)) {
            // Pass the budgets from ExpenseModel to MonthlyReportStrategy
            reportStrategy = new MonthlyReportStrategy(
                    model.getFoodBudget(),
                    model.getTransportBudget(),
                    model.getPersonalBudget()
            );
        } else {
            reportStrategy = new CategoryReportStrategy();
        }

        return reportStrategy.generateReport(model.getAllExpenses());
    }
}
