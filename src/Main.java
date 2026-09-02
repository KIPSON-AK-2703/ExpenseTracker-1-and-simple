import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> expenses = new ArrayList<>();
    static ArrayList<Double> amounts = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addExpense();
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    calculateTotal();
                    break;

                case 4:
                    deleteExpense();
                    break;

                case 5:
                    System.out.println("Thank you for using Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void addExpense() {

        System.out.print("Enter expense name: ");
        String name = scanner.nextLine();

        System.out.print("Enter amount: ₹");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        expenses.add(name);
        amounts.add(amount);

        System.out.println("Expense added successfully!");
    }

    static void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses available.");
            return;
        }

        System.out.println("\n----- YOUR EXPENSES -----");

        for (int i = 0; i < expenses.size(); i++) {
            System.out.println((i + 1) + ". "
                    + expenses.get(i)
                    + " - ₹" + amounts.get(i));
        }
    }

    static void calculateTotal() {

        double total = 0;

        for (double amount : amounts) {
            total += amount;
        }

        System.out.println("Total Expense: ₹" + total);
    }

    static void deleteExpense() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses to delete.");
            return;
        }

        viewExpenses();

        System.out.print("Enter expense number to delete: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (number >= 1 && number <= expenses.size()) {

            expenses.remove(number - 1);
            amounts.remove(number - 1);

            System.out.println("Expense deleted successfully!");

        } else {
            System.out.println("Invalid expense number!");
        }
    }
}