package model;

public interface Observer {
    void update(String category, double currentSpending, double budget);
}
