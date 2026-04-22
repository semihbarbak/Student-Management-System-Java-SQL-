package com.okul.dao;

import com.okul.model.Student;
import com.okul.util.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    // Öğrenci ekleme işlemimizi yapacak ana metot
    public void ogrenciEkle(Student ogrenci) {
        
        // Soru işaretleri (?) Java'nın güvenlik önlemidir. 
        // "Buraya dışarıdan veri gelecek, yerini hazır tut" demektir.
        String sqlSorgusu = "INSERT INTO ogrenciler (isim, soyisim, not_ortalamasi) VALUES (?, ?, ?)";

        // Bağlantıyı try-with-resources bloğunda açıyoruz ki işlem bitince bağlantı otomatik kapansın (Kusursuzluk detayı 1)
        try (Connection baglanti = DatabaseConnection.getConnection();
             PreparedStatement hazirlanmisSorgu = baglanti.prepareStatement(sqlSorgusu)) {

            // Soru işaretlerinin yerine, gönderdiğimiz öğrencinin bilgilerini yerleştiriyoruz
            hazirlanmisSorgu.setString(1, ogrenci.getIsim());          // 1. soru işareti = isim
            hazirlanmisSorgu.setString(2, ogrenci.getSoyisim());       // 2. soru işareti = soyisim
            hazirlanmisSorgu.setDouble(3, ogrenci.getNotOrtalamasi()); // 3. soru işareti = not ortalaması

            // Sorguyu çalıştır ve veritabanına kaydet
            int etkilenenSatir = hazirlanmisSorgu.executeUpdate();

            if (etkilenenSatir > 0) {
                System.out.println("Başarılı: " + ogrenci.getIsim() + " isimli öğrenci veritabanına kusursuzca eklendi!");
            }

        } catch (SQLException e) {
            System.out.println("HATA: Öğrenci eklenirken bir sorun oluştu! Detay: " + e.getMessage());
        }
    }
 // Veritabanındaki tüm öğrencileri çekip ekrana yazdıran metot
    public void ogrenciListele() {
        
        // SQL'den tüm öğrencileri getir diyoruz
        String sqlSorgusu = "SELECT * FROM ogrenciler";

        try (Connection baglanti = DatabaseConnection.getConnection();
             PreparedStatement hazirlanmisSorgu = baglanti.prepareStatement(sqlSorgusu);
             // ResultSet, SQL'den dönen tabloyu Java'da satır satır okumamızı sağlar
             ResultSet sonucTablosu = hazirlanmisSorgu.executeQuery()) {

            System.out.println("\n--- KAYITLI ÖĞRENCİLER LİSTESİ ---");
            System.out.println("ID\tİSİM\t\tSOYİSİM\t\tNOT ORT.");
            System.out.println("--------------------------------------------------");

            // sonucTablosu.next() demek: "Okunacak sıradaki satır var mı?" demektir.
            // Olduğu sürece döngü çalışır ve her öğrenciyi ekrana basar.
            while (sonucTablosu.next()) {
                int id = sonucTablosu.getInt("id");
                String isim = sonucTablosu.getString("isim");
                String soyisim = sonucTablosu.getString("soyisim");
                double notOrt = sonucTablosu.getDouble("not_ortalamasi");

                System.out.println(id + "\t" + isim + "\t\t" + soyisim + "\t\t" + notOrt);
            }
            System.out.println("--------------------------------------------------");

        } catch (SQLException e) {
            System.out.println("HATA: Öğrenciler listelenirken bir sorun oluştu! Detay: " + e.getMessage());
        }
    } 
}