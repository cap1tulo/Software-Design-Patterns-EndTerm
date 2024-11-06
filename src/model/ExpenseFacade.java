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
        view.displayExpenseAdded(category, amount, description);
    }

    public void setBudget(String category, double amount) {
        model.setBudget(category, amount);
        view.displayBudgetUpdate(category, amount);
    }

    public void displayMonthlyExpenses() {
        System.out.println("Monthly Expenses Report:");
        model.getMonthlyExpensesGroup().display();
    }

    public void displayAllBudgets() {
        System.out.println("Budgets for All Categories:");
        System.out.println("Food Budget: $" + model.getFoodBudget());
        System.out.println("Transport Budget: $" + model.getTransportBudget());
        System.out.println("Personal Budget: $" + model.getPersonalBudget());
    }

    // Updated method to generate a structured monthly report with budget feedback
    public String generateMonthlyBudgetReport() {
        // Use ReportBuilder to create a structured report of expenses for the current month
        ReportBuilder reportBuilder = new ReportBuilder(model.getMonthlyExpensesGroup().getExpenses());
        reportBuilder.setPeriod("Current Month");
        String expenseListReport = reportBuilder.build();

        // Use MonthlyReportStrategy to analyze and generate feedback on budget vs. spending
        MonthlyReportStrategy strategy = new MonthlyReportStrategy(
                model.getFoodBudget(),
                model.getTransportBudget(),
                model.getPersonalBudget()
        );
        String budgetFeedbackReport = strategy.generateReport(model.getMonthlyExpensesGroup().getExpenses());

        // Combine the expense list report and the budget feedback
        return expenseListReport + "\n\n" + budgetFeedbackReport;
    }

    // Method to generate a report based on a custom strategy, used by the Category-Based Report
    public String generateReport(ReportStrategy strategy) {
        return strategy.generateReport(model.getMonthlyExpensesGroup().getExpenses());
    }
}
