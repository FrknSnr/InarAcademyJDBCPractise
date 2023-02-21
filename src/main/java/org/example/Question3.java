package org.example;

import java.sql.*;

public class Question3 {

    // 3-What are the names of top 5 categories, that have more than 150 films in inventory of store-1?

    public static void answer() throws SQLException {

        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "1200571996";
        String query = "SELECT c.name,COUNT(*) AS film_amount\n" +
                "FROM category c\n" +
                "INNER JOIN film_category fc ON c.category_id = fc.category_id\n" +
                "INNER JOIN inventory i ON i.film_id = fc.film_id\n" +
                "GROUP BY c.name,store_id\n" +
                "HAVING COUNT(*) > 150 AND store_id = 1\n" +
                "ORDER BY film_amount DESC\n" +
                "LIMIT 5";

        Connection connection = DriverManager.getConnection(dbURL,username,password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(query);

        int count = 0;
        while(resultSet.next()){
            System.out.println(++count + " : " + resultSet.getString("name") + " " + resultSet.getString("film_amount"));
        }

    }
}
