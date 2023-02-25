package question5.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import question5.resources.Utils;

import java.sql.SQLException;

public class Hooks {

    @Before
    public static void set(){
        System.out.println("Processing...");
    }
    @Before("@db")
    public static void beforeDB() throws SQLException {
        System.out.println("Starting 'db'");
        Utils.setConnection();
    }
    @After("@db")
    public static void afterDB() throws SQLException {
        System.out.println("Closing the connection");
        Utils.close();
    }
    @After
    public static void close(){
        System.out.println("Scenario executed");
    }
}
