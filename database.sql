CREATE DATABASE okul_sistemi;
USE okul_sistemi;
CREATE TABLE ogrenciler (
    id INT IDENTITY(1,1) PRIMARY KEY,
    isim VARCHAR(50) NOT NULL,
    soyisim VARCHAR(50) NOT NULL,
    not_ortalamasi DECIMAL(5,2)
);
