package DatabaseTesting;

import java.sql.*;

public class JDBC {


    public JDBC() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {

        // connection credentials

    }

    String dbUrl = "jdbc:oracle:thin:@3.216.30.92:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_READ_ONLY);
    ResultSet rs = stmt.executeQuery("Select * from employees");

}




