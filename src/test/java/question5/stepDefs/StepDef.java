package question5.stepDefs;

import io.cucumber.java.en.Given;
import question5.resources.Utils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StepDef {


    @Given("we are given the count {int}")
    public void we_are_given_the_count(int number) throws SQLException {
        String query = "SELECT COUNT(*) FROM(\n" +
                "SELECT COUNT(*) FROM film f\n" +
                "INNER JOIN inventory i ON i.film_id = f.film_id\n" +
                "WHERE store_id = 2\n" +
                "GROUP BY title\n" +
                "HAVING COUNT(*) = 3\n" +
                "ORDER BY title) AS movies \n";

        String count = number + "";
        List<Map<String, Object>> result = Utils.getResultList(query);
        String expectedCount = result.get(0).get("count").toString();
        System.out.println("------ "+expectedCount+" ------");
        assertEquals(expectedCount, count);

    }
}
