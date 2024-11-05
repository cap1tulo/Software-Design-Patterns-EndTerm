package model;

import java.util.List;

public class CategoryReportStrategy implements ReportStrategy {
    @Override
    public String generateReport(List<ExpenseComponent> expenses) {
        StringBuilder report = new StringBuilder("Category-Based Expense Report:\n");
        for (ExpenseComponent expense : expenses) {
            expense.display();
        }
        return report.toString();
    }
}
