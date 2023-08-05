package practiceJDBC;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {


        /**
         * We need 3 things to connect to database
         * 1. Connection object
         * 2.Statement object
         * 3.ResultSet object
         *
         */
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/HR_production",
                "postgres",
                "Admin123");

        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("select * from employees");

  //     resultSet.next();

    //    System.out.println(resultSet.getString(1));
    //    resultSet.next();
   //     System.out.println(resultSet.getString(1));
int count =0;
        while (resultSet.next()) {
            System.out.println(count+" "+resultSet.getString(2)+" "+resultSet.getString("last_name"));
            count++;
        }
        /**
         * ResultSetMetaData it holds a data about data
         */
        ResultSetMetaData metaData=resultSet.getMetaData();
        System.out.println(metaData.getColumnCount());

        for (int i=1; i<metaData.getColumnCount();i++){
            System.out.println("Column name: " +i+". Column name: " +metaData.getColumnName(i));

        }


    }
}
