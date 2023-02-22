package question2.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import question2.resources.Utils;

import java.sql.SQLException;

public class Hooks {


    @Before
    public static void setUp(){
        System.out.println("Setting up the scenario.");
    }

    @Before("@db")
    public static void beforeDB() throws SQLException {
        System.out.println("I am setting up the db connection.");
        Utils.createConnection();
    }


    @After("@db")
    public static void afterDB() throws SQLException {
        System.out.println("I am closing the db connection.");
        System.out.println("--------------------------------------------------");
        Utils.destroyDBConnection();
    }
}
