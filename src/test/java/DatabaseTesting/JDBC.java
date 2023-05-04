package DatabaseTesting;

import java.sql.*;

public class JDBC {


    public static void main(String[] args) throws SQLException {

        // connection credentials
        String dbUrl = "jdbc:oracle:thin:@3.216.30.92:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("Select * from regions");

        rs.next();

        System.out.println(rs.getInt(1));
        System.out.println(rs.getString(2));

        rs.next();
        System.out.println(rs.getInt(1));
        System.out.println(rs.getString(2));

        rs.previous();
//        rs.beforeFirst();
        rs.afterLast();
        rs.absolute(2);
        System.out.println(rs.getInt(1));



    }


}




