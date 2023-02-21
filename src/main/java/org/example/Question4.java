package org.example;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Question4 {

    //  4-Which countries have made higher payments than 800$?(with their payment amount in desc order)

    public static void answer() throws SQLException {

        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "1200571996";
        String query = "SELECT country,SUM(amount) FROM country c\n" +
                "INNER JOIN city ci ON ci.country_id = c.country_id\n" +
                "INNER JOIN address ad ON ad.city_id = ci.city_id\n" +
                "INNER JOIN customer cu ON cu.address_id = ad.address_id\n" +
                "INNER JOIN payment p ON p.customer_id = cu.customer_id\n" +
                "GROUP BY country\n" +
                "HAVING SUM(amount) > 800\n" +
                "ORDER BY SUM(amount) DESC\n" +
                "\n";

        Connection connection = DriverManager.getConnection(dbURL,username,password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(query);

        int count = 0;
        while (resultSet.next()){
            System.out.printf("%-4s%-25s%s" , ++count,resultSet.getString("country"),resultSet.getString("sum"));
            System.out.println();
        }
    }
}
