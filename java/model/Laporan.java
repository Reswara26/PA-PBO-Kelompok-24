package model;

public class Laporan {
    private String idLaporan;
    private String tanggalLaporan;
    private String jenisKendala;
    private String deskripsi;
    private String statusTindakLanjut;
    private String idProyek;

    public String getIdLaporan() { return idLaporan; }
    public void setIdLaporan(String idLaporan) { this.idLaporan = idLaporan; }

    public String getTanggalLaporan() { return tanggalLaporan; }
    public void setTanggalLaporan(String tanggalLaporan) { this.tanggalLaporan = tanggalLaporan; }

    public String getJenisKendala() { return jenisKendala; }
    public void setJenisKendala(String jenisKendala) { this.jenisKendala = jenisKendala; }

    public String getDeskripsi() { return deskripsi; }
    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }

    public String getStatusTindakLanjut() { return statusTindakLanjut; }
    public void setStatusTindakLanjut(String statusTindakLanjut) { this.statusTindakLanjut = statusTindakLanjut; }

    public String getIdProyek() { return idProyek; }
    public void setIdProyek(String idProyek) { this.idProyek = idProyek; }
}
