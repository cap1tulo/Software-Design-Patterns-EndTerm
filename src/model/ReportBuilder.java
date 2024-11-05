package model;

import java.util.List;

public class ReportBuilder {
    private List<ExpenseComponent> expenses;
    private String period;

    public ReportBuilder(List<ExpenseComponent> expenses) {
        this.expenses = expenses;
    }

    public ReportBuilder setPeriod(String period) {
        this.period = period;
        return this;
    }

    public String build() {
        StringBuilder report = new StringBuilder("Expense Report");
        report.append("\nPeriod: ").append(period != null ? period : "All Time");

        for (ExpenseComponent expense : expenses) {
            if (expense instanceof Expense) {
                report.append("\n- ").append(((Expense) expense).getDescription())
                        .append(" | Category: ").append(((Expense) expense).getCategory())
                        .append(" | Amount: $").append(expense.getAmount());
            } else {
                expense.display();
            }
        }
        return report.toString();
    }
}
