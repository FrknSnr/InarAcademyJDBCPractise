package question3.stepDefs;
import io.cucumber.java.en.Given;
import question3.resources.Utils;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class StepDefQuestion3 {

    private static final int count = 0;

    @Given("store_id is {string}, address is {string},city is {string} and the country is {string}")
    public void store_id_is_address_is_city_is_Woodridge_and_the_country_is_Australia(String store_id, String address, String city, String country) throws SQLException {
        String query = "SELECT store_id,address,city,country FROM store s\n" +
                "INNER JOIN address ad ON s.address_id = ad.address_id\n" +
                "INNER JOIN city c ON c.city_id = ad.city_id\n" +
                "INNER JOIN country co ON co.country_id = c.country_id\n" +
                "WHERE store_id = 2";

        List<Map<String, Object>> listMap = Utils.getResultListMap(query);
        String resultStoreId = listMap.get(count).get("store_id").toString();
        String resultAddress = listMap.get(count).get("address").toString();
        String resultCity = listMap.get(count).get("city").toString();
        String resultCountry = listMap.get(count).get("country").toString();

        assertEquals(resultStoreId,store_id);
        assertEquals(resultAddress,address);
        assertEquals(resultCity,city);
        assertEquals(resultCountry,country);
    }
}
