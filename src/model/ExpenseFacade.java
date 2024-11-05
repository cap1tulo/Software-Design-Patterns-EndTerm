package model;

import view.ExpenseView;

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

    // Updated method to generate a detailed monthly budget report with feedback
    public String generateMonthlyBudgetReport() {
        StringBuilder report = new StringBuilder("Monthly Budget Report:\n");

        // Food Category
        double foodBudget = model.getFoodBudget();
        double foodSpending = model.getMonthlyExpensesGroup().getAmountByCategory("food");
        report.append("\nFood:\n - Budget: $").append(foodBudget).append("\n - Spent: $").append(foodSpending);
        if (foodSpending > foodBudget) {
            report.append("\n -> You spent more than planned in the Food category. Consider reducing your expenses.");
        } else {
            report.append("\n -> Good job! You are within your budget for Food.");
        }

        // Transport Category
        double transportBudget = model.getTransportBudget();
        double transportSpending = model.getMonthlyExpensesGroup().getAmountByCategory("transport");
        report.append("\n\nTransport:\n - Budget: $").append(transportBudget).append("\n - Spent: $").append(transportSpending);
        if (transportSpending > transportBudget) {
            report.append("\n -> You spent more than planned in the Transport category. Try to save on transportation.");
        } else {
            report.append("\n -> Good job! You are within your budget for Transport.");
        }

        // Personal Category
        double personalBudget = model.getPersonalBudget();
        double personalSpending = model.getMonthlyExpensesGroup().getAmountByCategory("personal");
        report.append("\n\nPersonal:\n - Budget: $").append(personalBudget).append("\n - Spent: $").append(personalSpending);
        if (personalSpending > personalBudget) {
            report.append("\n -> You spent more than planned in the Personal category. Consider spending less.");
        } else {
            report.append("\n -> Great! You are within your budget for Personal expenses.");
        }

        return report.toString();
    }

    // Method to generate a report based on a custom strategy
    public String generateReport(ReportStrategy strategy) {
        return strategy.generateReport(model.getMonthlyExpensesGroup().getExpenses());
    }
}
