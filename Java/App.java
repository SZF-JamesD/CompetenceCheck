import com.fasterxml.jackson.databind.ObjectMapper;
import utils.DBConnection;
import utils.DBHelpers;
import utils.DBInitializer;
import utils.JsonDataLoader;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public void start() {
        try{
            DBConnection dbConnection = new DBConnection("resources/config.properties");
            DBHelpers dbHelpers = new DBHelpers(dbConnection);

            Map<String, String> tableDefinitions = new HashMap<>();
            tableDefinitions.put("tablename1", "id int auto_increment primary key, etc");
            tableDefinitions.put("tablename2", "id int auto_increment primary key, etc");

            DBInitializer initializer = new DBInitializer(dbConnection, "myDbName");
            initializer.initialize(tableDefinitions);

            // instantiate services here
            // ie UserService userService = new UserService();
            //CompetenceCheckService checkService = new CompetenceCheckService();
            //ObjectMapper objectMapper = new ObjectMapper();
            //JsonDataLoader jsonDataLoader = new JsonDataLoader(objectMapper);
            //Map<String, List<Map<String, Object>>> data = jsonDataLoader.loadData("data.json")
            //Inject into controllers here
            //UserController userController = new UserController(userService)
            //CompCheckController checkController = new CompCheckController(checkService)

            //set up view if needed
            //ConsoleView view = new ConsoleView(userController, checkController);

            //start ui if needed
            //view.showWelcomeScreen();

            //otherwise in console do usual while(runnin) etc, menu in views, MenuView or soemthing
            //then like MainView view = MainView(Usercontroller)
            //view.start() , then start stuff inthe menu view
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }





    }
}
