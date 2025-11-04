package service;

import db_connector.db_connection;
import model.Admin;
import model.Kontraktor;
import model.Pengguna;

import java.sql.*;

public class PenggunaController {

    public Pengguna login(String username, String password) {
        String q = "SELECT * FROM pengguna WHERE username=? AND password=? LIMIT 1";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) return null;

            String id = rs.getString("id_pengguna");

            if (isAdmin(id, c)) {
                Admin a = new Admin();
                fillPengguna(a, rs);
                fillAdmin(a, c);
                return a;
            }
            if (isKontraktor(id, c)) {
                Kontraktor k = new Kontraktor();
                fillPengguna(k, rs);
                fillKontraktor(k, c);
                return k;
            }

            Pengguna p = new Pengguna();
            fillPengguna(p, rs);
            return p;

        } catch (Exception e) {
            System.out.println("[Login] " + e.getMessage());
            return null;
        }
    }

    private boolean isAdmin(String id, Connection c) throws SQLException {
        String q = "SELECT 1 FROM admin WHERE id_pengguna=? LIMIT 1";
        try (PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, id);
            return ps.executeQuery().next();
        }
    }

    private boolean isKontraktor(String id, Connection c) throws SQLException {
        String q = "SELECT 1 FROM kontraktor WHERE id_pengguna=? LIMIT 1";
        try (PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, id);
            return ps.executeQuery().next();
        }
    }

    private void fillPengguna(Pengguna p, ResultSet rs) throws SQLException {
        p.setIdPengguna(rs.getString("id_pengguna"));
        p.setNamaPengguna(rs.getString("nama_pengguna"));
        p.setUsername(rs.getString("username"));
        p.setPassword(rs.getString("password"));
        p.setKontak(rs.getString("kontak"));
        p.setProyekIdProyek(rs.getString("Proyek_id_proyek"));
    }

    private void fillAdmin(Admin a, Connection c) throws SQLException {
        String q = "SELECT jabatan_admin FROM admin WHERE id_pengguna=? LIMIT 1";
        try (PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, a.getIdPengguna());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) a.setJabatanAdmin(rs.getString("jabatan_admin"));
        }
    }

    private void fillKontraktor(Kontraktor k, Connection c) throws SQLException {
        String q = "SELECT nama_perusahaan, penanggung_jawab FROM kontraktor WHERE id_pengguna=? LIMIT 1";
        try (PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, k.getIdPengguna());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                k.setNamaPerusahaan(rs.getString("nama_perusahaan"));
                k.setPenanggungJawab(rs.getString("penanggung_jawab"));
            }
        }
    }

    // set proyek aktif user (dipakai saat kontraktor tambah proyek)
    public boolean setProyekAktif(String idPengguna, String idProyek) {
        String q = "UPDATE pengguna SET Proyek_id_proyek=? WHERE id_pengguna=?";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, idProyek);
            ps.setString(2, idPengguna);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("[Pengguna setProyekAktif] " + e.getMessage());
            return false;
        }
    }
}
