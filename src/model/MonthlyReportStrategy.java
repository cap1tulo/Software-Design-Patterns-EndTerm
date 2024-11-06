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

        double totalFoodSpending = 0;
        double totalTransportSpending = 0;
        double totalPersonalSpending = 0;

        // Calculate total spending for each category
        for (ExpenseComponent expense : expenses) {
            if (expense instanceof Expense) {
                Expense exp = (Expense) expense;
                switch (exp.getCategory().toLowerCase()) {
                    case "food":
                        totalFoodSpending += exp.getAmount();
                        break;
                    case "transport":
                        totalTransportSpending += exp.getAmount();
                        break;
                    case "personal":
                        totalPersonalSpending += exp.getAmount();
                        break;
                }
            }
        }

        // Food category feedback
        report.append("\nFood:\n - Budget: $").append(foodBudget)
                .append("\n - Spent: $").append(totalFoodSpending);
        if (totalFoodSpending > foodBudget) {
            report.append("\n -> You spent more than planned in the Food category. Consider reducing your expenses.");
        } else {
            report.append("\n -> Good job! You are within your budget for Food.");
        }

        // Transport category feedback
        report.append("\n\nTransport:\n - Budget: $").append(transportBudget)
                .append("\n - Spent: $").append(totalTransportSpending);
        if (totalTransportSpending > transportBudget) {
            report.append("\n -> You spent more than planned in the Transport category. Try to save on transportation.");
        } else {
            report.append("\n -> Good job! You are within your budget for Transport.");
        }

        // Personal category feedback
        report.append("\n\nPersonal:\n - Budget: $").append(personalBudget)
                .append("\n - Spent: $").append(totalPersonalSpending);
        if (totalPersonalSpending > personalBudget) {
            report.append("\n -> You spent more than planned in the Personal category. Consider spending less.");
        } else {
            report.append("\n -> Great! You are within your budget for Personal expenses.");
        }

        return report.toString();
    }
}
