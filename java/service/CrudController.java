package service;

import db_connector.db_connection;
import model.ICRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class CrudController<T> implements ICRUD<T> {

    protected Connection conn() throws Exception {
        return db_connection.getConnection();
    }

  
    protected String nextId(String table, String idColumn, String prefix) {
        String sql = "SELECT MAX(" +
                "CAST(SUBSTRING(" + idColumn + ", 2) AS UNSIGNED)) AS maxnum " +
                "FROM " + table + " WHERE " + idColumn + " LIKE ?";
        try (Connection c = conn();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, prefix + "%");
            try (ResultSet rs = ps.executeQuery()) {
                int next = 1;
                if (rs.next()) {
                    next = rs.getInt("maxnum") + 1;
                }
                return String.format("%s%04d", prefix, next);
            }
        } catch (Exception e) {
            // fallback yang tetap deterministik tapi aman
            return prefix + "0001";
        }
    }

    protected void requireNonEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " tidak boleh kosong.");
        }
    }

    protected void requireDateLike(String value, String fieldName) {
        if (value == null || !value.matches("^[0-9\\-]+$") || !value.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            throw new IllegalArgumentException(fieldName + " wajib format YYYY-MM-DD (hanya angka dan '-').");
        }
    }

    protected double parseDoubleStrict(String s, String fieldName) {
        if (s == null || !s.trim().matches("^-?\\d+(\\.\\d+)?$")) {
            throw new IllegalArgumentException(fieldName + " wajib angka.");
        }
        return Double.parseDouble(s.trim());
    }
}
