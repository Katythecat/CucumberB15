package DBTest;

import java.sql.*;

public class DatabaseTest2 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password="syntaxhrm123";

        try {
            //we need to establish the connection to the database
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for batch 15");
            //create a statement to send sql queries
            Statement statement = conn.createStatement();
            //ResultSet rSet=statement.executeQuery("select FirstName,LastName from person");


           /* while(rSet.next()){
                String fName= rSet.getString("FirstName");
                String lName= rSet.getString("LastName");
               //System.out.println(fName+" "+lName);
            }*/

            ResultSet rSet= statement.executeQuery(
                        "select FirstName, LastName, Age, City " +
                            "from person " +
                            "where city is not null; ");
            //ResultSetMetaData - obj that contains information about the result
            //information such as in the table how many columns are there,
            //name of the columns, rows and number of the rows

            ResultSetMetaData rSetMetaData= rSet.getMetaData();
            //print all the columns header values
            for(int i=1;i<= rSetMetaData.getColumnCount();i++){
                String columnName=rSetMetaData.getColumnName(i);
                System.out.print(columnName+" ");
            }
            System.out.println();

            //we want to loop through every column and row to get the table values
            while(rSet.next()){
                for(int i=1;i<= rSetMetaData.getColumnCount();i++){
                    String value=rSet.getString(rSetMetaData.getColumnName(i));
                    System.out.print(value+" ");
                }
                System.out.println();

            }

        }catch (SQLException e){
            e.printStackTrace();

        }
    }
}
