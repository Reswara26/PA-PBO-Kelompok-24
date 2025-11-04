package model;

public class Progres {
    private String idProgres;       // <- match kolom id_progres
    private String tanggalUpdate;   // YYYY-MM-DD
    private double persentaseSelesai;
    private String deskripsi;
    private String idProyek;

    public String getIdProgres() { return idProgres; }
    public void setIdProgres(String idProgres) { this.idProgres = idProgres; }

    public String getTanggalUpdate() { return tanggalUpdate; }
    public void setTanggalUpdate(String tanggalUpdate) { this.tanggalUpdate = tanggalUpdate; }

    public double getPersentaseSelesai() { return persentaseSelesai; }
    public void setPersentaseSelesai(double persentaseSelesai) { this.persentaseSelesai = persentaseSelesai; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public String getIdProyek() { return idProyek; }
    public void setIdProyek(String idProyek) { this.idProyek = idProyek; }
}
