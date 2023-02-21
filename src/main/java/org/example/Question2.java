package org.example;

import java.sql.*;

public class Question2 {

    // 2- Find the staff’s name, username and password who is working in the store that sells “Glass Dying” film

    public static void answer() throws SQLException {

        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental" ;
        String username = "postgres";
        String password = "1200571996";

        String query = "SELECT CONCAT(s.first_name,' ',last_name) AS name, username, password \n" +
                "FROM staff s\n" +
                "WHERE store_id IN (\n" +
                "SELECT st.store_id FROM store st\n" +
                "INNER JOIN inventory i ON st.store_id = i.store_id\n" +
                "INNER JOIN film f ON f.film_id = i.film_id\n" +
                "WHERE title = 'Glass Dying')";

        Connection connection = DriverManager.getConnection(dbURL,username,password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery(query);
        int count = 0;
        while(resultSet.next()){
            System.out.println(++count + " : " + resultSet.getString("name")+" " +
                    resultSet.getString("username")+ " " +
                    resultSet.getString("password"));
        }


    }
}
