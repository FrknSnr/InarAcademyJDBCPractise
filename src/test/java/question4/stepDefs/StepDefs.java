package question4.stepDefs;
import io.cucumber.java.en.Given;
import question4.resources.Utils;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StepDefs {

    private static int count = 0;

    @Given("we are given {string} and {string}")
    public void weAreGivenAnd(String film_id, String title) throws SQLException {

        String query = "SELECT title,f.film_id FROM film f\n" +
                "INNER JOIN inventory i ON i.film_id = f.film_id\n" +
                "WHERE store_id = 1\n" +
                "GROUP BY title,f.film_id,store_id\n" +
                "HAVING COUNT(*) = (\n" +
                "\tSELECT COUNT(*) FROM FILM F\n" +
                "\tJOIN INVENTORY I ON I.FILM_ID = F.FILM_ID\n" +
                "\tWHERE STORE_ID = 1\n" +
                "\tGROUP BY title\n" +
                "\tORDER BY COUNT(*) DESC\n" +
                "\tLIMIT 1\n" +
                ")\n" +
                "ORDER BY f.film_id";

        List<Map<String, Object>> result = Utils.resultMap(query);
        String expectedTitle = result.get(count).get("title").toString();
        String expectedId = result.get(count).get("film_id").toString();

        System.out.println(expectedTitle + "   ------------   " + expectedId);

        assertEquals(expectedTitle.trim(), title);
        assertEquals(expectedId.trim(), film_id);

        count++;
    }
}
