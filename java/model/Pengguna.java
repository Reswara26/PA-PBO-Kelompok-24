package model;

public class Pengguna {
    private String idPengguna;
    private String namaPengguna;
    private String username;
    private String password;
    private String kontak;
    private String proyekIdProyek; // FK ke proyek aktif

    public String getIdPengguna() { return idPengguna; }
    public void setIdPengguna(String idPengguna) { this.idPengguna = idPengguna; }

    public String getNamaPengguna() { return namaPengguna; }
    public void setNamaPengguna(String namaPengguna) { this.namaPengguna = namaPengguna; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getKontak() { return kontak; }
    public void setKontak(String kontak) { this.kontak = kontak; }

    public String getProyekIdProyek() { return proyekIdProyek; }
    public void setProyekIdProyek(String proyekIdProyek) { this.proyekIdProyek = proyekIdProyek; }
}
