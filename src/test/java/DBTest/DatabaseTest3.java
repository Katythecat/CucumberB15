package DBTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DatabaseTest3 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        try {
            Connection  conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created");
            Statement statement = conn.createStatement();
            String query = "select*from person; ";
            ResultSet rSet = statement.executeQuery(query);
            ResultSetMetaData rSetMetaData=rSet.getMetaData();

            //extract data from resultset and store it in java data structure
            List<Map<String,String>> listFromRset=new ArrayList<>();
            //iterate throuht the rows
            while(rSet.next()) {//
                Map<String, String> map = new LinkedHashMap<>(); // insertion order LHM
                //iterate over the columns
                for (int i = 1; i <= rSetMetaData.getColumnCount() ; i++) {
                    //fetching key and value from the columns
                    String key=rSetMetaData.getColumnName(i);
                    String value=rSet.getString(key);
                    map.put(key,value);
                }
                System.out.println(map);
                listFromRset.add(map);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

}

