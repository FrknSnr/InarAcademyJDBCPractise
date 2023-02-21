package org.example;
import java.sql.*;

public class Question5 {

    //  5-How much will store-2 earn when all the rented films are returned?

    public static void answer() throws SQLException {

        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username ="postgres";
        String password = "1200571996";
        String query = " SELECT SUM(AMOUNT) FROM RENTAL\n" +
                "INNER JOIN INVENTORY ON INVENTORY.INVENTORY_ID = RENTAL.INVENTORY_ID\n" +
                "INNER JOIN PAYMENT P ON P.CUSTOMER_ID = RENTAL.CUSTOMER_ID \n" +
                "WHERE STORE_ID = 2 AND RETURN_DATE IS NULL" ;

        Connection connection = DriverManager.getConnection(dbURL,username,password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(query);

        int count = 0 ;
        while (resultSet.next()){
            System.out.println(++count+" : " + resultSet.getString("sum"));
        }
    }
}
