package question5.resources;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    private static Connection connection;
    private static ResultSet resultSet;
    private static Statement statement;

    public static void setConnection() throws SQLException {
         connection = DriverManager.getConnection(
                Config.getProperty("dbURL"),
                Config.getProperty("username"),
                Config.getProperty("password")
        );
    }
    public static void executeQuery(String query) throws SQLException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(query);
    }
    public static List<Map<String,Object>> getResultList(String query) throws SQLException {
        executeQuery(query);
        List<Map<String,Object>> list = new ArrayList<>();
        ResultSetMetaData  rsmd = resultSet.getMetaData();

        while(resultSet.next()){
            Map<String,Object> map = new HashMap<>();
            for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
                map.put(rsmd.getColumnName(i),resultSet.getObject(i));
            }
            list.add(map);
        }
        return list ;
    }
    public static void close() throws SQLException {
        if (resultSet != null){
            resultSet.close();
        }
        if (statement != null){
            statement.close();
        }
        if (connection != null){
            connection.close();
        }
    }
}
