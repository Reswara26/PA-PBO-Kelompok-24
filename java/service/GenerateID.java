package service;

import db_connector.db_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class GenerateID {
    private GenerateID() {}

    public static String nextId(String table, String idColumn, String prefix) {
        String sql = "SELECT MAX(CAST(SUBSTRING(" + idColumn + ", 2) AS UNSIGNED)) AS maxnum " +
                     "FROM " + table + " WHERE " + idColumn + " LIKE ?";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, prefix + "%");
            try (ResultSet rs = ps.executeQuery()) {
                int next = 1;
                if (rs.next()) next = rs.getInt("maxnum") + 1;
                return String.format("%s%04d", prefix, next);
            }
        } catch (Exception e) {
            return prefix + "0001";
        }
    }
}
