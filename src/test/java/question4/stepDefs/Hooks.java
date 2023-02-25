package question4.stepDefs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import question4.resources.Utils;
import java.io.IOException;
import java.sql.SQLException;

public class Hooks {

    @Before
    public void set() {
        System.out.println("I am starting the scenario!");
    }

    @Before("@db")
    public void beforeDB() throws SQLException, IOException {
        System.out.println("Connection is setting up");
        Utils.setConnection();
    }

    @After("@db")
    public void closeEverything() throws SQLException {
        System.out.println("Closing connection.");
        Utils.destroy();
    }

    @After
    public void finish() {
        System.out.println("Test ended successfully!");
        System.out.println("--------------------------------");
    }
}
