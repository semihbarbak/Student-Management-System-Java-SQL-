package com.okul.model;

public class Student {
    
    // Veritabanındaki sütunlara karşılık gelen değişkenlerimiz (Fields)
    private int id;
    private String isim;
    private String soyisim;
    private double notOrtalamasi;

    // 1. Boş Constructor (Kurucu Metot)
    public Student() {
    }

    // 2. Dolu Constructor (Yeni öğrenci eklerken kullanacağız - ID veritabanında otomatik artacağı için ID yok)
    public Student(String isim, String soyisim, double notOrtalamasi) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.notOrtalamasi = notOrtalamasi;
    }

    // 3. Tam Dolu Constructor (Veritabanından öğrenci çekerken tüm bilgileriyle almak için)
    public Student(int id, String isim, String soyisim, double notOrtalamasi) {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.notOrtalamasi = notOrtalamasi;
    }

    // Getter ve Setter Metotları (Private verilere güvenli erişim için)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public double getNotOrtalamasi() {
        return notOrtalamasi;
    }

    public void setNotOrtalamasi(double notOrtalamasi) {
        this.notOrtalamasi = notOrtalamasi;
    }
}