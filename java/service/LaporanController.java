package service;

import db_connector.db_connection;
import model.ICRUD;
import model.Laporan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LaporanController extends CrudController<Laporan>implements ICRUD<Laporan> {

    @Override
    public boolean tambah(Laporan t) {
        String q = "INSERT INTO laporan (id_laporan, tanggal_laporan, jenis_kendala, deskripsi, status_tindak_lanjut, Proyek_id_proyek) " +
                   "VALUES (?,?,?,?,?,?)";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, t.getIdLaporan());
            ps.setString(2, t.getTanggalLaporan());
            ps.setString(3, t.getJenisKendala());
            ps.setString(4, t.getDeskripsi());
            ps.setString(5, t.getStatusTindakLanjut());
            ps.setString(6, t.getIdProyek());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("[Laporan tambah] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean edit(Laporan t) {
        String q = "UPDATE laporan SET tanggal_laporan=?, jenis_kendala=?, deskripsi=?, status_tindak_lanjut=? WHERE id_laporan=?";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, t.getTanggalLaporan());
            ps.setString(2, t.getJenisKendala());
            ps.setString(3, t.getDeskripsi());
            ps.setString(4, t.getStatusTindakLanjut());
            ps.setString(5, t.getIdLaporan());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("[Laporan edit] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean hapus(String id) {
        String q = "DELETE FROM laporan WHERE id_laporan=?";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("[Laporan hapus] " + e.getMessage());
            return false;
        }
    }

    @Override
    public Laporan getById(String id) {
        String q = "SELECT * FROM laporan WHERE id_laporan=? LIMIT 1";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return map(rs);
            return null;
        } catch (Exception e) {
            System.out.println("[Laporan getById] " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Laporan> getAll() {
        List<Laporan> list = new ArrayList<>();
        String q = "SELECT * FROM laporan";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(map(rs));
        } catch (Exception e) {
            System.out.println("[Laporan getAll] " + e.getMessage());
        }
        return list;
    }

    public List<Laporan> getByProyek(String idProyek) {
        List<Laporan> list = new ArrayList<>();
        String q = "SELECT * FROM laporan WHERE Proyek_id_proyek=? ORDER BY tanggal_laporan DESC";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, idProyek);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(map(rs));
        } catch (Exception e) {
            System.out.println("[Laporan getByProyek] " + e.getMessage());
        }
        return list;
    }

    private Laporan map(ResultSet rs) throws SQLException {
        Laporan t = new Laporan();
        t.setIdLaporan(rs.getString("id_laporan"));
        t.setTanggalLaporan(str(rs.getDate("tanggal_laporan")));
        t.setJenisKendala(rs.getString("jenis_kendala"));
        t.setDeskripsi(rs.getString("deskripsi"));
        t.setStatusTindakLanjut(rs.getString("status_tindak_lanjut"));
        t.setIdProyek(rs.getString("Proyek_id_proyek"));
        return t;
    }

    private String str(java.sql.Date d) { return (d == null) ? null : d.toString(); }
}
