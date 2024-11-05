package model;

import java.util.List;

public interface ReportStrategy {
    String generateReport(List<ExpenseComponent> expenses);
}
