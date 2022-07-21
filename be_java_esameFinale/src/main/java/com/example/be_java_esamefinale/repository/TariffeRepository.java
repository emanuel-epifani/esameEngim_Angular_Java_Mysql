package com.example.be_java_esamefinale.repository;

import com.example.be_java_esamefinale.models.Ordine;
import com.example.be_java_esamefinale.models.TariffaCorriere;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.example.be_java_esamefinale.constants.CredentialConnectionDB.*;

public class TariffeRepository {

    public static ArrayList<TariffaCorriere> getAllTariffe(){
        // creo una lista da restituire
        ArrayList<TariffaCorriere> tariffe = new ArrayList<>();

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement("select * from tariffe_corrieri");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){

                // creo una fermata con i dati del DB
                TariffaCorriere tariffa = new TariffaCorriere(
                        rs.getInt("id"),
                        rs.getString("nome_corriere"),
                        rs.getString("nome_tarifa"),
                        rs.getDouble("peso_max"),
                        rs.getDouble("costo")
                );

                // aggiungo alla lista
                tariffe.add(tariffa);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco la lista
        return tariffe;
    }

}
