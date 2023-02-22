package question2.stepDefs;

import io.cucumber.java.en.Given;
import question2.resources.Utils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StepDef {

    static int count = 0;

    @Given("{string},{string} and {string}")
    public void and(String staff_id, String month, String total_sales) throws SQLException {

        String query = "SELECT staff_id,TO_CHAR(payment_date,'Month') AS Month,SUM(amount) AS total_sales\n" +
                "FROM payment \n" +
                "GROUP BY staff_id,TO_CHAR(payment_date,'Month') ;";

        List<Map<String, Object>> resultMap = Utils.getResultMap(query);
        String expectedStaffId = resultMap.get(count).get("staff_id").toString();
        String expectedMonth = resultMap.get(count).get("month").toString();
        String expectedTotalSales = resultMap.get(count).get("total_sales").toString();

        System.out.println(expectedStaffId + " " + expectedMonth + " " + expectedTotalSales);
        assertEquals(expectedStaffId.trim(), staff_id);
        assertEquals(expectedMonth.trim(), month);
        assertEquals(expectedTotalSales.trim(), total_sales);


        count++;
    }
}
