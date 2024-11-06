package model;

public class BudgetAlert implements Observer {
    @Override
    public void update(String category, double currentSpending, double budget) {
        if (currentSpending > budget) {
            System.out.println("\nAlert! Spending in " + category + " exceeded budget. Current spending: $" + currentSpending);
        }
    }
}
