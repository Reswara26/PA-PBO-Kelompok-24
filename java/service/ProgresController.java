package service;

import db_connector.db_connection;
import model.ICRUD;
import model.Progres;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgresController extends CrudController<Progres>implements ICRUD<Progres> {

    @Override
    public boolean tambah(Progres t) {
        String q = "INSERT INTO progres (id_progres, tanggal_update, persentase_selesai, deskripsi, Proyek_id_proyek) " +
                   "VALUES (?,?,?,?,?)";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, t.getIdProgres());
            ps.setString(2, t.getTanggalUpdate());
            ps.setDouble(3, t.getPersentaseSelesai());
            ps.setString(4, t.getDeskripsi());
            ps.setString(5, t.getIdProyek());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("[Progres tambah] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean edit(Progres t) {
        String q = "UPDATE progres SET tanggal_update=?, persentase_selesai=?, deskripsi=? WHERE id_progres=?";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, t.getTanggalUpdate());
            ps.setDouble(2, t.getPersentaseSelesai());
            ps.setString(3, t.getDeskripsi());
            ps.setString(4, t.getIdProgres());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("[Progres edit] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean hapus(String id) {
        String q = "DELETE FROM progres WHERE id_progres=?";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("[Progres hapus] " + e.getMessage());
            return false;
        }
    }

    @Override
    public Progres getById(String id) {
        String q = "SELECT * FROM progres WHERE id_progres=? LIMIT 1";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return map(rs);
            return null;
        } catch (Exception e) {
            System.out.println("[Progres getById] " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Progres> getAll() {
        List<Progres> list = new ArrayList<>();
        String q = "SELECT * FROM progres";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(map(rs));
        } catch (Exception e) {
            System.out.println("[Progres getAll] " + e.getMessage());
        }
        return list;
    }

    public List<Progres> getByProyek(String idProyek) {
        List<Progres> list = new ArrayList<>();
        String q = "SELECT * FROM progres WHERE Proyek_id_proyek=? ORDER BY tanggal_update DESC";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, idProyek);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(map(rs));
        } catch (Exception e) {
            System.out.println("[Progres getByProyek] " + e.getMessage());
        }
        return list;
    }

    private Progres map(ResultSet rs) throws SQLException {
        Progres t = new Progres();
        t.setIdProgres(rs.getString("id_progres"));
        t.setTanggalUpdate(str(rs.getDate("tanggal_update")));
        t.setPersentaseSelesai(rs.getDouble("persentase_selesai"));
        t.setDeskripsi(rs.getString("deskripsi"));
        t.setIdProyek(rs.getString("Proyek_id_proyek"));
        return t;
    }

    private String str(java.sql.Date d) { return (d == null) ? null : d.toString(); }
}
