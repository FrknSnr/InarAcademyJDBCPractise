package question1.stepDefinitions;

import io.cucumber.java.en.Given;
import question1.utils.DBUtils;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Question1Steps {

    String query = " SELECT c.customer_id, c.first_name, c.last_name, ci.city, co.country,SUM(amount)\n" +
            "FROM customer c\n" +
            "INNER JOIN address a ON c.address_id = a.address_id \n" +
            "INNER JOIN city ci ON ci.city_id = a.city_id\n" +
            "INNER JOIN country co ON co.country_id = ci.country_id\n" +
            "INNER JOIN payment p ON c.customer_id = p.customer_id\n" +
            "GROUP BY c.customer_id, c.first_name, c.last_name, ci.city, co.country\n" +
            "HAVING COUNT(*) IN (\n" +
            "\tSELECT COUNT(*) FROM payment p\n" +
            "\tINNER JOIN customer c ON c.customer_id = p.customer_id\n" +
            "\tGROUP BY c.customer_id\n" +
            "\tORDER BY COUNT(*) DESC\n" +
            "\tLIMIT 1\n" +
            ")\n";

    List<Map<String, Object>> resultMap;

    {
        try {
            resultMap = DBUtils.getQueryResultMap(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("The first name is {string} and the last_name is {string}")
    public void the_first_name_is_and_the_last_name_is(String name, String surname) throws SQLException {
        String expectedFirstName = resultMap.get(0).get("first_name").toString();
        String expectedLastName = resultMap.get(0).get("last_name").toString();
        assertEquals(expectedFirstName, name);
        assertEquals(expectedLastName, surname);
        System.out.println("First assertion is passed.");

    }

    @Given("The city is {string} and the country is {string}")
    public void the_city_is_and_the_country_is(String city, String country) {
        String expectedCity = resultMap.get(0).get("city").toString();
        String expectedCountry = resultMap.get(0).get("country").toString();
        assertEquals(expectedCity,city);
        assertEquals(expectedCountry,country);
        System.out.println("Second assertion is passed.");
    }

    @Given("The total amount of payment is {string}")
    public void the_total_amount_of_payment_is(String totalAmount) {
        String expectedAmount = resultMap.get(0).get("sum").toString();
        assertEquals(expectedAmount,totalAmount);
        System.out.println("Third assertion is passed.");
    }
}
