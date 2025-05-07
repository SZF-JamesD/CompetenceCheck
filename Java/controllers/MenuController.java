package controllers;

import models.WorkOrder;
import services.InputHandler;
import services.MenuService;

import java.util.List;
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
        List<WorkOrder> list = menuService.getAllOrders();
        if (list.isEmpty()) {
            System.out.println("No work orders stored");
            return;
        }
        for (WorkOrder workOrder : list) {
            System.out.println(workOrder.toString());
        }
    }

    public void getOrder() {
        boolean running = true;
        while (running) {
            System.out.print("Enter the ID of the work order you wish to view or -1 to exit: ");
            try {

                int input = Integer.parseInt(sc.nextLine());
                if (input == -1){
                    running = false;
                    return;
                }
                WorkOrder order = menuService.getWorkOrder(input);
                if (order == null){
                    System.out.println("No work order with that id found");
                    continue;
                }
                System.out.println(order);
                running = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer.");
            }
        }
    }

    public void changeStatus() {
        boolean running = true;
        while (running) {
            System.out.print("Enter the ID of the work order you wish to edit or -1 to exit: ");
            try {
                int id = Integer.parseInt(sc.nextLine());
                if (id == -1){
                    running = false;
                    return;
                }
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
        List<WorkOrder> list = menuService.getFiltered(status);
        if (list.isEmpty()){
            System.out.println("No orders with that status");
            return;
        }
        for (WorkOrder workOrder : list) {
            System.out.println(workOrder.toString());
        }
    }
}
