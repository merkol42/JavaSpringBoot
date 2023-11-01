-- Veritabanını oluştur (varsa zaten var olanı kullan)
CREATE DATABASE student_tracker;

-- Oluşturulan veritabanı üzerinde çalış
\c student_tracker;

-- student tablosunun yapısını oluştur

-- Eğer tablo mevcutsa sil
DROP TABLE IF EXISTS student;

-- Yeni tabloyu oluştur
CREATE TABLE student (
  id serial PRIMARY KEY,
  first_name varchar(45),
  last_name varchar(45),
  email varchar(45)
);
