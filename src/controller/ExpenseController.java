package controller;

import model.ExpenseModel;
import model.ExpenseFacade;
import view.ExpenseView;
import model.ReportStrategy;
import model.CategoryReportStrategy;

public class ExpenseController {
    private ExpenseModel model;
    private ExpenseView view;
    private ExpenseFacade facade;

    public ExpenseController(ExpenseModel model, ExpenseView view) {
        this.model = model;
        this.view = view;
        this.facade = new ExpenseFacade(model, view);
    }

    public void addExpense(String category, double amount, String description) {
        facade.addExpense(category, amount, description);
    }

    public void setBudget(String category, double amount) {
        facade.setBudget(category, amount);
    }

    public void displayMonthlyExpenses() {
        facade.displayMonthlyExpenses();
    }

    public void displayAllBudgets() {
        facade.displayAllBudgets();
    }

    public String generateMonthlyBudgetReport() {
        return facade.generateMonthlyBudgetReport();  // Calls report with MonthlyReportStrategy and ReportBuilder
    }

    public String generateCategoryReport() {
        ReportStrategy strategy = new CategoryReportStrategy();
        return facade.generateReport(strategy);
    }
}
