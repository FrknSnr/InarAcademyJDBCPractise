package question1.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;

import question1.resources.DBUtils;
//import question1.utils.Driver;


public class Hooks {

    @Before
    public void setUp() {
        System.out.println("I am setting up the test from the Hooks class !");
    }

    @Before("@db")
    public void setUpDBConnection() {
        System.out.println("I am setting up the DB connection");
        DBUtils.createConnection();
    }
    @After("@db")
    public void tearDownDBConnection(){
        System.out.println("I am closing the DB Connection!");
        DBUtils.destroy();
    }
//    @After
//    public void tearDown(Scenario scenario){
//        System.out.println("I am reporting the results");
//        if (scenario.isFailed()){
//            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//        }
//        System.out.println("Closing driver");
//        Driver.closeDriver();
//    }
}
