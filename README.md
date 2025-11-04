# Sistem Manajemen Proyek Infrastruktur

Sistem Manajemen Proyek Infrastruktur (SIMANPROF) merupakan aplikasi berbasis Java yang dikembangkan dengan berbasis Pemrograman Berorientasi Objek (PBO). Aplikasi ini dirancang untuk membantu pengelola proyek infrastruktur dalam memantau, mencatat, dan mengelola seluruh aspek proyek secara digital dan terintegrasi. Dengan antarmuka yang interaktif dan sistem berbasis database, SIMANPROF bertujuan meningkatkan efisiensi, transparansi, dan akuntabilitas dalam pelaksanaan proyek publik.

### Fitur Utama:
- 🔐Fitur Login — Proses masuk ke sistem dilakukan melalui verifikasi username dan password, sehingga hanya akun yang terdaftar yang bisa menggunakan aplikasi.

- 🗂️Pengelolaan Data Proyek — Pengguna dapat melihat, menambah, dan memperbarui data proyek yang tersimpan di database.

- 📈Pemantauan Progres Real-Time — Setiap pembaruan progres yang dilakukan pengguna langsung tersimpan di database dan dapat dipantau oleh admin maupun kontraktor secara real-time.

- 💰Pencatatan Pengeluaran Terintegrasi — Seluruh data pengeluaran proyek dicatat dan terhubung langsung dengan data proyek terkait untuk menjaga transparansi dan efisiensi anggaran.

- 📊Laporan Proyek — Fitur ini memungkinkan pengguna untuk membuat, melihat, memperbarui, dan menghapus laporan terkait hasil atau perkembangan proyek.

## 🔄Flowchart

<details>
 <summary>Flowchart Menu Login</summary>
<img width="1400" height="409" alt="flowchart   Use Case-Menu Login drawio" src="https://github.com/user-attachments/assets/4c15a892-09f4-4a57-a3b6-6007ffe1eeb8" />
</details>

<details>
 <summary>Flowchart Menu Admin</summary>
<img width="2112" height="1403" alt="flowchart   Use Case-Menu Admin drawio" src="https://github.com/user-attachments/assets/7f57ff82-bd23-4a7e-9e59-4d5e1e67ff41" />
</details>

<details>
 <summary>Flowchart Menu Kontraktor</summary>
<img width="2044" height="1982" alt="flowchart   Use Case-Menu Kontraktor drawio (1)" src="https://github.com/user-attachments/assets/d1e48a0d-bdb2-4694-aa77-7d647f15183b" />
</details>

## 🧩Use Case Diagram
<details>
 <summary>Use Case SIMANPROF</summary>
<img width="485" height="916" alt="flowchart   Use Case-Use Case drawio (1)" src="https://github.com/user-attachments/assets/7aada1c4-31c9-4dc6-b39f-a08448409c0c" />
</details>

## 📌ERD

<details>
 <summary>ERD Logical</summary>
<img width="7613" height="6062" alt="Logical" src="https://github.com/user-attachments/assets/f114cff6-6e03-47d8-b3c2-9015b6bd0f3f" />
</details>

<details>
 <summary>ERD Relational</summary>
<img width="7613" height="6062" alt="Relational_1" src="https://github.com/user-attachments/assets/f456a841-b1da-47d2-8f16-c7eaf345c828" />
</details>

## 🧬Entitas

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


## 💡5 Pilar OOP (Object Oriented Programming) 

#### - Encapsulation
Encapsulation diterapkan pada class di package model, seperti Pengguna, Proyek, Pengeluaran, Progress, dan Laporan.
Setiap atribut disimpan dengan akses private untuk menjaga keamanan data, dan hanya dapat diakses atau dimodifikasi melalui getter dan setter.
<img width="1203" height="719" alt="Screenshot 2025-11-01 173328" src="https://github.com/user-attachments/assets/379d3113-1910-452e-bcd5-739c8542d3cc" />

#### - Inheritance
Konsep inheritance diterapkan pada class di package model, khususnya antara class Pengguna, Admin, dan Kontraktor.
Class Pengguna berperan sebagai superclass yang menyimpan atribut dasar pengguna seperti username, password, dan dll.
Sedangkan Admin dan Kontraktor merupakan subclass yang mewarisi seluruh atribut serta method dari Pengguna, dan masing-masing menambahkan fungsi khusus sesuai perannya.

<img width="435" height="203" alt="image" src="https://github.com/user-attachments/assets/9cd05059-0bbe-4fd7-bb28-0c2e1bdddb53" />

<img width="551" height="93" alt="Screenshot 2025-11-01 190445" src="https://github.com/user-attachments/assets/82f9ed8e-46f6-49b9-aa45-e6bbb0b6c967" />

<img width="485" height="70" alt="Screenshot 2025-11-01 190354" src="https://github.com/user-attachments/assets/9e4e5913-9c43-4348-8d13-dae17472ca65" />

#### - Abstraction
Penerapan abstraction terdapat pada class CrudController di package service. CrudController menerapkan abstraction karena menyembunyikan detail teknis umum dari operasi CRUD dan hanya menyediakan kerangka dasar yang digunakan kembali oleh controller lain.
<img width="757" height="31" alt="image" src="https://github.com/user-attachments/assets/3c18a035-54b9-4459-999a-8074f2c32275" />

####  - Polymorphism
Penerapan konsep polymorphism dalam program ini terdapat pada class di package service yang mengimplementasikan interface ICRUD. Setiap method seperti tambah(), edit(), dan hapus() memiliki nama yang sama dengan method di interface, namun memiliki implementasi yang berbeda sesuai dengan kebutuhan pengelolaan data proyek.
<img width="1192" height="728" alt="image" src="https://github.com/user-attachments/assets/bf86899d-db89-4547-b2e9-6698ec616aea" />

#### - Interface
Penerapan interface terdapat pada package model, melalui class ICRUD. Penerapan interface ini digunakan untuk menyatukan pola operasi CRUD (Create, Read, Update, Delete) di berbagai modul, seperti proyek, laporan, dan pengeluaran.
<img width="405" height="203" alt="Screenshot 2025-11-01 190511" src="https://github.com/user-attachments/assets/6a8a9723-cb10-4b1d-9d50-6113a40452f9" />


## 🗂️Project Structure
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

## 📦Library yang digunakan

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

## 🚀Cara menggunakan program

### 👤Tampilan Login

<img width="1204" height="772" alt="Screenshot 2025-11-03 141102" src="https://github.com/user-attachments/assets/88a8630d-5510-4398-a20a-648803afa662" />

Pada tampilan awal, pengguna (admin atau kontraktor) melakukan login melalui form yang sama dengan memasukkan username dan password. Sistem akan otomatis mengenali peran pengguna. Jika login sebagai admin, akan diarahkan ke dashboard admin; jika sebagai kontraktor, akan masuk ke dashboard kontraktor. Seperti pada gambar dibawah.

<img width="1206" height="769" alt="Screenshot 2025-11-03 141122" src="https://github.com/user-attachments/assets/d5569441-8b01-43b4-a826-d4aebc0e7dd9" />

<img width="1212" height="758" alt="Screenshot 2025-11-03 141741" src="https://github.com/user-attachments/assets/bcefdd0c-b69a-49fb-a20f-cd85fe29f959" />

### 🧑‍💼Menu Admin

Setelah login berhasil, admin akan diarahkan ke menu utama dengan pilihan kelola proyek, kelola pengeluaran, kelola progres, dan kelola laporan.

<img width="1193" height="726" alt="image" src="https://github.com/user-attachments/assets/83412a5a-9e1c-4fd0-8184-c29ebe72c876" />

Jika admin ingin keluar dari menu admin, cukup klik tombol `Kembali ke log in` maka sistem akan menutup jendela menu yang sedang aktif dan menampilkan kembali form login awal.

<details>
 <summary>1️⃣Kelola Proyek Admin</summary>

Menu Kelola Proyek menampilkan dua opsi utama, yaitu melihat dan mengupdate proyek.

<img width="1163" height="732" alt="image" src="https://github.com/user-attachments/assets/f11e09f6-8d10-4b96-aa2e-e092ef2d76ae" />

Admin dapat melihat daftar seluruh proyek yang sedang atau telah dikerjakan.
Informasi yang ditampilkan meliputi ID Proyek, Nama Proyek, Lokasi, Tanggal Mulai, dan Tanggal Selesai.

<img width="1144" height="723" alt="Screenshot 2025-11-04 182447" src="https://github.com/user-attachments/assets/ebfdd791-6eb3-4daa-a620-b9bfcb43b218" />

Admin dapat memperbarui data proyek yang sudah terdaftar dengan memasukkan lokasi baru, tanggal mulai, tanggal selesai, serta anggaran proyek. 

<img width="1162" height="750" alt="Screenshot 2025-11-04 182516" src="https://github.com/user-attachments/assets/8b83e2b9-4a3b-4129-ab73-cd8848b7e663" />

Setelah data diperbarui, sistem otomatis menyimpan perubahan tersebut ke database.
</details>

<details>
 <summary>2️⃣Kelola Pengeluaran Admin</summary>

Pada menu Kelola Pengeluaran, Admin dapat melihat seluruh data pengeluaran proyek yang meliputi ID Pengeluaran, Tanggal, Keterangan, Jumlah, dan Kategori.
Menu ini digunakan untuk memantau dan memastikan semua transaksi tercatat dengan benar.

<img width="1170" height="681" alt="Screenshot 2025-11-04 182600" src="https://github.com/user-attachments/assets/d227d268-48ad-457c-91f0-225628a039bf" />

</details>

<details>
 <summary>3️⃣Kelola Progres Admin</summary>

Admin dapat memantau perkembangan proyek berdasarkan ID Proyek, Nama Proyek, Tanggal Update, Persentase Progres, dan Deskripsi.
Fitur ini berguna untuk melihat sejauh mana proyek sudah berjalan dan apakah sesuai dengan jadwal yang ditentukan.

<img width="1162" height="738" alt="Screenshot 2025-11-04 182640" src="https://github.com/user-attachments/assets/bf3b947b-c27a-46c5-b725-b32e23b77db3" />

</details>

<details>
 <summary>4️⃣Kelola Laporan Admin</summary>

Menu Kelola Laporan menampilkan tiga opsi utama, yaitu melihat, mengupdate, dan menghapus laporan.

<img width="1169" height="747" alt="image" src="https://github.com/user-attachments/assets/3d737803-ef56-4d5a-a7f2-23c381cbdba0" />

Admin dapat menampilkan seluruh laporan proyek yang berisi ID Laporan, Tanggal, Jenis Kendala, Deskripsi, dan Status Tindak Lanjut.

<img width="1163" height="750" alt="Screenshot 2025-11-04 182718" src="https://github.com/user-attachments/assets/f5000aa0-917d-4a15-b8e0-d24c18c0de87" />

Admin dapat memperbarui data laporan yang sudah terdaftar dengan memasukkan ID Laporan dan Status Tindak Lanjut.

<img width="1163" height="742" alt="Screenshot 2025-11-04 182742" src="https://github.com/user-attachments/assets/529bced0-ec77-4e2f-951c-c7ed9e74a411" />

Admin juga dapat menghapus laporan tertentu berdasarkan ID Laporan.

<img width="1169" height="750" alt="Screenshot 2025-11-04 182804" src="https://github.com/user-attachments/assets/7a0531bb-5325-4b90-a2ff-ae4d28f767e7" />

Setelah diisi, tekan tombol `Kirim` untuk menyimpan perubahan ke database.
</details>

### 👷‍♂️Menu Kontraktor

Setelah login berhasil, kontraktor akan diarahkan ke tampilan menu utama kontraktor dengan fitur Kelola Proyek, Kelola Progres, Kelola Pengeluaran, dan Kelola Laporan.

<img width="1190" height="743" alt="image" src="https://github.com/user-attachments/assets/955d6a62-8930-433a-96c3-1685c4287570" />

Jika kontraktor ingin keluar dari menu kontraktor, cukup klik tombol `Kembali ke log in` maka sistem akan menutup jendela menu yang sedang aktif dan menampilkan kembali form login awal.

<details>
 <summary>1️⃣Kelola Proyek Kontraktor</summary>

Pada menu kelola proyek terdapat dua opsi utama, yaitu lihat dan update proyek.

<img width="1165" height="747" alt="image" src="https://github.com/user-attachments/assets/df782ec9-639b-4105-8053-12fc7e5c4c72" />

Kontraktor dapat melihat daftar proyek yang sedang dikerjakan, termasuk informasi seperti ID proyek, nama, lokasi, tanggal mulai, tanggal selesai, anggaran, dan status proyek.

<img width="1168" height="743" alt="Screenshot 2025-11-04 194823" src="https://github.com/user-attachments/assets/885c31cd-c8df-4764-b5e6-a106778b5789" />

Fitur ini digunakan untuk memperbarui data proyek yang sudah ada. Kontraktor dapat mengubah informasi seperti lokasi proyek, tanggal mulai, tanggal selesai, anggaran, dan status sesuai kondisi terkini di lapangan.

<img width="1165" height="700" alt="Screenshot 2025-11-04 183421" src="https://github.com/user-attachments/assets/19874714-b0b8-4255-b8b8-185a4daedf52" />

Setelah semua data diisi, tekan tombol `Kirim` untuk menambahkan proyek ke database.
</details>

<details>
 <summary>2️⃣Kelola Progres Kontraktor</summary>

Pada menu kelola Progres, terdapat tiga opsi utama, yaitu lihat, tambah, dan update progres.

<img width="1167" height="750" alt="image" src="https://github.com/user-attachments/assets/9dc2cb15-cf9d-4787-a4d6-83791d351250" />

Kontraktor dapat menampilkan data progres proyek, seperti ID, tanggal, persentase, dan deskripsi.

<img width="1167" height="748" alt="Screenshot 2025-11-04 194643" src="https://github.com/user-attachments/assets/78a47631-5895-4187-bbb3-683349d6d655" />

Kontraktor dapat menambahkan progres baru untuk mencatat perkembangan proyek.

<img width="1168" height="744" alt="Screenshot 2025-11-04 183455" src="https://github.com/user-attachments/assets/748263f7-e58c-4d79-8588-a54c95407351" />

Kontraktor juga dapat memperbarui data progres yang sudah ada, seperti perubahan persentase kemajuan atau deskripsi tambahan.

<img width="1169" height="751" alt="Screenshot 2025-11-04 183513" src="https://github.com/user-attachments/assets/2c102641-909a-47c6-b1f5-1d4e6a6885ce" />
Setelah semua diisi, Kontraktor dapat menekan tombol `Kirim` untuk menyimpan perubahan ke database.
</details>

<details>
 <summary>3️⃣Kelola Pengeluaran Kontraktor</summary>

Pada menu kelola pengeluaran, terdapat tiga opsi utama, yaitu lihat, tambah, dan update pengeluaran.

<img width="1163" height="746" alt="image" src="https://github.com/user-attachments/assets/fe8dfbdd-4764-4383-89db-c843ddb40d43" />

Kontraktor dapat menampilkan daftar seluruh pengeluaran proyek yang berisi ID, tanggal, keterangan, jumlah, dan kategori pengeluaran.

<img width="1164" height="748" alt="Screenshot 2025-11-04 195005" src="https://github.com/user-attachments/assets/f955bba3-2b73-4919-a71a-55b2a0650c1b" />

Kontraktor dapat menambahkan data pengeluaran baru dengan mengisi tanggal, jumlah, keterangan, dan kategori pengeluaran.

<img width="1166" height="747" alt="Screenshot 2025-11-04 183603" src="https://github.com/user-attachments/assets/a111fc10-fab5-4f5e-b601-2d082277573e" />

Fitur `update pengeluaran` digunakan untuk memperbarui data pengeluaran yang sudah ada, misalnya mengubah tanggal, jumlah, keterangan, atau kategori pengeluaran yang baru.

<img width="1165" height="748" alt="Screenshot 2025-11-04 183621" src="https://github.com/user-attachments/assets/a14dea7a-0a71-4b42-a441-bd55780df5bf" />

Sama seperti sebelumnya, setelah diisi, tekan tombol `Kirim` untuk menyimpan perubahan ke database.
</details>

<details>
 <summary>4️⃣Kelola Laporan Kontraktor</summary>

Pada menu kelola laporan, terdapat dua opsi yaitu lihat dan tambah laporan.

<img width="1164" height="747" alt="Screenshot 2025-11-04 183644" src="https://github.com/user-attachments/assets/a3532a8f-6a8f-424a-b1f6-345ad929a555" />

Kontraktor dapat menampilkan daftar laporan yang berisi ID laporan, tanggal, jenis kendala, deskripsi, dan status tindak lanjut.

<img width="1171" height="749" alt="Screenshot 2025-11-04 195105" src="https://github.com/user-attachments/assets/c964ddc1-ecab-47d1-ac73-8e9127b49800" />

Kontraktor juga dapat menambahkan laporan baru dengan mengisi tanggal laporan, jenis kendala yang ditemukan di lapangan, dan deskripsi masalah.

<img width="1165" height="689" alt="Screenshot 2025-11-04 183727" src="https://github.com/user-attachments/assets/f0c2af0b-ea46-475a-97d9-aaa71fe44d79" />

Setelah semua data diisi, tekan tombol `Kirim` untuk menambahkan laporan ke database.
</details>
