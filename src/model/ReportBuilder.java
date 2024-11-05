package model;

import java.util.List;

public class ReportBuilder {
    private List<Expense> expenses;
    private String period;

    public ReportBuilder(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public ReportBuilder setPeriod(String period) {
        this.period = period;
        return this;
    }

    public String build() {
        StringBuilder report = new StringBuilder("Expense Report");
        report.append("\nPeriod: ").append(period != null ? period : "All Time");
        for (Expense expense : expenses) {
            report.append("\n- ").append(expense.getCategory())
                    .append(": $").append(expense.getAmount())
                    .append(" (").append(expense.getDescription()).append(")");
        }
        return report.toString();
    }
}
