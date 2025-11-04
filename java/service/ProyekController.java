package service;

import db_connector.db_connection;
import model.ICRUD;
import model.Proyek;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProyekController extends CrudController<Proyek>implements ICRUD<Proyek> {

    @Override
    public boolean tambah(Proyek p) {
        String q = "INSERT INTO proyek (id_proyek, nama_proyek, lokasi, tanggal_mulai, tanggal_selesai, anggaran, status) " +
                   "VALUES (?,?,?,?,?,?,?)";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, p.getIdProyek());
            ps.setString(2, p.getNamaProyek());
            ps.setString(3, p.getLokasi());
            ps.setString(4, p.getTanggalMulai());
            ps.setString(5, p.getTanggalSelesai());
            ps.setDouble(6, p.getAnggaran());
            ps.setString(7, p.getStatus());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("[Proyek tambah] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean edit(Proyek p) {
        String q = "UPDATE proyek SET nama_proyek=?, lokasi=?, tanggal_mulai=?, tanggal_selesai=?, anggaran=?, status=? " +
                   "WHERE id_proyek=?";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, p.getNamaProyek());
            ps.setString(2, p.getLokasi());
            ps.setString(3, p.getTanggalMulai());
            ps.setString(4, p.getTanggalSelesai());
            ps.setDouble(5, p.getAnggaran());
            ps.setString(6, p.getStatus());
            ps.setString(7, p.getIdProyek());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("[Proyek edit] " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean hapus(String id) {
        String q = "DELETE FROM proyek WHERE id_proyek=?";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("[Proyek hapus] " + e.getMessage());
            return false;
        }
    }

    @Override
    public Proyek getById(String id) {
        String q = "SELECT * FROM proyek WHERE id_proyek=? LIMIT 1";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return map(rs);
            return null;
        } catch (Exception e) {
            System.out.println("[Proyek getById] " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Proyek> getAll() {
        List<Proyek> out = new ArrayList<>();
        String q = "SELECT * FROM proyek";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(map(rs));
        } catch (Exception e) {
            System.out.println("[Proyek getAll] " + e.getMessage());
        }
        return out;
    }

    // proyek aktif user via pengguna.Proyek_id_proyek
    public Proyek getByPengguna(String idPengguna) {
        String q = "SELECT p.* FROM proyek p JOIN pengguna u ON u.Proyek_id_proyek=p.id_proyek WHERE u.id_pengguna=? LIMIT 1";
        try (Connection c = db_connection.getConnection();
             PreparedStatement ps = c.prepareStatement(q)) {
            ps.setString(1, idPengguna);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return map(rs);
            return null;
        } catch (Exception e) {
            System.out.println("[Proyek getByPengguna] " + e.getMessage());
            return null;
        }
    }

    private Proyek map(ResultSet rs) throws SQLException {
        Proyek p = new Proyek();
        p.setIdProyek(rs.getString("id_proyek"));
        p.setNamaProyek(rs.getString("nama_proyek"));
        p.setLokasi(rs.getString("lokasi"));
        p.setTanggalMulai(str(rs.getDate("tanggal_mulai")));
        p.setTanggalSelesai(str(rs.getDate("tanggal_selesai")));
        p.setAnggaran(rs.getDouble("anggaran"));
        p.setStatus(rs.getString("status"));
        return p;
    }

    private String str(java.sql.Date d) { return (d == null) ? null : d.toString(); }
}
