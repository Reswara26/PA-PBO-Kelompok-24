package db_connector;
import java.sql.*;

public class db_connection {
    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/simanprof";
            String user = "root";
            String pass = "";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // pastikan driver diload
                conn = DriverManager.getConnection(url, user, pass);
            } catch (ClassNotFoundException e) {
                throw new SQLException("MySQL Driver tidak ditemukan!", e);
            }
        }
        return conn;
    }
}
