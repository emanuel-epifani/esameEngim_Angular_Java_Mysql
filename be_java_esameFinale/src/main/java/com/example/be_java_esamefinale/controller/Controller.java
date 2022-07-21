package com.example.be_java_esamefinale.controller;

import com.example.be_java_esamefinale.models.Articolo;
import com.example.be_java_esamefinale.models.Ordine;
import com.example.be_java_esamefinale.models.TariffaCorriere;
import com.example.be_java_esamefinale.models.payloads.OrdineConPreventivo;
import com.example.be_java_esamefinale.repository.ArticoliRepository;
import com.example.be_java_esamefinale.repository.OrdiniRepository;
import com.example.be_java_esamefinale.repository.TariffeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {


    @GetMapping("/articoli")
    public static ArrayList<Articolo> getAllArticoli() {
        return ArticoliRepository.getAllArticoli();
    }

    @GetMapping("/tariffe")
    public static ArrayList<TariffaCorriere> getAllTariffe() {
        return TariffeRepository.getAllTariffe();
    }

//    @GetMapping("/ordini")
//    public static ArrayList<OrdineConPreventivo> getAllOrdini() {
//        //return OrdiniRepository.getAllOrdini();
//    }


//    public static TariffeRepository searchBetterRate(Ordine ordine) {
//        ordine.
//    }





}
