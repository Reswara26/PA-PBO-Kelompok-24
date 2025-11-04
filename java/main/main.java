package main;

import service.*;
import model.*;
import util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class main {
    private static final Scanner sc = new Scanner(System.in);

    private static final PenggunaController penggunaCtrl = new PenggunaController();
    private static final ProyekController proyekCtrl = new ProyekController();
    private static final ProgresController progresCtrl = new ProgresController();
    private static final PengeluaranController pengeluaranCtrl = new PengeluaranController();
    private static final LaporanController laporanCtrl = new LaporanController();

    public static void main(String[] args) {
        while (true) {
            clear();
            System.out.println("============================================");
            System.out.println("   SISTEM MANAJEMEN PROYEK KONSTRUKSI");
            System.out.println("                (SIMANPROF) CLI");
            System.out.println("============================================");
            String username = InputValidator.requireNonEmpty(sc, "Username: ");
            String password = InputValidator.requireNonEmpty(sc, "Password: ");

            Pengguna akun = penggunaCtrl.login(username, password);
            if (akun == null) {
                System.out.println("❌ Login gagal. Periksa username/password.");
                if (!promptYes("Coba login lagi?")) return;
                continue;
            }

            if (akun instanceof Admin) {
                runAdmin((Admin) akun);
            } else if (akun instanceof Kontraktor) {
                runKontraktor((Kontraktor) akun);
            } else {
                System.out.println("Role tidak dikenali. Hubungi admin.");
                if (!promptYes("Kembali ke login?")) return;
            }
        }
    }

    /* ========================= ADMIN ========================= */
    private static void runAdmin(Admin admin) {
        while (true) {
            clear();
            System.out.println("=== MENU ADMIN ===");
            System.out.println("1. Kelola Proyek (update semua)");
            System.out.println("2. Kelola Pengeluaran (lihat)");
            System.out.println("3. Kelola Progres (lihat)");
            System.out.println("4. Kelola Laporan (update status saja)");
            System.out.println("5. Logout");
            System.out.println("6. Close Aplikasi");
            System.out.print("Pilih: ");
            String pilih = sc.nextLine().trim();

            switch (pilih) {
                case "1": adminKelolaProyek(admin); break;
                case "2": adminKelolaPengeluaran(admin); break;
                case "3": adminKelolaProgres(admin); break;
                case "4": adminKelolaLaporan(admin); break;
                case "5": return;
                case "6": System.exit(0); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }


private static void adminKelolaProyek(Admin admin) {
    while (true) {
        clear();
        Proyek p = proyekCtrl.getByPengguna(admin.getIdPengguna());
        System.out.println("=== KELOLA PROYEK (ADMIN: UPDATE SEMUA) ===");
        if (p == null) {
            System.out.println("Belum ada proyek aktif.");
            if (backOrHome()) return; else continue;
        }

        tampilProyek(p);
        System.out.println("\nAksi: 1.Update Semua  |  0.Kembali");
        System.out.print("Pilih: ");
        String x = sc.nextLine().trim();
        if ("0".equals(x)) return;

        if ("1".equals(x)) {
            System.out.println("\n-- Data Saat Ini --");
            tampilProyek(p);

            System.out.println("\n-- Masukkan Perubahan --");
            p.setNamaProyek(InputValidator.requireNonEmpty(sc, "Nama proyek baru: "));
            p.setLokasi(InputValidator.requireNonEmpty(sc, "Lokasi baru: "));
            p.setTanggalMulai(InputValidator.requireDate(sc, "Tanggal Mulai (YYYY-MM-DD): "));
            p.setTanggalSelesai(InputValidator.requireDate(sc, "Tanggal Selesai (YYYY-MM-DD): "));
            p.setAnggaran(InputValidator.requireDouble(sc, "Anggaran: "));
            p.setStatus(InputValidator.requireNonEmpty(sc, "Status baru: "));

            boolean ok = proyekCtrl.edit(p);
            System.out.println(ok ? "✅ Proyek berhasil diperbarui." : "❌ Gagal memperbarui proyek.");

            // tampilkan data terbaru
            System.out.println("\n-- Data Proyek Terbaru --");
            Proyek after = proyekCtrl.getByPengguna(admin.getIdPengguna());
            tampilProyek(after);

            if (promptYes("Kembali ke menu utama?")) return;
        }
    }
}

        private static void adminKelolaPengeluaran(Admin admin) {
            clear();
            Proyek p = proyekCtrl.getByPengguna(admin.getIdPengguna());
            System.out.println("=== KELOLA PENGELUARAN (ADMIN: LIHAT) ===");
            if (p == null) {
                System.out.println("Belum ada proyek aktif.");
                backOrHome();
                return;
            }
            tampilPengeluaran(pengeluaranCtrl.getByProyek(p.getIdProyek()));
            System.out.println("\nTekan Enter untuk kembali...");
            sc.nextLine();
        }

    private static void adminKelolaProgres(Admin admin) {
        clear();
        Proyek p = proyekCtrl.getByPengguna(admin.getIdPengguna());
        System.out.println("=== KELOLA PROGRES (ADMIN: LIHAT) ===");
        if (p == null) {
            System.out.println("Belum ada proyek aktif.");
            backOrHome();
            return;
        }
        List<Progres> list = progresCtrl.getByProyek(p.getIdProyek());
        tampilProgres(list);
        System.out.println("\nTekan Enter untuk kembali...");
        sc.nextLine();
    }

    private static void adminKelolaLaporan(Admin admin) {
        while (true) {
            clear();
            Proyek p = proyekCtrl.getByPengguna(admin.getIdPengguna());
            System.out.println("=== KELOLA LAPORAN (ADMIN: UPDATE STATUS) ===");
            if (p == null) {
                System.out.println("Belum ada proyek aktif.");
                if (backOrHome()) return; else continue;
            }

            List<Laporan> list = laporanCtrl.getByProyek(p.getIdProyek());
            tampilLaporan(list);

            System.out.println("\nAksi: 1.Update Status  |  0.Kembali");
            System.out.print("Pilih: ");
            String a = sc.nextLine().trim();
            if ("0".equals(a)) return;

            if ("1".equals(a)) {
                String id = InputValidator.requireNonEmpty(sc, "ID Laporan: ");
                Laporan lap = laporanCtrl.getById(id);
                if (lap == null) {
                    System.out.println("❌ Laporan tidak ditemukan.");
                    pause();
                    continue;
                }

                System.out.println("\nStatus saat ini: " + nz(lap.getStatusTindakLanjut()));
                System.out.println("Pilihan status tindak lanjut:");
                System.out.println("1. Dalam tindak lanjut");
                System.out.println("2. Selesai");
                System.out.print("Pilih: ");
                String opt = sc.nextLine().trim();
                String statusBaru = "2".equals(opt) ? "Selesai" : "Dalam tindak lanjut";
                lap.setStatusTindakLanjut(statusBaru);

                boolean ok = laporanCtrl.edit(lap);
                System.out.println(ok ? "✅ Status laporan diperbarui." : "❌ Gagal memperbarui status.");

                // Tampilkan data terbaru
                System.out.println("\n-- Data Laporan Terbaru --");
                tampilLaporan(laporanCtrl.getByProyek(p.getIdProyek()));

                if (promptYes("Kembali ke menu utama?")) return;
            }
        }
    }

    /* ========================= KONTRAKTOR ========================= */
    private static void runKontraktor(Kontraktor k) {
        while (true) {
            clear();
            System.out.println("=== MENU KONTRAKTOR ===");
            System.out.println("1. Kelola Proyek (lihat + tambah)");
            System.out.println("2. Kelola Progres (lihat + tambah + update)");
            System.out.println("3. Kelola Pengeluaran (lihat + tambah + update)");
            System.out.println("4. Kelola Laporan Kendala (tambah saja)");
            System.out.println("5. Logout");
            System.out.println("6. Close Aplikasi");
            System.out.print("Pilih: ");
            String pilih = sc.nextLine().trim();

            switch (pilih) {
                case "1": kontraktorKelolaProyek(k); break;
                case "2": kontraktorKelolaProgres(k); break;
                case "3": kontraktorKelolaPengeluaran(k); break;
                case "4": kontraktorKelolaLaporan(k); break;
                case "5": return;
                case "6": System.exit(0); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void kontraktorKelolaProyek(Kontraktor k) {
        while (true) {
            clear();
            Proyek aktif = proyekCtrl.getByPengguna(k.getIdPengguna());
            System.out.println("=== KELOLA PROYEK (KONTRAKTOR) ===");
            System.out.println("Proyek aktif saat ini:");
            if (aktif == null) System.out.println("(Belum ada proyek aktif)");
            else tampilProyek(aktif);

            System.out.println("\nAksi: 1.Tambah Proyek Baru (jadikan aktif)  |  0.Kembali");
            System.out.print("Pilih: ");
            String p = sc.nextLine().trim();
            if ("0".equals(p)) return;

            if ("1".equals(p)) {
                Proyek pr = new Proyek();
                pr.setIdProyek(GenerateID.nextId("proyek", "id_proyek", "P"));
                pr.setNamaProyek(InputValidator.requireNonEmpty(sc, "Nama proyek: "));
                pr.setLokasi(InputValidator.requireNonEmpty(sc, "Lokasi: "));
                pr.setTanggalMulai(InputValidator.requireDate(sc, "Tgl Mulai (YYYY-MM-DD): "));
                pr.setTanggalSelesai(InputValidator.requireDate(sc, "Tgl Selesai (YYYY-MM-DD): "));
                pr.setAnggaran(InputValidator.requireDouble(sc, "Anggaran: "));
                pr.setStatus(InputValidator.requireNonEmpty(sc, "Status: "));

                if (proyekCtrl.tambah(pr)) {
                    boolean link = penggunaCtrl.setProyekAktif(k.getIdPengguna(), pr.getIdProyek());
                    System.out.println(link ? "✅ Proyek ditambahkan & di-set aktif." : "❌ Ditambahkan, tapi gagal set aktif.");
                } else {
                    System.out.println("❌ Gagal menambah proyek.");
                }

                // Tampilkan data terbaru
                System.out.println("\n-- Proyek Aktif Saat Ini --");
                tampilProyek(proyekCtrl.getByPengguna(k.getIdPengguna()));

                if (promptYes("Kembali ke menu utama?")) return;
            }
        }
    }

    private static void kontraktorKelolaProgres(Kontraktor k) {
        while (true) {
            clear();
            Proyek p = proyekCtrl.getByPengguna(k.getIdPengguna());
            System.out.println("=== KELOLA PROGRES (KONTRAKTOR) ===");
            if (p == null) { System.out.println("Belum ada proyek aktif."); if (backOrHome()) return; else continue; }

            List<Progres> list = progresCtrl.getByProyek(p.getIdProyek());
            tampilProgres(list);

            System.out.println("\nAksi: 1.Tambah  |  2.Update  |  0.Kembali");
            System.out.print("Pilih: ");
            String a = sc.nextLine().trim();
            if ("0".equals(a)) return;

            if ("1".equals(a)) {
                Progres pr = new Progres();
                pr.setIdProgres(GenerateID.nextId("progres", "id_progres", "G"));
                pr.setIdProyek(p.getIdProyek());
                pr.setTanggalUpdate(InputValidator.requireDate(sc, "Tanggal update (YYYY-MM-DD): "));
                pr.setDeskripsi(InputValidator.requireNonEmpty(sc, "Deskripsi: "));
                pr.setPersentaseSelesai(InputValidator.requireDouble(sc, "Persentase selesai (0-100): "));

                boolean ok = progresCtrl.tambah(pr);
                System.out.println(ok ? "✅ Progres ditambahkan." : "❌ Gagal menambah progres.");

                // Tampilkan data terbaru
                System.out.println("\n-- Data Progres Terbaru --");
                tampilProgres(progresCtrl.getByProyek(p.getIdProyek()));

                if (promptYes("Kembali ke menu utama?")) return;

            } else if ("2".equals(a)) {
                String id = InputValidator.requireNonEmpty(sc, "ID Progres: ");
                Progres ada = progresCtrl.getById(id);
                if (ada == null) {
                    System.out.println("❌ Progres tidak ditemukan.");
                    pause();
                    continue;
                }

                System.out.println("\n-- Data Lama --");
                System.out.printf("Tanggal:%s | Deskripsi:%s | %.1f%%%n",
                        nz(ada.getTanggalUpdate()), nz(ada.getDeskripsi()), ada.getPersentaseSelesai());

                ada.setTanggalUpdate(InputValidator.requireDate(sc, "Tanggal baru (YYYY-MM-DD): "));
                ada.setDeskripsi(InputValidator.requireNonEmpty(sc, "Deskripsi baru: "));
                ada.setPersentaseSelesai(InputValidator.requireDouble(sc, "Persentase baru (0-100): "));

                boolean ok = progresCtrl.edit(ada);
                System.out.println(ok ? "✅ Progres diupdate." : "❌ Gagal update progres.");

                // Tampilkan data terbaru
                System.out.println("\n-- Data Progres Terbaru --");
                tampilProgres(progresCtrl.getByProyek(p.getIdProyek()));

                if (promptYes("Kembali ke menu utama?")) return;
            }
        }
    }

    private static void kontraktorKelolaPengeluaran(Kontraktor k) {
        while (true) {
            clear();
            Proyek p = proyekCtrl.getByPengguna(k.getIdPengguna());
            System.out.println("=== KELOLA PENGELUARAN (KONTRAKTOR) ===");
            if (p == null) { System.out.println("Belum ada proyek aktif."); if (backOrHome()) return; else continue; }

            List<Pengeluaran> list = pengeluaranCtrl.getByProyek(p.getIdProyek());
            tampilPengeluaran(list);

            System.out.println("\nAksi: 1.Tambah  |  2.Update  |  0.Kembali");
            System.out.print("Pilih: ");
            String a = sc.nextLine().trim();
            if ("0".equals(a)) return;

            if ("1".equals(a)) {
                Pengeluaran pe = new Pengeluaran();
                pe.setIdPengeluaran(GenerateID.nextId("pengeluaran", "id_pengeluaran", "E"));
                pe.setIdProyek(p.getIdProyek());
                pe.setTanggalPengeluaran(InputValidator.requireDate(sc, "Tanggal (YYYY-MM-DD): "));
                pe.setKeterangan(InputValidator.requireNonEmpty(sc, "Keterangan: "));
                pe.setJumlah(InputValidator.requireDouble(sc, "Jumlah: "));
                pe.setKategori(InputValidator.requireNonEmpty(sc, "Kategori: "));

                boolean ok = pengeluaranCtrl.tambah(pe);
                System.out.println(ok ? "✅ Pengeluaran ditambahkan." : "❌ Gagal menambah pengeluaran.");

                // Tampilkan data terbaru
                System.out.println("\n-- Data Pengeluaran Terbaru --");
                tampilPengeluaran(pengeluaranCtrl.getByProyek(p.getIdProyek()));

                if (promptYes("Kembali ke menu utama?")) return;

            } else if ("2".equals(a)) {
                String id = InputValidator.requireNonEmpty(sc, "ID Pengeluaran: ");
                Pengeluaran ada = pengeluaranCtrl.getById(id);
                if (ada == null) {
                    System.out.println("❌ Pengeluaran tidak ditemukan.");
                    pause();
                    continue;
                }

                ada.setTanggalPengeluaran(InputValidator.requireDate(sc, "Tanggal baru (YYYY-MM-DD): "));
                ada.setKeterangan(InputValidator.requireNonEmpty(sc, "Keterangan baru: "));
                ada.setJumlah(InputValidator.requireDouble(sc, "Jumlah baru: "));
                ada.setKategori(InputValidator.requireNonEmpty(sc, "Kategori baru: "));

                boolean ok = pengeluaranCtrl.edit(ada);
                System.out.println(ok ? "✅ Pengeluaran diupdate." : "❌ Gagal update pengeluaran.");

                // Tampilkan data terbaru
                System.out.println("\n-- Data Pengeluaran Terbaru --");
                tampilPengeluaran(pengeluaranCtrl.getByProyek(p.getIdProyek()));

                if (promptYes("Kembali ke menu utama?")) return;
            }
        }
    }

    private static void kontraktorKelolaLaporan(Kontraktor k) {
        while (true) {
            clear();
            Proyek p = proyekCtrl.getByPengguna(k.getIdPengguna());
            System.out.println("=== KELOLA LAPORAN KENDALA (KONTRAKTOR: TAMBAH) ===");
            if (p == null) { System.out.println("Belum ada proyek aktif."); if (backOrHome()) return; else continue; }

            List<Laporan> list = laporanCtrl.getByProyek(p.getIdProyek());
            tampilLaporan(list);

            System.out.println("\nAksi: 1.Tambah  |  0.Kembali");
            System.out.print("Pilih: ");
            String a = sc.nextLine().trim();
            if ("0".equals(a)) return;

            if ("1".equals(a)) {
                Laporan l = new Laporan();
                l.setIdLaporan(GenerateID.nextId("laporan", "id_laporan", "L"));
                l.setIdProyek(p.getIdProyek());
                l.setTanggalLaporan(InputValidator.requireDate(sc, "Tanggal (YYYY-MM-DD): "));
                l.setJenisKendala(InputValidator.requireNonEmpty(sc, "Jenis kendala: "));
                l.setDeskripsi(InputValidator.requireNonEmpty(sc, "Deskripsi: "));
                // status auto (pendek agar aman dari truncation)
                l.setStatusTindakLanjut("Baru");

                boolean ok = laporanCtrl.tambah(l);
                System.out.println(ok ? "✅ Laporan ditambahkan." : "❌ Gagal menambah laporan.");

                // Tampilkan data terbaru
                System.out.println("\n-- Data Laporan Terbaru --");
                tampilLaporan(laporanCtrl.getByProyek(p.getIdProyek()));

                if (promptYes("Kembali ke menu utama?")) return;
            }
        }
    }

    /* ========================= TAMPILAN ========================= */
    private static void tampilProyek(Proyek p) {
        if (p == null) { System.out.println("(Tidak ada proyek)"); return; }
        System.out.printf("ID:%s | Nama:%s | Lokasi:%s | Mulai:%s | Selesai:%s | Anggaran:%.2f | Status:%s%n",
                nz(p.getIdProyek()), nz(p.getNamaProyek()), nz(p.getLokasi()),
                nz(p.getTanggalMulai()), nz(p.getTanggalSelesai()),
                p.getAnggaran(), nz(p.getStatus()));
    }

    private static void tampilProgres(List<Progres> list) {
        if (list == null || list.isEmpty()) { System.out.println("(Belum ada progres)"); return; }
        for (Progres pr : list) {
            System.out.printf("ID:%s | Proyek:%s | Tanggal:%s | %.1f%% | %s%n",
                    nz(pr.getIdProgres()), nz(pr.getIdProyek()), nz(pr.getTanggalUpdate()),
                    pr.getPersentaseSelesai(), nz(pr.getDeskripsi()));
        }
    }

    private static void tampilPengeluaran(List<Pengeluaran> list) {
        if (list == null || list.isEmpty()) { System.out.println("(Belum ada pengeluaran)"); return; }
        for (Pengeluaran pe : list) {
            System.out.printf("ID:%s | Proyek:%s | Tanggal:%s | Jumlah:%.2f | %s | Kategori:%s%n",
                    nz(pe.getIdPengeluaran()), nz(pe.getIdProyek()),
                    nz(pe.getTanggalPengeluaran()), pe.getJumlah(),
                    nz(pe.getKeterangan()), nz(pe.getKategori()));
        }
    }

    private static void tampilLaporan(List<Laporan> list) {
        if (list == null || list.isEmpty()) { System.out.println("(Belum ada laporan)"); return; }
        for (Laporan l : list) {
            System.out.printf("ID:%s | Proyek:%s | Tanggal:%s | Jenis:%s | Status:%s | %s%n",
                    nz(l.getIdLaporan()), nz(l.getIdProyek()), nz(l.getTanggalLaporan()),
                    nz(l.getJenisKendala()), nz(l.getStatusTindakLanjut()), nz(l.getDeskripsi()));
        }
    }

    /* ========================= UTIL ========================= */
    private static boolean backOrHome() {
        System.out.println("\n0. Kembali   |   1. Menu Utama");
        System.out.print("Pilih: ");
        return "1".equals(sc.nextLine().trim());
    }

    private static boolean promptYes(String msg) {
        System.out.print("\n" + msg + " (y/n): ");
        String a = sc.nextLine().trim().toLowerCase();
        return a.equals("y") || a.equals("ya");
    }

    private static void pause() {
        System.out.println("\nTekan Enter untuk lanjut...");
        sc.nextLine();
    }

    private static void clear() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception ignored) {}
    }

    private static String nz(String s) { return (s == null || s.isEmpty()) ? "-" : s; }
}
