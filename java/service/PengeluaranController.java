package service;

import db_connector.db_connection;
import model.ICRUD;
import model.Pengeluaran;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PengeluaranController extends CrudController<Pengeluaran>implements ICRUD<Pengeluaran> {

    @Override
    public boolean tambah(Pengeluaran t) {
        String q = "INSERT INTO pengeluaran (id_pengeluaran, tanggal_pengeluaran, keterangan, jumlah, kategori, Proyek_id_proyek) " +
                   "VALUES (?,?,?,?,?,?)";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, t.getIdPengeluaran());
            ps.setString(2, t.getTanggalPengeluaran());
            ps.setString(3, t.getKeterangan());
            ps.setDouble(4, t.getJumlah());
            ps.setString(5, t.getKategori());
            ps.setString(6, t.getIdProyek());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("[Pengeluaran tambah] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean edit(Pengeluaran t) {
        String q = "UPDATE pengeluaran SET tanggal_pengeluaran=?, keterangan=?, jumlah=?, kategori=? WHERE id_pengeluaran=?";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, t.getTanggalPengeluaran());
            ps.setString(2, t.getKeterangan());
            ps.setDouble(3, t.getJumlah());
            ps.setString(4, t.getKategori());
            ps.setString(5, t.getIdPengeluaran());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("[Pengeluaran edit] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean hapus(String id) {
        String q = "DELETE FROM pengeluaran WHERE id_pengeluaran=?";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("[Pengeluaran hapus] " + e.getMessage());
            return false;
        }
    }

    @Override
    public Pengeluaran getById(String id) {
        String q = "SELECT * FROM pengeluaran WHERE id_pengeluaran=? LIMIT 1";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return map(rs);
            return null;
        } catch (Exception e) {
            System.out.println("[Pengeluaran getById] " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Pengeluaran> getAll() {
        List<Pengeluaran> list = new ArrayList<>();
        String q = "SELECT * FROM pengeluaran";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(map(rs));
        } catch (Exception e) {
            System.out.println("[Pengeluaran getAll] " + e.getMessage());
        }
        return list;
    }

    public List<Pengeluaran> getByProyek(String idProyek) {
        List<Pengeluaran> list = new ArrayList<>();
        String q = "SELECT * FROM pengeluaran WHERE Proyek_id_proyek=? ORDER BY tanggal_pengeluaran DESC";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, idProyek);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(map(rs));
        } catch (Exception e) {
            System.out.println("[Pengeluaran getByProyek] " + e.getMessage());
        }
        return list;
    }

    private Pengeluaran map(ResultSet rs) throws SQLException {
        Pengeluaran t = new Pengeluaran();
        t.setIdPengeluaran(rs.getString("id_pengeluaran"));
        t.setTanggalPengeluaran(str(rs.getDate("tanggal_pengeluaran")));
        t.setKeterangan(rs.getString("keterangan"));
        t.setJumlah(rs.getDouble("jumlah"));
        t.setKategori(rs.getString("kategori"));
        t.setIdProyek(rs.getString("Proyek_id_proyek"));
        return t;
    }

    private String str(java.sql.Date d) { return (d == null) ? null : d.toString(); }
}
