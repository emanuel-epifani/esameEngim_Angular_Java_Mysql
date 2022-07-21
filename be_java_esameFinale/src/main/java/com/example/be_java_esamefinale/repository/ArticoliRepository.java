package com.example.be_java_esamefinale.repository;

import com.example.be_java_esamefinale.models.Articolo;
import com.example.be_java_esamefinale.models.Ordine;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;

import static com.example.be_java_esamefinale.constants.CredentialConnectionDB.*;
import static java.sql.DriverManager.getConnection;

public class ArticoliRepository {


    public static ArrayList<Articolo> getAllArticoli() {
        // creo una lista da restituire
        ArrayList<Articolo> articoli = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("select * from articoli");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                // creo una fermata con i dati del DB
                Articolo articolo = new Articolo(
                        rs.getInt("id"),
                        rs.getString("codice"),
                        rs.getString("descrizione"),
                        rs.getDouble("peso"));

                // aggiungo alla lista
                articoli.add(articolo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco la lista
        return articoli;
    }

    public static ArrayList<Articolo> getAllArticoliByOrder(int id) {

        ArrayList<Integer> idOfArticolsOfOrder = new ArrayList<>();
        ArrayList<Articolo> articolsOfOrder = new ArrayList<>();

        //mi ricavo tutti gli id degli articoli di un singolo ordine
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("select * from voce where id_ordine = ? ");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            //mi ricavo tutti gli id degli articoli di quell'ordine
            while (rs.next()) {
                id = rs.getInt("id_articolo");
                idOfArticolsOfOrder.add(id);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        //ora che ho l'array con gli id di tutti gli articoli.. x ogni id mi recupero l'articolo (e lo aggiungo ad un array x poi sommarli tutti)
        for (int id_article: idOfArticolsOfOrder) {
            try {
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement stmt = conn.prepareStatement("select * from articoli where id = ? ");
                stmt.setInt(1, id_article);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    // creo una fermata con i dati del DB
                    Articolo articolo = new Articolo(
                            rs.getInt("id"),
                            rs.getString("codice"),
                            rs.getString("descrizione"),
                            rs.getDouble("peso"));

                    // aggiungo alla lista
                    articolsOfOrder.add(articolo);
                }

            } catch(SQLException e) {
                e.printStackTrace();
            }
        }

        //restituisco la Fermata
        return articolsOfOrder;

        }


}
