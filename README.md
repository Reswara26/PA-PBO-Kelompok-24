# Sistem Manajemen Proyek Infrastruktur

Sistem Manajemen Proyek Infrastruktur (SIMANPROF) merupakan aplikasi berbasis Java yang dikembangkan dengan berbasis Pemrograman Berorientasi Objek (PBO). Aplikasi ini dirancang untuk membantu pengelola proyek infrastruktur dalam memantau, mencatat, dan mengelola seluruh aspek proyek secara digital dan terintegrasi. Dengan antarmuka yang interaktif dan sistem berbasis database, SIMANPROF bertujuan meningkatkan efisiensi, transparansi, dan akuntabilitas dalam pelaksanaan proyek publik.

### Fitur Utama:
- 🔐Fitur Login — Proses masuk ke sistem dilakukan melalui verifikasi username dan password, sehingga hanya akun yang terdaftar yang bisa menggunakan aplikasi.

- 🗂️Pengelolaan Data Proyek — Pengguna dapat melihat, menambah, dan memperbarui data proyek yang tersimpan di database.

- 📈Pemantauan Progres Real-Time — Setiap pembaruan progres yang dilakukan pengguna langsung tersimpan di database dan dapat dipantau oleh admin maupun kontraktor secara real-time.

- 💰Pencatatan Pengeluaran Terintegrasi — Seluruh data pengeluaran proyek dicatat dan terhubung langsung dengan data proyek terkait untuk menjaga transparansi dan efisiensi anggaran.

- 📊Laporan Proyek — Fitur ini memungkinkan pengguna untuk membuat, melihat, memperbarui, dan menghapus laporan terkait hasil atau perkembangan proyek.

## 📌Flowchart

#### Menu Login
<img width="1400" height="409" alt="flowchart   Use Case-Menu Login drawio" src="https://github.com/user-attachments/assets/4c15a892-09f4-4a57-a3b6-6007ffe1eeb8" />

#### Menu Admin
<img width="2112" height="1403" alt="flowchart   Use Case-Menu Admin drawio" src="https://github.com/user-attachments/assets/7f57ff82-bd23-4a7e-9e59-4d5e1e67ff41" />

#### Menu Kontraktor
<img width="2044" height="1983" alt="flowchart   Use Case-Menu Kontraktor drawio" src="https://github.com/user-attachments/assets/335db2ad-99f0-4a37-9de5-159507018849" />


## 📌Use Case

<img width="485" height="971" alt="flowchart   Use Case-Use Case drawio" src="https://github.com/user-attachments/assets/72a84b46-5590-4d13-857a-10a23b088216" />


## 📌ERD

#### ERD Logical
<img width="7613" height="6062" alt="Logical" src="https://github.com/user-attachments/assets/f114cff6-6e03-47d8-b3c2-9015b6bd0f3f" />

#### ERD Relational
<img width="7613" height="6062" alt="Relational_1" src="https://github.com/user-attachments/assets/f456a841-b1da-47d2-8f16-c7eaf345c828" />


## 📌Entitas

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


## 📌5 Pilar OOP (Object Oriented Programming) 

#### - Encapsulation
Encapsulation diterapkan pada class di package model, seperti Pengguna, Proyek, Pengeluaran, Progress, dan Laporan.
Setiap atribut disimpan dengan akses private untuk menjaga keamanan data, dan hanya dapat diakses atau dimodifikasi melalui getter dan setter.

#### - Inheritance
Konsep inheritance diterapkan pada class di package model, khususnya antara class Pengguna, Admin, dan Kontraktor.
Class Pengguna berperan sebagai superclass yang menyimpan atribut dasar pengguna seperti username, password, dan dll.
Sedangkan Admin dan Kontraktor merupakan subclass yang mewarisi seluruh atribut serta method dari Pengguna, dan masing-masing menambahkan fungsi khusus sesuai perannya.

#### - Abstraction
Penerapan abstraction terdapat pada class CrudController di package service. CrudController menerapkan abstraction karena menyembunyikan detail teknis umum dari operasi CRUD dan hanya menyediakan kerangka dasar yang digunakan kembali oleh controller lain.

####  - Polymorphism
Penerapan konsep polymorphism dalam program ini terdapat pada class di package service yang mengimplementasikan interface ICRUD. Setiap method seperti tambah(), edit(), dan hapus() memiliki nama yang sama dengan method di interface, namun memiliki implementasi yang berbeda sesuai dengan kebutuhan pengelolaan data proyek.

#### - Interface
Penerapan interface terdapat pada package model, melalui class ICRUD. Penerapan interface ini digunakan untuk menyatukan pola operasi CRUD (Create, Read, Update, Delete) di berbagai modul, seperti proyek, laporan, dan pengeluaran.


## 📌Project Structure
<img width="402" height="903" alt="Screenshot 2025-11-03 115004" src="https://github.com/user-attachments/assets/d2d55a56-a2c1-465d-8b93-3699388efc71" />

<img width="343" height="577" alt="Screenshot 2025-11-03 114730" src="https://github.com/user-attachments/assets/3876b138-1899-4dc1-a423-07f7cc2240dd" />

1. Package Model

Bagian model pada program ini berisi class-class yang merepresentasikan entitas utama dalam sistem manajemen proyek, seperti Proyek, Pengeluaran, Progress, Laporan, dan Pengguna.
Setiap class di package ini digunakan untuk menyimpan dan mengelola data inti aplikasi.
Contohnya, class Proyek menyimpan atribut seperti id proyek, nama proyek, tanggal mulai, dan status, sedangkan class Pengeluaran menyimpan informasi terkait biaya yang dikeluarkan selama proyek berlangsung.

2. Package Service

Bagian service berperan sebagai pengatur logika aplikasi (Controller Layer).
Class-class di package ini, seperti ProyekController, PengeluaranController, ProgressController, dan LaporanController, bertanggung jawab untuk memproses data dari model, mengelola operasi CRUD (Create, Read, Update, Delete), serta berinteraksi dengan database melalui package db_connector. 
Package service menjadi jembatan antara data (model) dan tampilan (gui), serta memastikan setiap interaksi pengguna dijalankan sesuai alur logika aplikasi.

3. Package GUI

Bagian gui berfungsi sebagai antarmuka pengguna (User Interface Layer).
Package ini berisi form dan komponen GUI seperti MenuAdmin, KelolaProyekAdmin, KelolaLaporanAdmin, KelolaPengeluaranAdmin, dll.
Package gui menangani seluruh elemen visual yang berhubungan langsung dengan pengguna, memungkinkan interaksi dan manipulasi data proyek melalui tampilan grafis yang interaktif.

4. Package Db_Connector

Package db_connector berisi class yang berfungsi untuk mengatur koneksi antara aplikasi dan database MySQL yang digunakan oleh sistem.
Package ini hanya berisi satu class utama yaitu db_connection, yang memiliki tanggung jawab penuh dalam membuka dan mengelola koneksi ke database.

5. Package Util
   
Package util berisi class bantu yang digunakan untuk memvalidasi input pengguna sebelum data disimpan ke sistem.
Di dalamnya terdapat class InputValidator, yang menyediakan beberapa method statis seperti requireNonEmpty(), requireDouble(), dan requireDate().

6. Package Main
   
Berisi class utama yang menjalankan program SIMANPROF.
Package ini menampilkan menu utama, menangani login, dan menghubungkan semua fitur dari controller lain seperti proyek, progres, laporan, dan pengeluaran.

## 📌Library yang digunakan

<img width="335" height="172" alt="Screenshot 2025-11-03 112526" src="https://github.com/user-attachments/assets/4b81d352-e3b6-4362-b4e5-e0dd4a8a7954" />

- mysql-connector-j-8.0.33.jar
  Library ini berfungsi sebagai driver JDBC yang memungkinkan aplikasi Java terhubung dengan database MySQL.
  Dalam program ini, library tersebut digunakan untuk menjalankan berbagai operasi pengelolaan data seperti menambah, menghapus, memperbarui, dan menampilkan data proyek.
  Dengan bantuan library ini, class db_connection dapat membuka koneksi ke database simanprof dan mengeksekusi perintah SQL melalui Java dengan lancar.

- AbsoluteLayout-RELEASE270.jar
  Library ini digunakan untuk mengatur tata letak komponen pada tampilan aplikasi (GUI) secara bebas menggunakan koordinat (x, y).

- protobuf-java-3.21.9.jar
  Library ini merupakan dependensi tambahan yang mendukung performa MySQL Connector dalam melakukan komunikasi data.
  Protobuf-java membantu mengirim dan mengambil data antara aplikasi dan database dengan cara yang lebih cepat dan ringan.
  
- JDK 24 (Default)
  Merupakan paket pengembangan utama yang digunakan untuk menulis, mengompilasi, dan menjalankan program Java.
  JDK menyediakan berbagai library standar seperti java.sql untuk koneksi database, javax.swing untuk tampilan antarmuka (GUI), serta java.util untuk pengelolaan struktur data.

## 📌Cara menggunakan program

### :👤Tampilan Login

<img width="1204" height="772" alt="Screenshot 2025-11-03 141102" src="https://github.com/user-attachments/assets/88a8630d-5510-4398-a20a-648803afa662" />

Pada tampilan awal, pengguna (admin atau kontraktor) melakukan login melalui form yang sama dengan memasukkan username dan password. Sistem akan otomatis mengenali peran pengguna. Jika login sebagai admin, akan diarahkan ke dashboard admin; jika sebagai kontraktor, akan masuk ke dashboard kontraktor. Seperti pada gambar dibawah.

<img width="1206" height="769" alt="Screenshot 2025-11-03 141122" src="https://github.com/user-attachments/assets/d5569441-8b01-43b4-a826-d4aebc0e7dd9" />

<img width="1212" height="758" alt="Screenshot 2025-11-03 141741" src="https://github.com/user-attachments/assets/bcefdd0c-b69a-49fb-a20f-cd85fe29f959" />

### 🧑‍💼Menu Admin

<img width="1193" height="726" alt="image" src="https://github.com/user-attachments/assets/83412a5a-9e1c-4fd0-8184-c29ebe72c876" />

Setelah login berhasil, admin akan diarahkan ke menu utama dengan pilihan kelola proyek, kelola pengeluaran, kelola progres, dan kelola laporan.

1️⃣Kelola Proyek

Pada menu Kelola Proyek, admin dapat memilih untuk melihat seluruh data proyek yang tersimpan di database ataupun melakukan pembaruan (update) terhadap informasi proyek seperti lokasi, tanggal, dan anggaran.

<img width="1163" height="732" alt="image" src="https://github.com/user-attachments/assets/f11e09f6-8d10-4b96-aa2e-e092ef2d76ae" />

<img width="1145" height="722" alt="image" src="https://github.com/user-attachments/assets/4b7bde70-4258-4a5b-834e-90c74ad5687c" />

<img width="1165" height="746" alt="image" src="https://github.com/user-attachments/assets/1892ced5-ad7a-4d82-9883-3c68fcfcf457" />

2️⃣Kelola Pengeluaran & Progres

Pada menu Kelola Pengeluaran dan progres, admin dapat melihat daftar pengeluaran dan progres yang tersedia.

<img width="1169" height="677" alt="image" src="https://github.com/user-attachments/assets/ebf287c6-479b-48ce-9062-2a1429f47ee0" />

<img width="1163" height="733" alt="image" src="https://github.com/user-attachments/assets/62db204f-05dc-4a69-9d20-8d74419c28e2" />

3️⃣Kelola Laporan

Menu Kelola Laporan menampilkan tiga opsi utama. Admin bisa memilih tindakan yang ingin dilakukan terhadap data laporan proyek seperti melihat seluruh data laporan proyek, memperbarui data laporan dengan memasukkan ID Laporan dan Status Tindak Lanjut, dan menghapus laporan dengan memasukkan ID Laporan yang ingin dihapus. Setelah diisi, tekan tombol Kirim untuk menyimpan perubahan ke database.

<img width="1169" height="747" alt="image" src="https://github.com/user-attachments/assets/3d737803-ef56-4d5a-a7f2-23c381cbdba0" />

<img width="1165" height="749" alt="image" src="https://github.com/user-attachments/assets/6ece8ce7-2089-4572-b81a-0cd2cfbcadd7" />

<img width="1165" height="745" alt="image" src="https://github.com/user-attachments/assets/309ef02e-059a-455d-b3e1-3c2c1774bb13" />

<img width="1165" height="747" alt="image" src="https://github.com/user-attachments/assets/07e50616-36fe-45c9-a114-3dc0d16b7a50" />

### 👷‍♂️Menu Kontraktor

<img width="1208" height="759" alt="Screenshot 2025-11-03 141756" src="https://github.com/user-attachments/assets/37ff55a6-dd3d-4a39-8cab-54d0a13168b7" />

Setelah login berhasil, kontraktor akan diarahkan ke tampilan menu utama kontraktor dengan fitur Kelola Proyek, Kelola Progres, Kelola Pengeluaran, dan Kelola Laporan.

1️⃣Kelola Proyek

<img width="1196" height="767" alt="Screenshot 2025-11-03 141817" src="https://github.com/user-attachments/assets/cabd68d3-b694-4146-9f83-fe17cb64da6b" />

<img width="1205" height="754" alt="Screenshot 2025-11-03 141830" src="https://github.com/user-attachments/assets/620f15a8-9702-4895-aee5-d1358bb22a0c" />

<img width="1184" height="719" alt="Screenshot 2025-11-03 141845" src="https://github.com/user-attachments/assets/a1ff694b-f94f-478a-8ac6-7e7cf3b9c390" />

Pada menu kelola proyek, kontraktor dapat menambahkan proyek baru atau melihat daftar proyek yang ada.

2️⃣Kelola Pengeluaran

<img width="1165" height="747" alt="image" src="https://github.com/user-attachments/assets/4cf1d53a-cfec-43c2-8c9a-9a989a546ea5" />

<img width="1209" height="770" alt="Screenshot 2025-11-03 141905" src="https://github.com/user-attachments/assets/101b59d9-cd5c-401e-bf8c-9beb928c3c4c" />

<img width="1187" height="760" alt="Screenshot 2025-11-03 141917" src="https://github.com/user-attachments/assets/f8d3d299-a66d-4a0a-a0c1-97cb9589dca7" />

<img width="1187" height="758" alt="Screenshot 2025-11-03 141931" src="https://github.com/user-attachments/assets/8afd8e38-8110-4422-9b3c-e5fda850c7b1" />

Pada menu kelola pengeluaran, kontraktor dapat melihat, menambah, ataupun memperbarui pengeluaran.

3️⃣Kelola Laporan

<img width="1181" height="765" alt="Screenshot 2025-11-03 141948" src="https://github.com/user-attachments/assets/45d9259c-a553-4e1b-9699-e04499af3269" />

<img width="1201" height="765" alt="Screenshot 2025-11-03 141958" src="https://github.com/user-attachments/assets/238fa0ec-064d-4394-a742-372a81a10051" />

<img width="1206" height="758" alt="Screenshot 2025-11-03 142012" src="https://github.com/user-attachments/assets/1c7231c0-e199-4e7d-9c7d-da3f871ba2d8" />

Pada menu kelola laporan, kontraktor dapat melihat ataupun menambahkan laporan.
