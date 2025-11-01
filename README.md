# Sistem Manajemen Proyek Infrastruktur

Sistem Manajemen Proyek Infrastruktur (SIMANPROF) merupakan aplikasi berbasis Java yang dikembangkan dengan berbasis Pemrograman Berorientasi Objek (PBO). Aplikasi ini dirancang untuk membantu pengelola proyek infrastruktur dalam memantau, mencatat, dan mengelola seluruh aspek proyek secara digital dan terintegrasi. Dengan antarmuka yang interaktif dan sistem berbasis database, SIMANPROF bertujuan meningkatkan efisiensi, transparansi, dan akuntabilitas dalam pelaksanaan proyek publik.

### Fitur Utama:
- Fitur Login
  
  Aplikasi ini memiliki fitur login sebagai pintu utama untuk mengakses sistem.

  Setiap pengguna harus memasukkan username dan password yang tersimpan di database. Fitur ini memastikan hanya pengguna yang terdaftar yang bisa masuk ke sistem, sekaligus membedakan apakah
  pengguna tersebut adalah admin atau kontraktor.
  Jika data login sesuai, sistem akan mengarahkan pengguna ke tampilan sesuai perannya masing-masing.

- Fitur CRUD
  
  - Kelola Proyek
    
    Pengguna dapat menambahkan data proyek baru, melihat proyek, mengedit proyek yang sudah ada, atau menghapus proyek yang sudah selesai.
    
  - Kelola Pengeluaran
    
    Fitur ini digunakan untuk mencatat dan mengatur data pengeluaran setiap proyek.
    Dengan adanya fitur ini, admin ataupun kontraktor dapat memantau anggaran dan biaya operasional dengan lebih mudah.
    
  - Kelola Progress
    
    Fitur ini digunakan untuk mencatat perkembangan atau tahap-tahap pekerjaan dari suatu proyek.
    Dengan fitur ini, pengguna dapat mengetahui sejauh mana proyek telah berjalan dan apakah ada hambatan yang perlu segera diatasi.
    
  - Kelola Laporan
    
    Fitur ini memungkinkan pengguna untuk membuat, melihat, dan memperbarui laporan terkait hasil atau perkembangan proyek.
    Laporan ini biasanya mencakup informasi tentang progres, hasil akhir, atau evaluasi dari proyek yang sedang berjalan.

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
Encapsulation diterapkan pada bagian pengelolaan class pengguna, proyek, pengeluaran, progress, dan laporan.
Setiap atribut data disimpan dalam variabel dengan akses private, kemudian diakses melalui getter dan setter.
<img width="1392" height="725" alt="Screenshot 2025-11-01 173024" src="https://github.com/user-attachments/assets/2a318f88-067d-40b2-8b46-d228f63d082d" />

<img width="1384" height="728" alt="Screenshot 2025-11-01 173234" src="https://github.com/user-attachments/assets/de492f55-d7fc-4d0c-9b87-51e7c2f68a34" />

<img width="1352" height="621" alt="Screenshot 2025-11-01 173253" src="https://github.com/user-attachments/assets/6e541f66-a305-4310-9e24-819df9b4c576" />

<img width="1210" height="823" alt="Screenshot 2025-11-01 173310" src="https://github.com/user-attachments/assets/ea7eff08-6a84-4d9d-9176-03b4683b1e57" />

<img width="1203" height="719" alt="Screenshot 2025-11-01 173328" src="https://github.com/user-attachments/assets/cbc84663-cee5-4f53-8170-f21eeca273bf" />


#### - Inheritance
Penerapan konsep inheritance pada program ini terdapat pada bagian class model, khususnya antara class Pengguna, Admin, dan Kontraktor.
Class Pengguna berperan sebagai superclass yang menyimpan atribut dasar pengguna seperti username, password, dan dll.
Sedangkan Admin dan Kontraktor merupakan subclass yang mewarisi seluruh atribut serta method dari User, dan masing-masing menambahkan fungsi khusus sesuai perannya.

<img width="485" height="70" alt="image" src="https://github.com/user-attachments/assets/b3f2c028-db3f-456f-9fa8-a74d3bf99267" />

<img width="551" height="93" alt="image" src="https://github.com/user-attachments/assets/5ad35cda-9111-48cd-8565-4165c6a4dd10" />


#### - Abstraction


####  - Polymorphism


#### - Interface
Inheritance diterapkan pada bagian class model. Penerapan interface ini digunakan untuk menyatukan pola operasi CRUD (Create, Read, Update, Delete) di berbagai modul, seperti proyek, laporan, dan pengeluaran.

<img width="405" height="203" alt="image" src="https://github.com/user-attachments/assets/16b65edf-af90-4024-89d7-eb230bc64b5c" />


## 📌Project Structure
<img width="409" height="896" alt="image" src="https://github.com/user-attachments/assets/11bdfaff-df3a-49ae-b968-c7b8162a6bd0" />

<img width="358" height="871" alt="image" src="https://github.com/user-attachments/assets/3fd5ff6a-365f-41a5-b928-0c2f8ba47a68" />

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

## 📌Library yang digunakan
- mysql-connector-j-8.0.33.jar
  Library ini berfungsi sebagai driver JDBC yang memungkinkan aplikasi Java terhubung dengan database MySQL.
  Dalam program ini, library tersebut digunakan untuk menjalankan berbagai operasi pengelolaan data seperti menambah, menghapus, memperbarui, dan menampilkan data proyek.
  Dengan bantuan library ini, class db_connection dapat membuka koneksi ke database simanprof dan mengeksekusi perintah SQL melalui Java dengan lancar.

- protobuf-java-3.21.9.jar
  Library ini merupakan dependensi tambahan yang mendukung performa MySQL Connector dalam melakukan komunikasi data.
  Protobuf-java membantu mengirim dan mengambil data antara aplikasi dan database dengan cara yang lebih cepat dan ringan.
  
- JDK 24 (Default)
  Merupakan paket pengembangan utama yang digunakan untuk menulis, mengompilasi, dan menjalankan program Java.
  JDK menyediakan berbagai library standar seperti java.sql untuk koneksi database, javax.swing untuk tampilan antarmuka (GUI), serta java.util untuk pengelolaan struktur data.

## 📌Cara menggunakan program
