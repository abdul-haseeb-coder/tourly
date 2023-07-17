import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    private String description;
    private double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}

class ExpenseTracker {
    private List<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public void printExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("Expense List:");
        System.out.println("--------------");

        for (Expense expense : expenses) {
            System.out.println("Description: " + expense.getDescription());
            System.out.println("Amount: $" + expense.getAmount());
            System.out.println("--------------");
        }
    }

    public double calculateTotalExpense() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ExpenseTracker expenseTracker = new ExpenseTracker();

            while (true) {
                System.out.println("Expense Tracker");
                System.out.println("1. Add Expense");
                System.out.println("2. View Expenses");
                System.out.println("3. Calculate Total Expense");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character from the buffer

                switch (choice) {
                    case 1:
                        System.out.print("Enter expense description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter expense amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Clear the newline character from the buffer
                        Expense expense = new Expense(description, amount);
                        expenseTracker.addExpense(expense);
                        System.out.println("Expense added successfully!");
                        System.out.println();
                        break;

                    case 2:
                        expenseTracker.printExpenses();
                        System.out.println();
                        break;

                    case 3:
                        double totalExpense = expenseTracker.calculateTotalExpense();
                        System.out.println("Total Expense: $" + totalExpense);
                        System.out.println();
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        System.out.println();
                        break;
                }
            }
        }
    }
}
