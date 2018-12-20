package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {
    /**
     * pole conn typu Connection przechowujące referencję do obiektu reprezentującego połączenie do bazy danych. Connection jest interfejsem dostarczanym przez bibliotekę java.sql. Interfejs ten udostępnia szereg metod związanych z zadawaniem zapytań do bazy danych oraz obsługą połączenia.
     * */
    private Connection conn;
    private static DbManager dbManagerInstance;

    private DbManager() throws SQLException {
        /**
         * Klasa Properties jest bardzo podobna do kolekcji HashMap - przechowuje pary wartości key-value (klucz-wartość).
         * */

        Properties connectionProps = new Properties();
        connectionProps.put("user", "kodilla_user");
        connectionProps.put("password", "kodilla_password");

        /**
         * tworzymy połączenie do bazy danych przy pomocy statycznej metody getConnection(String url, Properties info) klasy DriverManager dostarczanej przez bibliotekę java.sql. Pierwszy parametr tej metody (url) to tak zwany "connection string". Poszczególne jego części oznaczają:
         * stały tekst "jdbc:mysql://" mówiący o tym, że korzystamy ze sterownika jdbc właściwego dla bazy danych MySQL.
         * następnie wskazujemy serwer i port: "localhost:3306/"
         * kolejny fragment wskazuje, o którą bazę danych na tym serwerze nam chodzi: "kodilla_course"
         * i wreszcie musimy wskazać strefę czasową, w jakiej działa serwer: "?serverTimezone=Europe/Warsaw"
         * na końcu dodajemy jeszcze parametr "&useSSL=False", który wyłącza używanie protokołu SSL (w przeciwnym razie potrzebowalibyśmy certyfikatów do nawiązania połączenia).
         * Drugi z parametrów - info to obiekt typu Properties. Obiekt ten w najprostszej, używanej przez nas, postaci zawiera nazwę i hasło użytkownika.
         * */

        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw" +
                        "&useSSL=False",
                connectionProps);
    }

    public static DbManager getInstance() throws SQLException {
        if (dbManagerInstance == null) {
            dbManagerInstance = new DbManager();
        }
        return dbManagerInstance;
    }

    public Connection getConnection() {
        /**
         * obiekt przechowujący połączenie z bazą danych - będziemy używali go do tworzenia zapytań do bazy danych.
         * */
        return conn;
    }
}
