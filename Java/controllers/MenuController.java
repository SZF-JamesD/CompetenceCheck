package controllers;

import models.WorkOrder;
import services.InputHandler;
import services.MenuService;
import java.util.Scanner;

public class MenuController {
    private final MenuService menuService;
    private final InputHandler inputHandler;
    private final Scanner sc;

    public MenuController(MenuService menuService, InputHandler inputHandler, Scanner sc) {
        this.menuService = menuService;
        this.inputHandler = inputHandler;
        this.sc = sc;
    }

    public void addWorkOrder() {
        String title = inputHandler.checkWorkOrderTitle();
        String description = inputHandler.checkDescription();
        String status = inputHandler.checkStatus();
        int priority = inputHandler.checkPrio();
        menuService.createOrder(title, description, status, priority);
    }

    public void getAllOrders() {
        for (WorkOrder workOrder : menuService.getAllOrders()) {
            System.out.println(workOrder.toString());
        }
    }

    public void getOrder() {
        boolean running = true;
        while (running) {
            System.out.print("Enter the ID of the work order you wish to view: ");
            try {
                int input = Integer.parseInt(sc.nextLine());
                System.out.println(menuService.getWorkOrder(input));
                running = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer.");
            }
        }
    }

    public void changeStatus() {
        boolean running = true;
        while (running) {
            System.out.print("Enter the ID of the work order you wish to edit: ");
            try {
                int id = Integer.parseInt(sc.nextLine());
                String status = inputHandler.checkStatus();
                menuService.changeStatus(id, status);
                System.out.println("Status changed successfully.");

                running = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid ID.");
            }
        }
    }

    public void filterByStatus() {
        String status = inputHandler.checkStatus();
        for (WorkOrder workOrder : menuService.getFiltered(status)) {
            System.out.println(workOrder.toString());
        }
    }
}
