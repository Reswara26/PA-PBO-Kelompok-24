package model;

public class Kontraktor extends Pengguna {
    private String namaPerusahaan;
    private String penanggungJawab;

    public String getNamaPerusahaan() { return namaPerusahaan; }
    public void setNamaPerusahaan(String namaPerusahaan) { this.namaPerusahaan = namaPerusahaan; }

    public String getPenanggungJawab() { return penanggungJawab; }
    public void setPenanggungJawab(String penanggungJawab) { this.penanggungJawab = penanggungJawab; }
}
