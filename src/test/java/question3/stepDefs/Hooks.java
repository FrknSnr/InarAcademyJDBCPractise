package question3.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import question3.resources.Utils;

import java.io.IOException;
import java.sql.SQLException;

public class Hooks {


    @Before
    public static void setUp(){
        System.out.println("Starting scenario");
    }

    @Before("@db")
    public static void beforeDB() throws SQLException, IOException {
        System.out.println("Creating connection");
        Utils.createConnection();
    }
    @After("@db")
    public static void afterDB() throws SQLException {
        System.out.println("Closing connection");
        Utils.destroy();
        System.out.println("---------------------------");
    }
}
