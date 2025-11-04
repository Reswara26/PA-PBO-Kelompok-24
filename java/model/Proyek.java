package model;

public class Proyek {
    private String idProyek;
    private String namaProyek;
    private String lokasi;
    private String tanggalMulai;   // YYYY-MM-DD
    private String tanggalSelesai; // YYYY-MM-DD
    private double anggaran;
    private String status;

    public String getIdProyek() { return idProyek; }
    public void setIdProyek(String idProyek) { this.idProyek = idProyek; }

    public String getNamaProyek() { return namaProyek; }
    public void setNamaProyek(String namaProyek) { this.namaProyek = namaProyek; }

    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }

    public String getTanggalMulai() { return tanggalMulai; }
    public void setTanggalMulai(String tanggalMulai) { this.tanggalMulai = tanggalMulai; }

    public String getTanggalSelesai() { return tanggalSelesai; }
    public void setTanggalSelesai(String tanggalSelesai) { this.tanggalSelesai = tanggalSelesai; }

    public double getAnggaran() { return anggaran; }
    public void setAnggaran(double anggaran) { this.anggaran = anggaran; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
