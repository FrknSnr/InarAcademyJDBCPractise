package org.example;

import java.sql.*;

public class Question {

    public static void answer() throws SQLException {

        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental" ;
        String username = "postgres";
        String password = "1200571996";

        Connection connection = DriverManager.getConnection(dbURL,username,password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        String query = "SELECT name, membercost, guestcost FROM cd.facilities\n" +
                "WHERE guestcost = membercost * membercost ;";

        ResultSet resultSet = statement.executeQuery(query);
        int count = 0 ;
        while (resultSet.next()){
            System.out.println(++count + " : " + resultSet.getString("name") + resultSet.getString("membercost"));
        }

    }
}
