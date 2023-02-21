package org.example;

import java.sql.*;

public class Question1 {

    // 1- The last 3 person’s name and rent date, who had rent any film of actor “Ed Chase”

    public static void answer() throws SQLException {

        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental" ;
        String username = "postgres";
        String password = "1200571996";

        Connection connection = DriverManager.getConnection(dbURL,username,password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        String query = "SELECT CONCAT(c.first_name,' ',c.last_name) AS name, rental_date\n" +
                "FROM customer c\n" +
                "INNER JOIN rental r ON c.customer_id = r.customer_id\n" +
                "INNER JOIN inventory i ON i.inventory_id = r.inventory_id\n" +
                "INNER JOIN film_actor fa ON fa.film_id = i.film_id\n" +
                "INNER JOIN actor a ON a.actor_id = fa.actor_id\n" +
                "WHERE a.first_name = 'Ed' AND a.last_name = 'Chase'\n" +
                "ORDER BY rental_date DESC\n" +
                "LIMIT 3\n";

        ResultSet resultSet = statement.executeQuery(query);
        int count = 0;
        while (resultSet.next()){
            System.out.println(++count + " : " + resultSet.getString("name") + " " + resultSet.getString("rental_date"));
        }
    }
}
