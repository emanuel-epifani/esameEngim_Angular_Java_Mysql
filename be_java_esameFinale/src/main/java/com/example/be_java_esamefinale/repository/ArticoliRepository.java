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


        public static ArrayList<Articolo> getAllArticoli(){
            // creo una lista da restituire
            ArrayList<Articolo> articoli = new ArrayList<>();

            try{
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement stmt = conn.prepareStatement("select * from articoli");
                ResultSet rs = stmt.executeQuery();

                while(rs.next()){

                    // creo una fermata con i dati del DB
                    Articolo articolo = new Articolo(
                            rs.getInt("id"),
                            rs.getString("codice"),
                            rs.getString("descrizione"),
                            rs.getDouble("peso") );

                    // aggiungo alla lista
                    articoli.add(articolo);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            //restituisco la lista
            return articoli;
        }
//
//        public static ArrayList<Articolo> getAllArticoliByOrder(Ordine ordine) {
//
//
//            // dichiaro l'oggetto da restituire
//            Fermata fermata = null;
//            try{
//                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//                PreparedStatement stmt = conn.prepareStatement("select id,nome,zona from fermate where id = ? ");
//                stmt.setInt(1,numero_fermata);
//                ResultSet rs = stmt.executeQuery();
//
//                while(rs.next()){
//                    // istanzio l'oggetto da restituire preso dal DB
//                    fermata = new Fermata(rs.getInt("id"),rs.getString("nome"),rs.getString("zona"));
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            //restituisco la Fermata
//            return fermata;
//
//
//        }


}
