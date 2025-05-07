package views;

import controllers.MenuController;

import java.util.Scanner;

public class MenuView {
    private final Scanner sc;
    private final MenuController menuController;

    public MenuView(Scanner sc, MenuController menuController) {
        this.sc = sc;
        this.menuController = menuController;
    }

    public void runMenu() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> menuController.addWorkOrder();
                case "2" -> menuController.getAllOrders();
                case "3" -> menuController.getOrder();
                case "4" -> menuController.changeStatus();
                case "5" -> menuController.filterByStatus();
                case "6" -> {
                    System.out.println("Exiting...");
                    running = false;
                }
                default -> System.out.println("Invalid choice, please enter 1 - 6.");
                }
                sc.nextLine();
            }
        }

    private void printMenu() {
        System.out.println("\n---Work Order Management System---" +
                "\n1. Create New Work Order" +
                "\n2. View All Work Orders" +
                "\n3. View Work Order Details" +
                "\n4. Change Work Order Status" +
                "\n5. Display Orders by Status" +
                "\n6. Exit");
        System.out.print("Enter your Choice: ");
    }
}
