package model;

public class Pengeluaran {
    private String idPengeluaran;
    private String tanggalPengeluaran;
    private String keterangan;
    private double jumlah;
    private String kategori;
    private String idProyek;

    public String getIdPengeluaran() { return idPengeluaran; }
    public void setIdPengeluaran(String idPengeluaran) { this.idPengeluaran = idPengeluaran; }

    public String getTanggalPengeluaran() { return tanggalPengeluaran; }
    public void setTanggalPengeluaran(String tanggalPengeluaran) { this.tanggalPengeluaran = tanggalPengeluaran; }

    public String getKeterangan() { return keterangan; }
    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }

    public double getJumlah() { return jumlah; }
    public void setJumlah(double jumlah) { this.jumlah = jumlah; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public String getIdProyek() { return idProyek; }
    public void setIdProyek(String idProyek) { this.idProyek = idProyek; }
}
