package ProjectGUI;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Statement stt;
        ResultSet rs;
        Connection conn;

        try {
             conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/coffee_shop",
                    "root",
                    "rith123"
            );
            stt = conn.createStatement();
            stt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stt.executeUpdate("INSERT INTO Customer VALUES('629','ឬទ្ធិ', 'RHETT', 'Male','kai@gmail.com','000000')");
            /*rs = stt.executeQuery("SELECT * FROM Customer WHERE customerID = '1'");
            while (rs.next()) {
                System.out.println(rs.getString("nameKH"));
                System.out.println(rs.getString("nameEN"));
                System.out.println(rs.getString("customerID"));
                System.out.println(rs.getString("gender"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("phoneNumber"));
            }*/
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}