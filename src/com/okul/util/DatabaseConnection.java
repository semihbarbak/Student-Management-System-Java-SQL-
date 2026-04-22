package com.okul.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    // Şifresiz (Windows Authentication) giriş için güncellenmiş bağlantı adresi
    // integratedSecurity=true komutu, bilgisayarının oturumuyla direkt girmesini sağlar
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=okul_sistemi;integratedSecurity=true;encrypt=false;";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Şifre sormadan sadece URL ile kapıyı açmayı deniyoruz
            connection = DriverManager.getConnection(URL);
            System.out.println("Harika! Veritabanı bağlantısı BAŞARILI!");
        } catch (SQLException e) {
            System.out.println("Eyvah! Veritabanı bağlantısı BAŞARISIZ! Hata: " + e.getMessage());
        }
        return connection;
    }
}