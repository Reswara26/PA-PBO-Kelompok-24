-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 30 Okt 2025 pada 18.41
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `simanprof`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id_pengguna` char(5) NOT NULL,
  `jabatan_admin` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_pengguna`, `jabatan_admin`) VALUES
('U0001', 'Admin Back Office'),
('U0002', 'Admin Back Office'),
('U0003', 'Admin Back Office'),
('U0004', 'Admin Back Office'),
('U0005', 'Admin Back Office'),
('U0006', 'Admin Back Office'),
('U0007', 'Admin Back Office'),
('U0008', 'Admin Back Office'),
('U0009', 'Admin Back Office'),
('U0010', 'Admin Back Office'),
('U0011', 'Admin Back Office'),
('U0012', 'Admin Back Office'),
('U0013', 'Admin Back Office'),
('U0014', 'Admin Back Office'),
('U0015', 'Admin Back Office'),
('U0016', 'Admin Back Office'),
('U0017', 'Admin Back Office'),
('U0018', 'Admin Back Office'),
('U0019', 'Admin Back Office'),
('U0020', 'Admin Back Office'),
('U0021', 'Admin Back Office'),
('U0022', 'Admin Back Office'),
('U0023', 'Admin Back Office'),
('U0024', 'Admin Back Office'),
('U0025', 'Admin Back Office'),
('U0026', 'Admin Back Office'),
('U0027', 'Admin Back Office'),
('U0028', 'Admin Back Office'),
('U0029', 'Admin Back Office'),
('U0030', 'Admin Back Office'),
('U0031', 'Admin Back Office'),
('U0032', 'Admin Back Office'),
('U0033', 'Admin Back Office'),
('U0034', 'Admin Back Office'),
('U0035', 'Admin Back Office'),
('U0036', 'Admin Back Office'),
('U0037', 'Admin Back Office'),
('U0038', 'Admin Back Office'),
('U0039', 'Admin Back Office'),
('U0040', 'Admin Back Office');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kontraktor`
--

CREATE TABLE `kontraktor` (
  `id_pengguna` char(5) NOT NULL,
  `nama_perusahaan` varchar(100) NOT NULL,
  `penanggung_jawab` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kontraktor`
--

INSERT INTO `kontraktor` (`id_pengguna`, `nama_perusahaan`, `penanggung_jawab`) VALUES
('U0041', 'PT Sabat Konstruksi', 'R. Saputra'),
('U0042', 'CV Citra Teknik', 'H. Hidayat'),
('U0043', 'PT Borneo Karya', 'M. Prabowo'),
('U0044', 'CV Mahakam Jaya', 'W. Maulana'),
('U0045', 'PT Sentosa Abadi', 'D. Wibowo'),
('U0046', 'CV Karya Mandiri', 'M. Rudi'),
('U0047', 'PT Nusantara Beton', 'R. Prasetyo'),
('U0048', 'CV Karya Sejahtera', 'L. Kurnia'),
('U0049', 'PT Samudra Teknik', 'B. Akbar'),
('U0050', 'CV Prima Konstruksi', 'A. Santoso'),
('U0051', 'PT Mahakam Steel', 'A. Firman'),
('U0052', 'CV Cipta Karya', 'D. Wahyudi'),
('U0053', 'PT Daya Konstruksi', 'A. Rahman'),
('U0054', 'CV Lancar Jaya', 'M. Satria'),
('U0055', 'PT Pilar Utama', 'M. Rifdani'),
('U0056', 'CV Sinar Benua', 'R. Saputro'),
('U0057', 'PT Mega Konstruksi', 'Y. Nugraha'),
('U0058', 'CV Bintang Timur', 'G. Satria'),
('U0059', 'PT Jaya Borneo', 'S. Rahman'),
('U0060', 'CV Sejahtera Teknik', 'M. Putra'),
('U0061', 'PT Beton Mandiri', 'L. Zarya'),
('U0062', 'CV Artha Teknik', 'F. Aditya'),
('U0063', 'PT Prima Teknik', 'D. Fadillah'),
('U0064', 'CV Makmur Jaya', 'R. Nurdin'),
('U0065', 'PT Sejahtera Kontruksi', 'C. Habibie'),
('U0066', 'CV Multi Karya', 'N. Pranudya'),
('U0067', 'PT Maha Karya', 'H. Husein'),
('U0068', 'CV Berkat Konstruksi', 'B. Pradana'),
('U0069', 'PT Cakra Mandiri', 'A. Ridwan'),
('U0070', 'CV Karya Teknik', 'S. Prasetya'),
('U0071', 'PT Sempurna Teknik', 'G. Kurnia'),
('U0072', 'CV Artha Mandiri', 'R. Sasmito'),
('U0073', 'PT Benuo Etam', 'M. Rizaldi'),
('U0074', 'CV Mandiri Teknik', 'T. Mahendra'),
('U0075', 'PT Karya Unggul', 'A. Wibisono'),
('U0076', 'CV Cahaya Timur', 'N. Firmansyah'),
('U0077', 'PT Pilar Nusantara', 'Y. Arifin'),
('U0078', 'CV Surya Teknik', 'I. Sulaiman'),
('U0079', 'PT Mitra Jaya', 'E. Rahmat'),
('U0080', 'CV Global Konstruksi', 'A. Saputra');

-- --------------------------------------------------------

--
-- Struktur dari tabel `laporan`
--

CREATE TABLE `laporan` (
  `id_laporan` char(5) NOT NULL,
  `tanggal_laporan` date NOT NULL,
  `jenis_kendala` varchar(100) NOT NULL,
  `deskripsi` text NOT NULL,
  `status_tindak_lanjut` varchar(30) NOT NULL,
  `Proyek_id_proyek` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `laporan`
--

INSERT INTO `laporan` (`id_laporan`, `tanggal_laporan`, `jenis_kendala`, `deskripsi`, `status_tindak_lanjut`, `Proyek_id_proyek`) VALUES
('L0001', '2023-08-03', 'Cuaca', 'Hujan lebat menghambat pengaspalan', 'Dalam Tindak Lanjut', 'P0001'),
('L0002', '2023-09-12', 'Material', 'Keterlambatan pasokan pipa', 'Selesai', 'P0002'),
('L0003', '2023-10-05', 'Peralatan', 'Vibro roller rusak ringan', 'Selesai', 'P0003'),
('L0004', '2023-11-20', 'Material', 'Pencatatan stok penanganan trotoar', 'Selesai', 'P0004'),
('L0005', '2023-12-17', 'Cuaca', 'Genangan saat galian drainase', 'Selesai', 'P0007'),
('L0006', '2024-01-15', 'Material', 'Batu split tidak sesuai spek', 'Dalam Tindak Lanjut', 'P0008'),
('L0007', '2024-02-18', 'Cuaca', 'Hujan deras berkala', 'Dalam Tindak Lanjut', 'P0010'),
('L0008', '2024-03-09', 'Teknis', 'Pipa jajar perlu revisi layout', 'Selesai', 'P0011'),
('L0009', '2024-04-10', 'Material', 'Vibro antri sewa alat', 'Dalam Tindak Lanjut', 'P0013'),
('L0010', '2024-05-01', 'Koordinasi', 'Satu warga setempat belum menyetujui', 'Selesai', 'P0014'),
('L0011', '2024-06-12', 'Teknis', 'Kabel sling impor terlambat', 'Selesai', 'P0016'),
('L0012', '2024-07-20', 'Administrasi', 'Keterlambatan dokumen perencanaan', 'Selesai', 'P0018'),
('L0013', '2024-08-05', 'Lingkungan', 'Rekomendasi 3D dari dinas', 'Dalam Tindak Lanjut', 'P0019'),
('L0014', '2024-09-11', 'Material', 'Beton tumpah di jalan utama', 'Dalam Tindak Lanjut', 'P0020'),
('L0015', '2024-10-01', 'Desain', 'Dimensi box culvert disesuaikan', 'Selesai', 'P0021'),
('L0016', '2024-11-09', 'Koordinasi', 'Penjadwalan rapat teknis', 'Selesai', 'P0022'),
('L0017', '2024-12-10', 'Struktur', 'Evaluasi jembatan bawah tanah', 'Dalam Tindak Lanjut', 'P0023'),
('L0018', '2025-01-20', 'Aset', 'Inventaris utilitas bahan tanah', 'Dalam Tindak Lanjut', 'P0024'),
('L0019', '2025-02-15', 'Teknis', 'Tumpahan bahan baku hujan', 'Selesai', 'P0025'),
('L0020', '2025-03-03', 'Struktur', 'Penyesuaian trase lingkar luar', 'Pekerjaan Dilanjutkan', 'P0026'),
('L0021', '2025-04-07', 'Koordinasi', 'Hasil uji survey topografi', 'Selesai', 'P0027'),
('L0022', '2025-05-11', 'Material', 'Keterlambatan material proyek', 'Selesai', 'P0028'),
('L0023', '2025-06-09', 'Peralatan', 'Wire rope pengganti', 'Selesai', 'P0029'),
('L0024', '2025-07-13', 'Desain', 'Sambungan talang air', 'Selesai', 'P0030'),
('L0025', '2025-08-10', 'Teknis', 'Jalan kerja khusus sekolah', 'Selesai', 'P0031'),
('L0026', '2025-09-14', 'Lingkungan', 'Geobag tebing 1%', 'Selesai', 'P0032'),
('L0027', '2025-10-03', 'Struktur', 'Rekonstruksi trotoar beton', 'Selesai', 'P0033'),
('L0028', '2025-10-25', 'Koordinasi', 'Evaluasi gambar bestek', 'Selesai', 'P0034'),
('L0029', '2025-11-12', 'Material', 'Keterlambatan semen tambahan', 'Dalam Tindak Lanjut', 'P0035'),
('L0030', '2025-11-25', 'Peralatan', 'Kabel listrik utama rusak', 'Dalam Tindak Lanjut', 'P0036'),
('L0031', '2025-12-01', 'Teknis', 'Pelurusan pipa sambungan', 'Selesai', 'P0037'),
('L0032', '2025-12-20', 'Struktur', 'Revisi dimensi drainase', 'Selesai', 'P0038'),
('L0033', '2026-01-05', 'Material', 'Keterlambatan bahan utama', 'Selesai', 'P0039'),
('L0034', '2026-01-20', 'Peralatan', 'Komponen alat bor rusak', 'Selesai', 'P0040'),
('L0035', '2026-02-11', 'Teknis', 'Penyesuaian sudut cor', 'Selesai', 'P0031'),
('L0036', '2026-03-02', 'Koordinasi', 'Pengiriman gambar revisi', 'Selesai', 'P0032'),
('L0037', '2026-03-21', 'Material', 'Kurangnya bahan baja tulangan', 'Dalam Tindak Lanjut', 'P0033'),
('L0038', '2026-04-04', 'Peralatan', 'Gangguan mesin las', 'Selesai', 'P0034'),
('L0039', '2026-04-28', 'Teknis', 'Uji struktur lantai jembatan', 'Selesai', 'P0035'),
('L0040', '2026-05-01', 'Material', 'U-ditch revisi dimensi', 'Selesai', 'P0040');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran`
--

CREATE TABLE `pengeluaran` (
  `id_pengeluaran` char(5) NOT NULL,
  `tanggal_pengeluaran` date NOT NULL,
  `keterangan` varchar(200) NOT NULL,
  `jumlah` decimal(15,2) NOT NULL,
  `kategori` varchar(50) NOT NULL,
  `Proyek_id_proyek` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pengeluaran`
--

INSERT INTO `pengeluaran` (`id_pengeluaran`, `tanggal_pengeluaran`, `keterangan`, `jumlah`, `kategori`, `Proyek_id_proyek`) VALUES
('E0001', '2024-02-15', 'Pembelian aspal cair awal', 15000000.00, 'Material', 'P0001'),
('E0002', '2024-03-01', 'Upah kerja bulan Maret', 8000000.00, 'Upah', 'P0002'),
('E0003', '2024-03-10', 'Sewa alat berat 1 minggu', 12000000.00, 'Sewa Alat', 'P0003'),
('E0004', '2024-03-20', 'Pembelian batu split', 7000000.00, 'Material', 'P0004'),
('E0005', '2024-04-01', 'Transport material', 6000000.00, 'Transportasi', 'P0005'),
('E0006', '2024-04-10', 'Upah tukang borongan', 10000000.00, 'Upah', 'P0006'),
('E0007', '2024-05-01', 'Sewa crane kecil', 13000000.00, 'Sewa Alat', 'P0007'),
('E0008', '2024-05-15', 'Pembelian besi beton', 15500000.00, 'Material', 'P0008'),
('E0009', '2024-06-01', 'Upah lembur harian', 5500000.00, 'Upah', 'P0009'),
('E0010', '2024-06-25', 'Pembelian aspal hotmix', 16000000.00, 'Material', 'P0010'),
('E0011', '2024-07-15', 'Sewa excavator kecil', 9000000.00, 'Sewa Alat', 'P0011'),
('E0012', '2024-08-01', 'Pengadaan pipa PVC', 8000000.00, 'Material', 'P0012'),
('E0013', '2024-08-25', 'Sewa dump truck', 7500000.00, 'Transportasi', 'P0013'),
('E0014', '2024-09-10', 'Upah pekerja harian', 9500000.00, 'Upah', 'P0014'),
('E0015', '2024-09-30', 'Pembelian aspal curah', 12500000.00, 'Material', 'P0015'),
('E0016', '2024-10-10', 'Pengadaan batu kerikil', 6500000.00, 'Material', 'P0016'),
('E0017', '2024-10-30', 'Upah mandor proyek', 13000000.00, 'Upah', 'P0017'),
('E0018', '2024-11-15', 'Sewa alat pemadat tanah', 6000000.00, 'Sewa Alat', 'P0018'),
('E0019', '2024-12-01', 'Upah pekerja tambahan', 7000000.00, 'Upah', 'P0019'),
('E0020', '2024-12-15', 'Pembelian pipa HDPE', 8500000.00, 'Material', 'P0020'),
('E0021', '2025-01-10', 'Sewa truk pengangkut', 6000000.00, 'Transportasi', 'P0021'),
('E0022', '2025-02-01', 'Upah pengawas lapangan', 5000000.00, 'Upah', 'P0022'),
('E0023', '2025-02-20', 'Pembelian semen', 6500000.00, 'Material', 'P0023'),
('E0024', '2025-03-10', 'Sewa dump truck', 8500000.00, 'Transportasi', 'P0024'),
('E0025', '2025-03-25', 'Upah kerja struktur', 7000000.00, 'Upah', 'P0025'),
('E0026', '2025-04-05', 'Pengukuran awal proyek', 6000000.00, 'Jasa', 'P0026'),
('E0027', '2025-04-20', 'Studi trafik', 5500000.00, 'Jasa', 'P0027'),
('E0028', '2025-05-05', 'Paving block RW 62', 16000000.00, 'Material', 'P0028'),
('E0029', '2025-05-20', 'Sewa alat penggali', 9000000.00, 'Sewa Alat', 'P0029'),
('E0030', '2025-06-10', 'Pembelian aspal curah', 12500000.00, 'Material', 'P0030'),
('E0031', '2025-06-30', 'Pengadaan drainase beton', 15000000.00, 'Material', 'P0031'),
('E0032', '2025-07-15', 'Sewa alat bor tanah', 6000000.00, 'Sewa Alat', 'P0032'),
('E0033', '2025-08-01', 'Galvan coating drainase', 4500000.00, 'Material', 'P0033'),
('E0034', '2025-08-25', 'Formwork cetakan beton', 10500000.00, 'Material', 'P0034'),
('E0035', '2025-09-10', 'Pemadatan tebing longsor', 6100000.00, 'Material', 'P0035'),
('E0036', '2025-09-30', 'Cetakan U-ditch industri', 21000000.00, 'Material', 'P0036'),
('E0037', '2025-10-15', 'Pengadaan besi baja', 12000000.00, 'Material', 'P0037'),
('E0038', '2025-11-05', 'Gaji surveyor proyek', 8500000.00, 'Upah', 'P0038'),
('E0039', '2025-11-25', 'Pembersihan area proyek', 7500000.00, 'Jasa', 'P0039'),
('E0040', '2025-12-20', 'Upah tukang las', 9500000.00, 'Upah', 'P0040');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengguna`
--

CREATE TABLE `pengguna` (
  `id_pengguna` char(5) NOT NULL,
  `nama_pengguna` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `kontak` varchar(50) NOT NULL,
  `Proyek_id_proyek` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pengguna`
--

INSERT INTO `pengguna` (`id_pengguna`, `nama_pengguna`, `username`, `password`, `kontak`, `Proyek_id_proyek`) VALUES
('U0001', 'Andi Saputra', 'andi.s', 'passAndi01', '0812-0812-0001', 'P0001'),
('U0002', 'Siti Nurhaliza', 'siti.n', 'passSiti02', '0812-0812-0002', 'P0001'),
('U0003', 'Budi Hartono', 'budi.h', 'passBudi03', '0812-0812-0003', 'P0002'),
('U0004', 'Rina Marlina', 'rina.m', 'passRina04', '0812-0812-0004', 'P0002'),
('U0005', 'Joko Pratama', 'joko.p', 'passJoko05', '0812-0812-0005', 'P0003'),
('U0006', 'Maya Sari', 'maya.s', 'passMaya06', '0812-0812-0006', 'P0003'),
('U0007', 'Tono Wijaya', 'tono.w', 'passTono07', '0812-0812-0007', 'P0004'),
('U0008', 'Fitriani Lestari', 'fitri.l', 'passFitri08', '0812-0812-0008', 'P0004'),
('U0009', 'Agus Salim', 'agus.s', 'passAgus09', '0812-0812-0009', 'P0005'),
('U0010', 'Rika Lestari', 'rika.l', 'passRika10', '0812-0812-0010', 'P0005'),
('U0011', 'Hendra Wijaya', 'hendra.w', 'passHendra11', '0812-0812-0011', 'P0006'),
('U0012', 'Dewi Anggraini', 'dewi.a', 'passDewi12', '0812-0812-0012', 'P0006'),
('U0013', 'Rizal Fadli', 'rizal.f', 'passRizal13', '0812-0812-0013', 'P0007'),
('U0014', 'Nina Putri', 'nina.p', 'passNina14', '0812-0812-0014', 'P0007'),
('U0015', 'Adi Nugroho', 'adi.n', 'passAdi15', '0812-0812-0015', 'P0008'),
('U0016', 'Sari Puspita', 'sari.p', 'passSari16', '0812-0812-0016', 'P0008'),
('U0017', 'Faisal Akbar', 'faisal.a', 'passFaisal17', '0812-0812-0017', 'P0009'),
('U0018', 'Lia Kartika', 'lia.k', 'passLia18', '0812-0812-0018', 'P0009'),
('U0019', 'Rifki Ramadhan', 'rifki.r', 'passRifki19', '0812-0812-0019', 'P0010'),
('U0020', 'Wulan Sari', 'wulan.s', 'passWulan20', '0812-0812-0020', 'P0010'),
('U0021', 'Hafidz Pratama', 'hafidz.p', 'passHafidz21', '0812-0812-0021', 'P0011'),
('U0022', 'Aulia Rahma', 'aulia.r', 'passAulia22', '0812-0812-0022', 'P0011'),
('U0023', 'Rendy Saputra', 'rendy.s', 'passRendy23', '0812-0812-0023', 'P0012'),
('U0024', 'Citra Dewi', 'citra.d', 'passCitra24', '0812-0812-0024', 'P0012'),
('U0025', 'Bagus Wibowo', 'bagus.w', 'passBagus25', '0812-0812-0025', 'P0013'),
('U0026', 'Nadya Anindya', 'nadya.a', 'passNadya26', '0812-0812-0026', 'P0013'),
('U0027', 'Doni Kurniawan', 'doni.k', 'passDoni27', '0812-0812-0027', 'P0014'),
('U0028', 'Putri Ayu', 'putri.a', 'passPutri28', '0812-0812-0028', 'P0014'),
('U0029', 'Rama Dwi', 'rama.d', 'passRama29', '0812-0812-0029', 'P0015'),
('U0030', 'Salsa Amelia', 'salsa.a', 'passSalsa30', '0812-0812-0030', 'P0015'),
('U0031', 'Iqbal Maulana', 'iqbal.m', 'passIqbal31', '0812-0812-0031', 'P0016'),
('U0032', 'Nabila Putri', 'nabila.p', 'passNabila32', '0812-0812-0032', 'P0016'),
('U0033', 'Yoga Prasetyo', 'yoga.p', 'passYoga33', '0812-0812-0033', 'P0017'),
('U0034', 'Ayu Lestari', 'ayu.l', 'passAyu34', '0812-0812-0034', 'P0017'),
('U0035', 'Gilang Saputra', 'gilang.s', 'passGilang35', '0812-0812-0035', 'P0018'),
('U0036', 'Febriani', 'febri.a', 'passFebri36', '0812-0812-0036', 'P0018'),
('U0037', 'Kevin Aditya', 'kevin.a', 'passKevin37', '0812-0812-0037', 'P0019'),
('U0038', 'Melati Cahya', 'melati.c', 'passMelati38', '0812-0812-0038', 'P0019'),
('U0039', 'Daffa Alfarizi', 'daffa.a', 'passDaffa39', '0812-0812-0039', 'P0020'),
('U0040', 'Intan Permata', 'intan.p', 'passIntan40', '0812-0812-0040', 'P0020'),
('U0041', 'PT Sabat Konstruksi', 'pt.sabat', 'passKons41', '0812-0812-0041', 'P0001'),
('U0042', 'CV Citra Teknik', 'cv.citra', 'passKons42', '0812-0812-0042', 'P0001'),
('U0043', 'PT Borneo Karya', 'pt.borneo', 'passKons43', '0812-0812-0043', 'P0002'),
('U0044', 'CV Mahakam Jaya', 'cv.mahakam', 'passKons44', '0812-0812-0044', 'P0002'),
('U0045', 'PT Sentosa Abadi', 'pt.sentosa', 'passKons45', '0812-0812-0045', 'P0003'),
('U0046', 'CV Karya Mandiri', 'cv.kmandiri', 'passKons46', '0812-0812-0046', 'P0003'),
('U0047', 'PT Nusantara Beton', 'pt.nbeton', 'passKons47', '0812-0812-0047', 'P0004'),
('U0048', 'CV Karya Sejahtera', 'cv.ksejahtera', 'passKons48', '0812-0812-0048', 'P0004'),
('U0049', 'PT Samudra Teknik', 'pt.samudra', 'passKons49', '0812-0812-0049', 'P0005'),
('U0050', 'CV Prima Konstruksi', 'cv.prima', 'passKons50', '0812-0812-0050', 'P0005'),
('U0051', 'PT Mahakam Steel', 'pt.msteel', 'passKons51', '0812-0812-0051', 'P0006'),
('U0052', 'CV Cipta Karya', 'cv.cipta', 'passKons52', '0812-0812-0052', 'P0006'),
('U0053', 'PT Daya Konstruksi', 'pt.daya', 'passKons53', '0812-0812-0053', 'P0007'),
('U0054', 'CV Lancar Jaya', 'cv.lancar', 'passKons54', '0812-0812-0054', 'P0007'),
('U0055', 'PT Pilar Utama', 'pt.pilar', 'passKons55', '0812-0812-0055', 'P0008'),
('U0056', 'CV Sinar Benua', 'cv.sinar', 'passKons56', '0812-0812-0056', 'P0008'),
('U0057', 'PT Mega Konstruksi', 'pt.mega', 'passKons57', '0812-0812-0057', 'P0009'),
('U0058', 'CV Bintang Timur', 'cv.btimur', 'passKons58', '0812-0812-0058', 'P0009'),
('U0059', 'PT Jaya Borneo', 'pt.jborneo', 'passKons59', '0812-0812-0059', 'P0010'),
('U0060', 'CV Sejahtera Teknik', 'cv.steknik', 'passKons60', '0812-0812-0060', 'P0010'),
('U0061', 'PT Beton Mandiri', 'pt.bmandiri', 'passKons61', '0812-0812-0061', 'P0011'),
('U0062', 'CV Artha Teknik', 'cv.artha', 'passKons62', '0812-0812-0062', 'P0011'),
('U0063', 'PT Prima Teknik', 'pt.primatek', 'passKons63', '0812-0812-0063', 'P0012'),
('U0064', 'CV Makmur Jaya', 'cv.makmur', 'passKons64', '0812-0812-0064', 'P0012'),
('U0065', 'PT Sejahtera Kontruksi', 'pt.skon', 'passKons65', '0812-0812-0065', 'P0013'),
('U0066', 'CV Multi Karya', 'cv.mkarya', 'passKons66', '0812-0812-0066', 'P0013'),
('U0067', 'PT Maha Karya', 'pt.mkarya', 'passKons67', '0812-0812-0067', 'P0014'),
('U0068', 'CV Berkat Konstruksi', 'cv.berkat', 'passKons68', '0812-0812-0068', 'P0014'),
('U0069', 'PT Cakra Mandiri', 'pt.cakra', 'passKons69', '0812-0812-0069', 'P0015'),
('U0070', 'CV Karya Teknik', 'cv.kteknik', 'passKons70', '0812-0812-0070', 'P0015'),
('U0071', 'PT Sempurna Teknik', 'pt.steknik', 'passKons71', '0812-0812-0071', 'P0016'),
('U0072', 'CV Artha Mandiri', 'cv.amandiri', 'passKons72', '0812-0812-0072', 'P0016'),
('U0073', 'PT Benuo Etam', 'pt.betam', 'passKons73', '0812-0812-0073', 'P0017'),
('U0074', 'CV Mandiri Teknik', 'cv.mteknik', 'passKons74', '0812-0812-0074', 'P0017'),
('U0075', 'PT Karya Unggul', 'pt.kunggul', 'passKons75', '0812-0812-0075', 'P0018'),
('U0076', 'CV Cahaya Timur', 'cv.ctimur', 'passKons76', '0812-0812-0076', 'P0018'),
('U0077', 'PT Pilar Nusantara', 'pt.pnusantara', 'passKons77', '0812-0812-0077', 'P0019'),
('U0078', 'CV Surya Teknik', 'cv.steknik', 'passKons78', '0812-0812-0078', 'P0019'),
('U0079', 'PT Mitra Jaya', 'pt.mjaya', 'passKons79', '0812-0812-0079', 'P0020'),
('U0080', 'CV Global Konstruksi', 'cv.gkonstruksi', 'passKons80', '0812-0812-0080', 'P0020');

-- --------------------------------------------------------

--
-- Struktur dari tabel `progres`
--

CREATE TABLE `progres` (
  `id_progres` char(5) NOT NULL,
  `tanggal_update` date NOT NULL,
  `persentase_selesai` decimal(5,2) NOT NULL,
  `deskripsi` text NOT NULL,
  `Proyek_id_proyek` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `progres` (`id_progres`, `tanggal_update`, `persentase_selesai`, `deskripsi`, `Proyek_id_proyek`) VALUES
('G0001','2024-07-10',100.00,'Pengesapan selesai, pengecatan marka tuntas.','P0001'),
('G0002','2024-09-19',80.00,'Pembangunan saluran dan beton kontrapung.','P0002'),
('G0003','2024-08-15',100.00,'Deck dan oprit jembatan terselesaikan.','P0003'),
('G0004','2025-01-07',70.00,'Pengecoran badan jalan 70%, bahu jalan dikeraskan.','P0004'),
('G0005','2025-02-25',65.00,'Motor dan guiding block terpasang.','P0005'),
('G0006','2025-03-10',68.00,'Area los pedagang 65%, atap rangka progres.','P0006'),
('G0007','2025-03-25',60.00,'Drainase kompleks tuntas.','P0007'),
('G0008','2025-04-12',100.00,'Pondasi jembatan kecil selesai.','P0008'),
('G0009','2025-04-30',90.00,'Normalisasi drainase.','P0009'),
('G0010','2025-05-22',100.00,'Pengecoran jalan desa 45%.','P0010'),
('G0011','2025-05-30',80.00,'Pengecoran saluran irigasi utama 68%.','P0011'),
('G0012','2025-06-18',95.00,'Pembangunan saluran irigasi utama.','P0012'),
('G0013','2025-06-25',85.00,'Pengerjaan gelagar jembatan 80%.','P0013'),
('G0014','2025-07-03',70.00,'Penggalian drainase BPM-Silo tahap 1.','P0014'),
('G0015','2025-07-15',60.00,'U-ditch terpasang dan uji alir awal.','P0015'),
('G0016','2025-07-30',100.00,'Perbaikan drainase komplek tuntas.','P0016'),
('G0017','2025-08-05',75.00,'Dokumen perencanaan teknis disusun.','P0017'),
('G0018','2025-08-10',50.00,'Kajian awal hidrologi.','P0018'),
('G0019','2025-08-22',40.00,'Survey topografi dan studi tapak.','P0019'),
('G0020','2025-08-30',30.00,'Rencana trase jalan lingkar.','P0020'),
('G0021','2025-09-01',60.00,'Pembangunan struktur jembatan kavling.','P0021'),
('G0022','2025-09-09',55.00,'Survey jalan lingkungan.','P0022'),
('G0023','2025-09-20',50.00,'Perencanaan trase irigasi.','P0023'),
('G0024','2025-09-30',45.00,'Penyusunan DED sekolah.','P0024'),
('G0025','2025-10-05',70.00,'Survey jalan lingkungan.','P0025'),
('G0026','2025-10-15',60.00,'Pembuatan struktur jalan kavling.','P0026'),
('G0027','2025-10-25',55.00,'Perencanaan trase irigasi.','P0027'),
('G0028','2025-11-05',50.00,'Studi trase lingkar timur.','P0028'),
('G0029','2025-11-15',45.00,'Saluran galian tersusun.','P0029'),
('G0030','2025-11-22',40.00,'Tebing Mahakam terkait.','P0030'),
('G0031','2025-11-28',100.00,'Jembatan mini beroperasi.','P0031'),
('G0032','2025-12-05',70.00,'Perbaikan drainase Veteran 60%.','P0032'),
('G0033','2025-12-15',65.00,'Akses Sekolah base & subbase.','P0033'),
('G0034','2025-12-20',55.00,'Work & formwork beton trotoar.','P0034'),
('G0035','2025-12-25',50.00,'Perkuatan tebing 45%.','P0035'),
('G0036','2025-12-28',45.00,'Cetakan U-ditch industri 50%.','P0036'),
('G0037','2026-01-03',100.00,'Pembangunan drainase utama tuntas.','P0037'),
('G0038','2026-01-10',100.00,'Rekonstruksi jalan veteran selesai.','P0038'),
('G0039','2026-01-15',55.00,'Perataan tanah akses industri.','P0039'),
('G0040','2026-01-20',60.00,'U-ditch industri 50%, progress.','P0040');

-- --------------------------------------------------------

--
-- Struktur dari tabel `proyek`
--

CREATE TABLE `proyek` (
  `id_proyek` char(5) NOT NULL,
  `nama_proyek` varchar(150) NOT NULL,
  `lokasi` varchar(150) NOT NULL,
  `tanggal_mulai` date NOT NULL,
  `tanggal_selesai` date NOT NULL,
  `anggaran` decimal(15,2) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `proyek`
--

INSERT INTO `proyek` (`id_proyek`, `nama_proyek`, `lokasi`, `tanggal_mulai`, `tanggal_selesai`, `anggaran`, `status`) VALUES
('P0001', 'Pembangunan Jalan Poros Loa Janan', 'Samarinda', '2024-01-10', '2024-07-30', 150000000.00, 'Selesai'),
('P0002', 'Renovasi Drainase Sungai Pinang', 'Samarinda', '2024-02-01', '2024-09-15', 97500000.00, 'Selesai'),
('P0003', 'Perbaikan Jembatan RT 05', 'Samarinda', '2024-03-01', '2024-08-30', 185000000.00, 'Berjalan'),
('P0004', 'Peningkatan Jalan Kelurahan Sempaja', 'Samarinda', '2024-03-10', '2025-01-30', 250000000.00, 'Berjalan'),
('P0005', 'Renovasi Pasar Induk Samarinda', 'Samarinda', '2024-04-01', '2025-03-31', 300000000.00, 'Berjalan'),
('P0006', 'Drainase Kompleks Palaran', 'Samarinda', '2024-05-15', '2025-02-15', 95000000.00, 'Berjalan'),
('P0007', 'Pembangunan Jaringan Jalan Utama', 'Kutai Kartanegara', '2024-06-01', '2025-03-10', 210000000.00, 'Berjalan'),
('P0008', 'Pembangunan Jembatan Kecil Loa Kulu', 'Kutai Kartanegara', '2024-06-20', '2025-04-20', 130000000.00, 'Berjalan'),
('P0009', 'Peningkatan Saluran Irigasi Desa', 'Kutai Kartanegara', '2024-07-01', '2025-03-05', 85000000.00, 'Berjalan'),
('P0010', 'Pembangunan Saluran Irigasi Samarinda Utara', 'Samarinda', '2024-08-01', '2025-08-10', 135000000.00, 'Berjalan'),
('P0011', 'Renovasi Drainase Kota Samarinda', 'Samarinda', '2024-09-05', '2025-05-05', 105000000.00, 'Selesai'),
('P0012', 'Peningkatan Akses Jalan Desa Loa Bakung', 'Samarinda', '2024-10-10', '2025-02-25', 120000000.00, 'Berjalan'),
('P0013', 'Pembangunan Angkutan Kota Terminal Sungai Kunjang', 'Samarinda', '2024-11-01', '2025-05-30', 175000000.00, 'Perencanaan'),
('P0014', 'Peningkatan Jalan Lingkungan RT 17 Samarinda', 'Samarinda', '2024-12-01', '2025-03-15', 95000000.00, 'Perencanaan'),
('P0015', 'Pembangunan Jembatan Air Hitam', 'Kutai Kartanegara', '2025-01-15', '2025-06-10', 190000000.00, 'Perencanaan'),
('P0016', 'Renovasi Jalan Utama Loa Janan', 'Kutai Kartanegara', '2025-02-01', '2025-07-05', 205000000.00, 'Perencanaan'),
('P0017', 'Paving Jalan Lingkungan Loa Janan', 'Kutai Kartanegara', '2025-02-10', '2025-08-15', 85000000.00, 'Perencanaan'),
('P0018', 'Peningkatan Saluran Lingkungan RT 21', 'Samarinda', '2025-02-15', '2025-07-25', 105000000.00, 'Perencanaan'),
('P0019', 'Tebing Mahakam Terproteksi', 'Samarinda', '2025-03-01', '2025-09-10', 215000000.00, 'Perencanaan'),
('P0020', 'Pembangunan Drainase Loa Janan', 'Kutai Kartanegara', '2025-03-15', '2025-10-25', 135000000.00, 'Perencanaan'),
('P0021', 'Perbaikan Jalan RT 31 Samarinda', 'Samarinda', '2025-04-01', '2025-09-30', 110000000.00, 'Perencanaan'),
('P0022', 'Paving Jalan Baru RT 12', 'Balikpapan', '2025-04-15', '2025-10-15', 95000000.00, 'Perencanaan'),
('P0023', 'Renovasi Jembatan Kayu', 'Balikpapan', '2025-05-01', '2025-11-10', 125000000.00, 'Perencanaan'),
('P0024', 'Peningkatan Drainase Gunung Sari', 'Balikpapan', '2025-05-15', '2025-12-20', 100000000.00, 'Perencanaan'),
('P0025', 'Peningkatan Jalan Lingkungan RT 41', 'Balikpapan', '2025-06-01', '2025-11-25', 90000000.00, 'Perencanaan'),
('P0026', 'Pembangunan Drainase Veteran', 'Balikpapan', '2025-06-15', '2025-12-05', 150000000.00, 'Perencanaan'),
('P0027', 'Peningkatan Drainase Jalan AR 17', 'Samarinda', '2025-07-01', '2025-12-31', 115000000.00, 'Perencanaan'),
('P0028', 'Renovasi Drainase Pasar RT 12', 'Samarinda', '2025-07-10', '2026-01-20', 105000000.00, 'Perencanaan'),
('P0029', 'Peningkatan Jalan Kampung Baru', 'Kutai Kartanegara', '2025-07-20', '2026-01-31', 125000000.00, 'Perencanaan'),
('P0030', 'Paving Jalan Lingkungan RT 33', 'Kutai Kartanegara', '2025-08-01', '2026-02-10', 85000000.00, 'Perencanaan'),
('P0031', 'Peningkatan Jalan Bumi Etam', 'Kutai Kartanegara', '2025-08-15', '2026-03-01', 100000000.00, 'Perencanaan'),
('P0032', 'Peningkatan Drainase Gunung Lingai', 'Samarinda', '2025-09-01', '2026-03-20', 105000000.00, 'Perencanaan'),
('P0033', 'Renovasi Drainase Sungai Kunjang', 'Samarinda', '2025-09-10', '2026-04-01', 95000000.00, 'Perencanaan'),
('P0034', 'Renovasi Jalan RT 5', 'Bontang', '2025-09-20', '2026-04-15', 120000000.00, 'Perencanaan'),
('P0035', 'Peningkatan Jalan Baru RT 9', 'Bontang', '2025-10-01', '2026-05-10', 110000000.00, 'Perencanaan'),
('P0036', 'Peningkatan Drainase RT 12', 'Bontang', '2025-10-15', '2026-05-25', 95000000.00, 'Perencanaan'),
('P0037', 'Renovasi Drainase Veteran', 'Bontang', '2025-10-25', '2026-06-05', 115000000.00, 'Perencanaan'),
('P0038', 'Pemeliharaan Jalan RT 21', 'Bontang', '2025-11-01', '2026-06-20', 90000000.00, 'Perencanaan'),
('P0039', 'Perbaikan Saluran RT 14', 'Bontang', '2025-11-15', '2026-07-10', 95000000.00, 'Perencanaan'),
('P0040', 'Renovasi Jalan RT 24', 'Bontang', '2025-12-01', '2026-07-25', 120000000.00, 'Perencanaan');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_pengguna`);

--
-- Indeks untuk tabel `kontraktor`
--
ALTER TABLE `kontraktor`
  ADD PRIMARY KEY (`id_pengguna`);

--
-- Indeks untuk tabel `laporan`
--
ALTER TABLE `laporan`
  ADD PRIMARY KEY (`id_laporan`),
  ADD KEY `Proyek_id_proyek` (`Proyek_id_proyek`);

--
-- Indeks untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD PRIMARY KEY (`id_pengeluaran`),
  ADD KEY `Proyek_id_proyek` (`Proyek_id_proyek`);

--
-- Indeks untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_pengguna`),
  ADD KEY `Proyek_id_proyek` (`Proyek_id_proyek`);

--
-- Indeks untuk tabel `progres`
--
ALTER TABLE `progres`
  ADD PRIMARY KEY (`id_progres`),
  ADD KEY `Proyek_id_proyek` (`Proyek_id_proyek`);

--
-- Indeks untuk tabel `proyek`
--
ALTER TABLE `proyek`
  ADD PRIMARY KEY (`id_proyek`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`);

--
-- Ketidakleluasaan untuk tabel `kontraktor`
--
ALTER TABLE `kontraktor`
  ADD CONSTRAINT `kontraktor_ibfk_1` FOREIGN KEY (`id_pengguna`) REFERENCES `pengguna` (`id_pengguna`);

--
-- Ketidakleluasaan untuk tabel `laporan`
--
ALTER TABLE `laporan`
  ADD CONSTRAINT `laporan_ibfk_1` FOREIGN KEY (`Proyek_id_proyek`) REFERENCES `proyek` (`id_proyek`);

--
-- Ketidakleluasaan untuk tabel `pengeluaran`
--
ALTER TABLE `pengeluaran`
  ADD CONSTRAINT `pengeluaran_ibfk_1` FOREIGN KEY (`Proyek_id_proyek`) REFERENCES `proyek` (`id_proyek`);

--
-- Ketidakleluasaan untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  ADD CONSTRAINT `pengguna_ibfk_1` FOREIGN KEY (`Proyek_id_proyek`) REFERENCES `proyek` (`id_proyek`);

--
-- Ketidakleluasaan untuk tabel `progres`
--
ALTER TABLE `progres`
  ADD CONSTRAINT `progres_ibfk_1` FOREIGN KEY (`Proyek_id_proyek`) REFERENCES `proyek` (`id_proyek`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
