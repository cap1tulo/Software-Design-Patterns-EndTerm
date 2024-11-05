package model;

import java.util.List;

public class MonthlyReportStrategy implements ReportStrategy {
    private double foodBudget;
    private double transportBudget;
    private double personalBudget;

    public MonthlyReportStrategy(double foodBudget, double transportBudget, double personalBudget) {
        this.foodBudget = foodBudget;
        this.transportBudget = transportBudget;
        this.personalBudget = personalBudget;
    }

    @Override
    public String generateReport(List<ExpenseComponent> expenses) {
        StringBuilder report = new StringBuilder("Monthly Expense Report:\n");
        for (ExpenseComponent expense : expenses) {
            expense.display();
        }
        return report.toString();
    }
}
