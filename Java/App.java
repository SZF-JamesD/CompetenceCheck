import controllers.MenuController;
import utils.DBConnection;
import utils.DBHelpers;
import utils.DBInitializer;
import utils.ValidationUtil;
import utils.InputHelper;
import views.MenuView;
import services.*;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public void start() {
        try{
            DBConnection dbConnection = new DBConnection("resources/config.properties");
            DBHelpers dbHelpers = new DBHelpers(dbConnection);

            Map<String, String> tableDefinitions = new HashMap<>();
            tableDefinitions.put("work_orders",
                    "id int auto_increment primary key, " +
                    "title text not null, " +
                    "description text not null, " +
                    "status varchar(11) not null default 'OPEN', " +
                    "date_created date, " +
                    "priority int");

            DBInitializer initializer = new DBInitializer(dbConnection, "work_orders_db");
            initializer.initialize(tableDefinitions);

            Scanner sc = new Scanner(System.in);
            ValidationUtil validationUtil = new ValidationUtil();
            InputHelper inputHelper = new InputHelper(sc);

            MenuService menuService = new MenuService(dbHelpers);
            InputHandler inputHandler = new InputHandler(validationUtil, inputHelper);

            MenuController menuController = new MenuController(menuService, inputHandler, sc);


            MenuView menuView = new MenuView(sc, menuController);

            menuView.runMenu();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }





    }
}
