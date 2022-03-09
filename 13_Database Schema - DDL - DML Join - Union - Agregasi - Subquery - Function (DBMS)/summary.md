# (13) Database Schema - DDL - DML Join - Union - Agregasi - Subquery - Function (DBMS)

## Resume
Dalam materi ini, mempelajari:
1. Database Schema
2. Database Relationship
3. RDBMS
4. SQL


### Database
merupakan sebuah kumpulan data yang terorganisir yang tersimpan dalam sistem komputer

### Database Relationship
Database Relationship adalah sebuah hubungan entity dalam database.
- One to One
- One to Many
- Many to Many

### Entity Relationship Diagram
Diagram yang digunakan untuk perancangan database 


|  | department |       
| --- | --- |       
| pk  | id   |
| 	  | name |

|  | employee |       
| --- | --- |       
| pk  | id   |
| 	  | name |
| 	  | phone |
| fk  | department_id |

### RDBMS
Adalah sebuah aplikasi untuk melakukan manajemen sistem

### SQL
SQL Structured Query Language adalah bahasa pemrograman yang digunakan untuk manajemen sebuah data

### DDL
Data Definition Language Perintah digunakan untuk mengubah dan menghapus struktur dan definisi skema database.

#### DDL Statement

```
SHOW DATABASES;
CREATE DATABASE database_name;
USE database_name;
CREATE TABLE ...
DROP TABLE ...
RENAME TABLE ...
```

```
// membuat table
CREATE TABLE user(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email CARCHAR(255));

```

```
// memodifikasi table
ALTER TABLE user
ADD COLUMN password VARCHAR(255);

```


### DML
Data Manipulation Language perintah yang digunakan untuk mengakses dan memodifikasi data padadatabase.

#### Statement Operation
- INSERT
```
INSERT INTO user (username, name, email, password, address)
VALUES('alterra', 'AlterraAcademy', 'alterra@gmail.com', '123, 'malang');
```
- SELECT
```
SELECT * FROM user;

// dengan kondisi
SELECT * FROM user WHERE id=1;
```
- UPDATE 
```
UPDATE user
SET name = 'hendro'
WHERE id=1;
```
- DELETE
```
DELETE FROM user WHERE id=1;
```

#### DML Statement
- LIKE / BETWEEN
```
SELECT * FROM user WHERE name LIKE '%Alterra%';

SELECT * FROM user WHERE id BETWEEN 3 AND 10;
```
- AND / OR
- ORDER BY
```
SELECT * FROM user ORDER BY name ASC;
```
- LIMIT
```
SELECT * FROM user LIMIT 3;
```


## Task
### 1. Implement the Schema (Digital Outlet Pulsa) 
Pada task ini, membuat schema database menggunakan draw.io 


[Task 1 ](./praktikum/Task.txt)\
output:\
![Task 1](./screenshots/task1.PNG)

### 2. Data Definition Language 
Pada task ini, mengimplementasikan schema tersebut menjadi tabel di MySQL menggunakan terminal.


Create Database\
output:\
![ 1](./screenshots/1.PNG)

Create tabel user\
output:\
![ 2.a](./screenshots/2.a.PNG)

Create tabel product\
output:\
![ 2.b](./screenshots/2.b.PNG)

Create tabel transaction\
output:\
![ 2.c](./screenshots/2.c.PNG)

Create tabel kurir\
output:\
![ 3](./screenshots/3.PNG)

menambahkan ongkos_dasar column di tabel kurir\
output:\
![ 4](./screenshots/4.PNG)

rename tabel kurir menjadi shipping\
output:\
![ 5](./screenshots/5.PNG)

Hapus tabel shipping\
output:\
![ 6](./screenshots/6.PNG)




