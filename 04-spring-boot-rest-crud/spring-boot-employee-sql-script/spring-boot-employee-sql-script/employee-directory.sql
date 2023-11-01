-- Veritabanını oluştur, eğer zaten mevcut değilse
CREATE DATABASE employee_directory;

-- Oluşturulan veritabanıyla etkileşime gir
\c employee_directory;

-- 'employee' tablosunun yapısı
DROP TABLE IF EXISTS employee;

-- 'employee' tablosunu oluştur
CREATE TABLE employee (
  id serial PRIMARY KEY,
  first_name varchar(45),
  last_name varchar(45),
  email varchar(45)
);

-- 'employee' tablosuna veri ekle
INSERT INTO employee (first_name, last_name, email) VALUES 
  ('Leslie', 'Andrews', 'leslie@luv2code.com'),
  ('Emma', 'Baumgarten', 'emma@luv2code.com'),
  ('Avani', 'Gupta', 'avani@luv2code.com'),
  ('Yuri', 'Petrov', 'yuri@luv2code.com'),
  ('Juan', 'Vega', 'juan@luv2code.com');
