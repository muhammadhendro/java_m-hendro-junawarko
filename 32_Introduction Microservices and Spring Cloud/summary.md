# (32) Introduction Microservices and Spring Cloud

## Resume
Dalam materi ini, mempelajari:
1. Microservices
2. Spring Cloud


### Microservices
#### Arsitektur Monolith
- Single deployment unit
- Semua fitur dibuat dalam sebuah aplikasi besar

#### Kelebihan Monolith
- Mudah di develop
- Mudah di deploy
- Mudah di test
- Mudah di scale

#### Masalah di Arsitektur Monolith
- Mengintimidasi developer yang baru bergabung
- Scaling development dengan banyak Developer agak menyulitkan
- Butuh kontrak panjang dengan teknologi yang digunakan (bahasa pemrograman, database, dan lain-lain)
- Scaling pada bagian tertentu tidak bisa dilakukan
- Running app Monolith sangat berat

#### Arsitektur Microservices
- Aplikasi-aplikasi kecil yang saling bekerja sama. 
- Fokus mengerjakan satu pekerjaan dengan balk 
- Independent, dapat di deploy dan diubah tanpa tergantung dengan aplikasi lain - Setiap komponen pada sistem dibuat dalam service 
- Komunikasi antar service biasanya melalui network-call 

#### Kelebihan Microservices
- Mudah dimengerti, karena relative kecil ukuran service nya 
- Lebih mudah di develop, di maintain, di test dan di deploy 
- Lebih mudah bergonta-ganti teknologi 
- Mudah di scale sesuai kebutuhan 
- Bisa dikerjakan dalam tim-tim kecil 

#### Masalah di Arsitektur Microservices
- Distributed system
- Komunikasi antar service yang rawan error
- Testing interaksi antar service lebih sulit 

Monolith : Simplicity, Consistency, Easy to Refactor 
Microservices : Partial Deployment, Availability, Multiple Platform, Easy to Scale 

#### Kenapa Harus Database per Service? 
- Memastikan bahwa antar service tidak ketergantungan 
- Tiap service bisa menggunakan aplikasi database sesuai dengan kebutuhan 
- Service tidak perlu tahu kompleksitas internal database service lain 

#### Kapan Harus Shared Database? 
- Ketika melakukan transisi dari aplikasi Monolith ke Microservices 
- Ketika bingung memecahkan data antar Service 
- Ketika dikejar waktu, sehingga tidak ada waktu untuk bikin API 

#### Komunikasi Antar Service 
- ldealnya komunikasi dilakukan melalui RPI (Remote Procedure Invocation) atau RPC (Remote Procedure Call) 
- Tidak direkomendasikan komunikasi dilakukan via database 

#### Contoh Remote Procedure Invocation 
• RESTful API (HTTP) 
• gRPC 
• Apache Thrift 
• SOAP 
• Java RMI 
• Corba (Common Object Request Broker Architecture)

#### Keuntungan Menggunakan RPI 
- Sederhana dan Mudah 
- Biasanya digunakan untuk komunikasi Request -Reply 
- Biasanya digunakan untuk proses Sync (yang butuh menunggu jawaban) 

#### Masalah di Komunikasi RPI 
- Proses lama (pada Email Service dan SMS Service) 
- Mengirim data yang sama berkali-kali (pada Finance Service dan Report Service) - Membuat Paralel Process sangat rumit 

#### Komunikasi Dengan Cara Messaging 
- Messaging biasanya digunakan untuk komunikasi Async 
- Async artinya komunikasi dilakukan tanpa harus menunggu selesai di proses 
- Dalam async, kadang tidak perlu peduli balasan dari service yang dituju 
- Biasanya komunikasi Messaging membutuhkan Message Channel sebagai jembatan untuk mengirim dan menerima data 
- Direkomendasikan menggunakan aplikasi Message Broker untuk melakukan management Message Channel 

#### Contoh Message Broker 
• Redis (PubSub) 
• Apache Kafka 
• RabbitMQ 
• NSQ 
• Google PubSub 
• Amazon Web Service SQS 


#### Keuntungan Menggunakan Messaging
- Proses lebih cepat karena tidak harus menunggu response 
- Service pengirim data tidak perlu peduli terhadap penerima data 


#### Tipe Microservices 
• Stateless Microservice 
• Persistence Microservice 
• Aggregation Microservices 

#### Stateless Microservices
- Biasanya tidak memiliki database
- Digunakan untuk melakukan tugas sederhana
- Biasa digunakan juga sebagai utility untuk 
  microservice lain
- Tidak bergantung dengan microservice lain

#### Persistance Microservices
- Biasanya memiliki database
- Bisa juga disebut sebagai Master Data Microservice
- Biasa digunakan untuk mengolah data di database (CRUD)

#### Aggregation Microservices
- Tergantung dengan microservice lain
- Biasa digunakan sebagai pusat business logic aplikasi
- Boleh memiliki database ataupun tidak
- Tidak bisa berdiri sendiri

#### Service Orchestration
- Sebelumnya kita sudah bahas tentang tipe Aggregation Microservices
- Cara Aggregation Microservices berkomunikasi dengan Microservices lain, jika menggunakan Remote Procedure Invocation, maka dinamakan Service Orchestration Pattern
- Dalam Service Orchestration Pattern, Aggregation Microservices bertugas untuk mengatur alur business logic sistem.

#### Keuntungan Service Orchestration
- Mudah dibuat, karena kode business logic akan terpusat di Aggregation Microservices
- Mudah dimengerti, karena kode business logic akan terpusat di Aggregation Microservices

#### Kekurangan Service Orchestration
- Aggregation Microservices terlalu ketergantungan dengan Microservices lain
- Aggregation Microservices akan lebih lambat karena harus terkoneksi dengan Microservices lain
- Aggregation Microservices akan lebih mudah error jika di Microservices lain terdapat masalah
- Jika perlu Microservices baru, perlu dilakukan perubahan di Aggregation Microservices

#### Service Choreography
- Service Choreography berbeda dengan Service Orchestration.
- Dalam Service Choreography, komunikasi Aggregation Service dengan Microservices lainnya menggunakan Messaging.
- Dalam Service Orchestration, Aggregation Microservice adalah service yang sangat kompleks dan mengerti semua alur business logic, sedangkan berbeda dengan Service Choreography, semua Microservices dituntut untuk menjadi pintar, tidak hanya diperintah oleh Aggregation Microservices.

#### Keuntungan Service Choreography
- Aggregation Microservices tidak tergantung dengan Microservices lainnya
- Aggregation Microservice akan lebih cepat, karena tidak perlu berkomunikasi dengan Microservices lainnya
- Jika ada Microservice baru, Aggregation Microservice tidak perlu melakukan perubahan lagi


#### Kekurangan Service Choreography
- Lebih sulit di-debug ketika terjadi masalah
- Business logic akan terdistribusi di semua Microservices, sehingga sulit untuk dimengerti secara keseluruhan

#### Masalah Mengekspos Microservices
- Semua service bisa diakses dari luar
- Jika butuh Autentikasi, harus diimplementasikan di semua service
- Rawan terjadi kebocoran data

#### API Gateway
- API Gateway adalah aplikasi yang bertugas sebagai gerbang dari luar ke dalam
- Luar adalah akses dari Internet, dan Dalam adalah aplikasi microservices
- API Gateway bertugas sebagai proxy server ke semua aplikasi microservices
- Aplikasi microservices hanya bisa diakses dari luar melalui API Gateway

#### Keuntungan API Gateway
- Lebih aman karena satu gerbang
- Service tidak perlu mengimplementasikan proses Autentikasi, cukup dilakukan di API Gateway
- API Gateway juga bisa digunakan sebagai load balancer
- Bisa digunakan sebagai rate limiter
- Bisa digunakan sebagai pengaman sehingga error dari service tidak terekspos

#### Contoh API Gateway
• Nginx
• Apache HTTPD
• Kong
• Netflix Zuul
• Spring Cloud Gateway

#### Authentication dan Authorization
Authentication :                    Authorization :
•  Memvalidasi kredensial untuk     •  Authorization adalah proses 
   memverifikasi pemilik identitas     yang dilakukan setelah proses 
•  Contoh proses Authentication        Authentication
   adalah proses login menggunakan  •  Memvalidasi apakah pemilik 
   username dan password, dan          identitas memiliki hak akses 
   banyak yang lainnya.                untuk mengakses resource yang 
                                       diminta
                                    •  Contoh proses Authorization 
                                       adalah Access-Control List, dan 
                                       banyak yang lainnya.

#### Teknologi Pendukung
• Secure Cookie
• Oauth
• JSON Web Token
• Basic Auth
• API Key / Secret Key

#### Permasalahan Banyak Jenis Frontend
- Tiap frontend punya mekanisme autentikasi berbeda
- Kecepatan bandwidth tiap frontend berbeda
- API yang dibutuhkan tiap frontend berbeda
- Semua kebutuhan jenis frontend harus diimplementasikan di satu API Gateway

#### Backend for Frontend
- Backend for Frontend adalah menyediakan backend khusus untuk frontend tertentu
- Biasanya satu backend akan melayani satu frontend secara specific
- Makin banyak jenis frontend, makin banyak backend yang dibuat

#### Keuntungan Backend for Frontend
- Pengembangan backend untuk tiap frontend bisa terisolasi satu sama lain
- Logic untuk frontend tidak tercampur di satu backend

#### GraphQL : Alternative Backend for Frontedn
- GraphQL adalah query language untuk API
- GraphQL dapat digunakan untuk memanipulasi response API secara runtime
- Frontend bebas menentukan data apa aja yang ingin didapatkan
- Backend hanya perlu menyediakan data lengkap, dan Frontend bisa dengan bebas menentukan data apa aja yang diinginkan.

#### Keuntungan Menggunakan GraphOL
- Butuh melakukan development GraphQL Server di Backend
- Butuh melakukan development GraphQL Client di Frontend

#### Command Query Responsibility Segregation
- CQRS adalah proses membedakan operasi Command dan operasi Query
- Operasi Command adalah operasi mengubah data (Create, Update, Delete)
- Operasi Command adalah operasi mengambil data (Get, Search)
- Dalam CQRS, biasanya service atau database dibedakan untuk kebutuhan Command dan kebutuhan Query

#### Keuntungan CQRS
- Bisa memilih database berbeda yang optimal untuk proses Command dan Query, sehingga operasi Command dan Search bisa lebih cepat, karena database nya sudah disesuaikan dengan kebutuhan
- Membedakan model untuk Command dan Query di aplikasi akan lebih mudah dibanding digabung di satu model yang sama untuk proses Command dan Query
- Performa aplikasi akan lebih balk, karena kita membedakan component untuk Command dan Query

#### Keuntungan CQRS Menggunakan Messaging
- Aplikasi Command dan Query terpisah, sehingga bisa dikerjakan oleh tim yang berbeda secara paralel
- Aplikasi Command tidak perlu pusing memikirkan struktur data Aplikasi Query, hanya cukup mengirim datanya ke Message Broker
- Scaling aplikasi bisa sesuai dengan kebutuhan, balk itu Command atau Query
- Jika Aplikasi Query sedang stop atau error, data dari Aplikasi Command akan tetap aman tersimpan di Message Broker
- Mekanisme retry akan Iebih mudah dilakukan jika melalui Message Broker


#### Server Side Discovery
- Membuat server khusus sebagai router atau load balancer ke service
- Client hanya butuh terkoneksi ke router atau load balancer
- Jika jumlah node service bertambah atau berkurang, router yang hanya perlu dirubah, client tidak perlu berubah

#### Contoh Router atau Load Balancer
• Nginx
• Apache HTTPD
• Traefik

#### Kekurangan Server Side Discovery
- Tiap service harus memiliki router atau load balancer
- Agar tidak terjadi single point of failure, maka router atau load balancer harus di setup sebanyak 2 instance
- Cost biaya akan lebih mahal, karena 1 service harus menjalankan 2 router

#### Client Side Discovery
- Client side discovery adalah solusi agar client harus bisa tahu lokasi semua lokasi service yang akan dituju
- Tidak perlu lagi ada router atau load balancer untuk berkomunikasi dengan Service lain
- Semua logic untuk mendistribusikan traffic harus dilakukan di client atau service yang akan melakukan request

#### Kekurangan Client Slide Discovery
- Client harus tahu lokasi semua service
- Jika jumlah node service bertambah atau berkurang, client harus diubah untuk lokasi baru nya
- Jika client salah mengimplementasikan logic untuk load balancer, maka traffic ke service yang dituju bisa tidak merata pembagiannya

#### Service Registry
- Service Registry adalah aplikasi yang digunakan sebagai tempat untuk menyimpan semua informasi yang berhubungan dengan lokasi service
- Semua service akan meregistrasikan alamat lokasi nya di Service Registry ketika pertama kali nyala
- Semua service akan laporan ke Service Registry jika akan berhenti beroperasi, sehingga Service Registry akan menghilangkan informasi service tersebut agar tidak mendapat traffic dari service yang bertanya

#### Contoh Aplikasi Service Registry
• Hashicorp Consul [https://www.consul.io](https://www.consul.io)
• Netflix Eureka [https://github.com/Netflix/eureka](https://github.com/Netflix/eureka)

#### Dimana Menyimpan Konfigurasi?
- Konfigurasi adalah sesuatu yang tidak asing lagi saat membuat aplikasi
- Tiap aplikasi biasanya memiliki konfigurasi, seperti konfigurasi database misalnya
- Pertanyaannya, dimana sebaiknya menyimpan konfigurasi? Agar mudah untuk di maintain dan digunakan oleh aplikasi kita?

#### Contoh Lokasi Konfigurasi
• Database
• File
• Environment Variable

#### Centralized Configuration
• Centralized Configuration adalah pattern dimana kita menyimpan semua konfigurasi di sebuah aplikasi atau service
• Service yang butuh konfigurasi akan bertanya ke aplikasi tersebut   untuk mendapatkan data konfigurasinyauntuk mendapatkan data konfigurasinya

#### Contoh Aplikasi Centralized Configuration
• Hashicorp Consul https://www.consul.io/
• Hashicorp Vault https://www.vaultproject.io/• Etcd https://etcd.io/
• Etcd https://etcd.io/
• Zookeeper https://zookeeperapache.org/
• Doozerd https://github.com/ha/doozerd 



## Task
### 1. Problem 1 - Centralized and Decentralized Database
Pada task ini, mengimplementasikan rancangan diagram

[Problem 1](./praktikum/Task.txt)

output:

![Problem 1](./screenshots/1.PNG)

### 2. Problem 2 - Services Communication
Pada task ini, mengimplementasikan rancangan dengan Rest

output:

![Problem 2](./screenshots/1.PNG)







