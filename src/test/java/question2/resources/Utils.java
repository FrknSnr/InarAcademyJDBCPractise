package question2.resources;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void createConnection() throws SQLException {
        connection = DriverManager.getConnection(
                Config.getProperty("dbURL"),
                Config.getProperty("username"),
                Config.getProperty("password")
        );
    }

    private static void executeQuery(String query) throws SQLException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(query);
    }

    public static List<Map<String, Object>> getResultMap(String query) throws SQLException {
        executeQuery(query);
        List<Map<String, Object>> listMap = new ArrayList<>();
        ResultSetMetaData rsmd = resultSet.getMetaData();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                map.put(rsmd.getColumnName(i), resultSet.getObject(i));
            }
            listMap.add(map);
        }
        return listMap;
    }

    public static void destroyDBConnection() throws SQLException {
        if (resultSet != null){
            resultSet.close();
        }
        if (connection != null) {
            connection.close();
        }
        if (statement != null){
            statement.close();
        }
    }
}
