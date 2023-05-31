package DBTest;

import java.sql.*;

public class DatabaseTest {
    public static void main(String[] args)  {
        /*
     to build the connection with the database
     we need 3 things, URL,username,password
     */
        //1. jdbc will connect java with database
        //2. then type of database --> mysql
        //3. follow with the address of database->3.239.253.255:3306
        //4. make it unique provide the name ->syntaxhrm_mysql
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql"; // to establish the connection with database and type
                                //of database (mysql)
        String username = "syntax_hrm";
        String password="syntaxhrm123";


        try {
            //we need to establish the connection to the database
            //1.connect
            Connection conn=DriverManager.getConnection(url,username,password);
            System.out.println("Connection is created for batch 15");

            //create a statement to send sql queries
            //2.statement
            Statement statement= conn.createStatement();

            //when we send any query to the database then db returns
            //result set(tables with rows and columns)
            //3.write a query
            ResultSet rSet=statement.executeQuery(
                    "select FirstName,LastName " +
                            "from person");
            // rSet on top get only the header part
            rSet.next(); // will print the next row
            String fName=rSet.getString("FirstName");
            String lName=rSet.getString("LastName");
            System.out.println(fName+" "+lName);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
