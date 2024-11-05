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
    public String generateReport(List<Expense> expenses) {
        double totalFoodExpense = 0;
        double totalTransportExpense = 0;
        double totalPersonalExpense = 0;

        // Calculate total expenses for each category
        for (Expense expense : expenses) {
            switch (expense.getCategory().toLowerCase()) {
                case "food":
                    totalFoodExpense += expense.getAmount();
                    break;
                case "transport":
                    totalTransportExpense += expense.getAmount();
                    break;
                case "personal":
                    totalPersonalExpense += expense.getAmount();
                    break;
            }
        }

        // Generate the report based on budget vs. expenses
        StringBuilder report = new StringBuilder("Monthly Report:\n");

        report.append(generateCategoryReport("Food", foodBudget, totalFoodExpense));
        report.append(generateCategoryReport("Transport", transportBudget, totalTransportExpense));
        report.append(generateCategoryReport("Personal", personalBudget, totalPersonalExpense));

        return report.toString();
    }

    // Helper method to generate report for a specific category
    private String generateCategoryReport(String category, double budget, double totalExpense) {
        StringBuilder categoryReport = new StringBuilder();
        double difference = budget - totalExpense;

        categoryReport.append(category).append(":\n")
                .append("  Budget: $").append(budget).append("\n")
                .append("  Total Expense: $").append(totalExpense).append("\n")
                .append("  Difference: $").append(difference).append("\n");

        if (difference < 0) {
            categoryReport.append("  Recommendation: You have exceeded the budget. Consider saving more and observing spending limits.\n\n");
        } else {
            categoryReport.append("  Praise: Great job! You stayed within the budget and managed your spending wisely.\n\n");
        }

        return categoryReport.toString();
    }
}
