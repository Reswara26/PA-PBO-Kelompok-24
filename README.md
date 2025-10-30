# Sistem Manajemen Proyek Infrastruktur

Sistem Manajemen Proyek Infrastruktur (SIMANPROF) merupakan aplikasi berbasis Java yang dikembangkan dengan berbasis Pemrograman Berorientasi Objek (PBO). Aplikasi ini dirancang untuk membantu pengelola proyek infrastruktur dalam memantau, mencatat, dan mengelola seluruh aspek proyek secara digital dan terintegrasi. Dengan antarmuka yang interaktif dan sistem berbasis database, SIMANPROF bertujuan meningkatkan efisiensi, transparansi, dan akuntabilitas dalam pelaksanaan proyek publik.

### Fitur Utama:
- CRUD Data Proyek
- Pemantauan progres real-time
- Pencatatan pengeluaran terintegrasi
- Filter dan pencarian data proyek
- Laporan otomatis berbasis data aktual


## Flowchart

#### Menu Login
<img width="992" height="894" alt="image" src="https://github.com/user-attachments/assets/3d59fd90-d42d-4e76-b282-a1f6fc7173d5" />

#### Menu Admin
<img width="1253" height="767" alt="image" src="https://github.com/user-attachments/assets/065c41b2-6fac-4681-9f1a-e77277a1cbed" />

#### Menu Kontraktor
<img width="814" height="875" alt="image" src="https://github.com/user-attachments/assets/131563be-047a-46dd-b3f0-17df5c61fed7" />


## ERD

#### ERD Logical
<img width="7613" height="6062" alt="Logical" src="https://github.com/user-attachments/assets/f114cff6-6e03-47d8-b3c2-9015b6bd0f3f" />

#### ERD Relational
<img width="7613" height="6062" alt="Relational_1" src="https://github.com/user-attachments/assets/f456a841-b1da-47d2-8f16-c7eaf345c828" />


## Entitas

#### Pengguna (Admin / Kontraktor)
Atribut Supertype (Pengguna):
- `id_pengguna`: Identifikasi unik pengguna.
- `nama_pengguna`: Nama pengguna.
- `username`: Nama akun untuk login.
- `password`: Kata sandi untuk autentikasi.
- `kontak`: Nomor telepon atau email.
- `id_proyek`: Proyek yang dikelola (FK).

Atribut Subtype (Admin):
- `id_pengguna`: Referensi ke pengguna.
- `jabatan_admin`: Posisi atau peran admin.

Atribut Subtype (Kontraktor):
- `id_pengguna`: Referensi ke pengguna.
- `nama_perusahaan`: Nama perusahaan kontraktor.
- `penanggung_jawab`: Nama penanggung jawab proyek.

Relasi:

Kelola
- Setiap Pengguna harus mengelola satu dan hanya satu proyek   
- Setiap Proyek harus dikelola satu atau banyak pengguna


#### Proyek
Atribut:
- `id_proyek`: Identifikasi unik proyek.
- `nama_proyek`: Nama proyek.
- `lokasi`: Lokasi pelaksanaan.
- `tanggal_mulai`: Tanggal dimulainya proyek.
- `tanggal_selesai`: Tanggal target selesai.
- `anggaran`: Total anggaran proyek.
- `status`: Status terkini proyek.

Relasi:

- Punya: Progres dipunyai satu dan hanya satu proyek.

Milik
- Laporan dimiliki satu dan hanya satu proyek.
- Pengeluaran dimiliki satu dan hanya satu proyek.


#### Progres
Atribut:
- `id_progres`: Identifikasi unik progres.
- `tanggal_update`: Tanggal pembaruan progres.
- `persentase_selesai`: Persentase penyelesaian.
- `deskripsi`: Penjelasan progres.
- `id_proyek`: Proyek terkait (FK).

Relasi:

- Punya: Proyek mempunyai satu atau banyak progres.


#### Pengeluaran
Atribut:
- `id_pengeluaran`: Identifikasi unik pengeluaran.
- `tanggal_pengeluaran`: Tanggal transaksi.
- `keterangan`: Penjelasan pengeluaran.
- `jumlah`: Nominal pengeluaran.
- `kategori`: Jenis pengeluaran.
- `id_proyek`: Proyek terkait (FK).

Relasi:

- Milik: Proyek memiliki satu atau banyak pengeluaran.


#### Laporan
Atribut:
- `id_laporan`: Identifikasi unik laporan.
- `tanggal_laporan`: Tanggal laporan dibuat.
- `jenis_kendala`: Jenis kendala yang dihadapi.
- `deskripsi`: Penjelasan kendala.
- `status_tindak_lanjut`: Status penanganan kendala.
- `id_proyek`: Proyek terkait (FK).

Relasi:

- Milik: Proyek memiliki satu atau banyak laporan.


## Project Structure
