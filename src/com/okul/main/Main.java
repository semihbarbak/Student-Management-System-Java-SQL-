package com.okul.main;

import com.okul.dao.StudentDAO;
import com.okul.model.Student;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        StudentDAO islemYapan = new StudentDAO();
        Scanner klavye = new Scanner(System.in);
        boolean sistemAcik = true;

        System.out.println("=== YILDIZ OKUL OTOMASYONUNA HOŞ GELDİNİZ ===");

        // sistemAcik "true" olduğu sürece bu döngü sonsuza kadar döner
        while (sistemAcik) {
            System.out.println("\nLütfen yapmak istediğiniz işlemi seçin:");
            System.out.println("1 - Yeni Öğrenci Ekle");
            System.out.println("2 - Tüm Öğrencileri Listele");
            System.out.println("0 - Sistemden Çıkış Yap");
            System.out.print("Seçiminiz: ");

            int secim = klavye.nextInt();
            klavye.nextLine(); // DİKKAT: nextInt'ten sonra "Enter" tuşunun boşluğunu temizlemek için bu şarttır!

            switch (secim) {
                case 1:
                    System.out.println("\n--- YENİ ÖĞRENCİ KAYDI ---");
                    System.out.print("Öğrencinin Adı: ");
                    String isim = klavye.nextLine();
                    
                    System.out.print("Öğrencinin Soyadı: ");
                    String soyisim = klavye.nextLine();
                    
                    System.out.print("Not Ortalaması (Örn: 85,5): ");
                    // Türkçe klavyelerde ondalıklı sayılar bazen nokta (.) yerine virgül (,) ile girilir.
                    double notOrt = klavye.nextDouble();
                    
                    // Kullanıcıdan aldığımız verilerle yeni bir öğrenci paketi hazırlıyoruz
                    Student yeniOgrenci = new Student(isim, soyisim, notOrt);
                    // Kuryemize "Al bu paketi veritabanına götür" diyoruz
                    islemYapan.ogrenciEkle(yeniOgrenci);
                    break;

                case 2:
                    islemYapan.ogrenciListele();
                    break;

                case 0:
                    System.out.println("Sistem kapatılıyor... İyi günler dileriz!");
                    sistemAcik = false; // Döngüyü kırar ve programı bitirir
                    break;

                default:
                    System.out.println("Hatalı bir tuşa bastınız! Lütfen menüdeki rakamlardan birini seçin.");
                    break;
            }
        }
        
        klavye.close(); // Program bitince klavye dinleyicisini kapatıyoruz (hafıza tasarrufu)
    }
}