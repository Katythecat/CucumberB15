package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {
    static Connection conn = null;
    static Statement statement = null;
    private static ResultSet rSet; // private-this data should be inside the class only
    private static ResultSetMetaData rSetMetaData;

    //this method create connection to DB, execute query and return obj for resultset
    public static ResultSet getResultSet(String sqlQuery) {
        try {
            conn = DriverManager.getConnection(
                    ConfigReader.getPropertyValue("urldb"),
                    ConfigReader.getPropertyValue("usernamedb"),
                    ConfigReader.getPropertyValue("passworddb"));
            statement = conn.createStatement();
            rSet = statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rSet;
    }

    //this method will return the obj of rsetMetadata
    public static ResultSetMetaData getrSetMetaData(String query) {
        rSet = getResultSet(query); //will get result set base on the query
        rSetMetaData = null; // null bc we haven't declare rSet.getMetaData();
        //we use this line to get the data in tabular format so that
        // we can use these in column keys and values for retrieval the value operation

        try {
            rSetMetaData = rSet.getMetaData();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rSetMetaData;
    }

    //this method is extracting the data which will be stored in list of map
    public static List<Map<String, String>> getListOfMapsFromRset(String query) {
        rSetMetaData = getrSetMetaData(query);
        List<Map<String, String>> listFromRset = new ArrayList<>();
        try {
            while (rSet.next()) { //check if we have a row or not
                Map<String, String> map = new LinkedHashMap<>();
                for (int i = 1; i <= rSetMetaData.getColumnCount(); i++) { // loop thu the columns
                    //fetching key and value from the columns
                    String key = rSetMetaData.getColumnName(i);//return the column name
                    String value = rSet.getString(key);//return value
                    map.put(key, value);
                }
                System.out.println(map);
                listFromRset.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtility.closeResultSet(rSet);
            DBUtility.closeStatement(statement);
            DBUtility.closeConnection(conn);
        }
        return listFromRset;
    }
    //order to make connection
    //connection
    //statement
    //resultSet

    //close resultset
    //close statement
    //close connection

    public static void closeResultSet(ResultSet rSet) {
        if (rSet != null) {
            try {
                rSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

