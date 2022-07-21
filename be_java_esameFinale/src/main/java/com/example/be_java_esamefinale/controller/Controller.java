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

import java.lang.annotation.Target;
import java.util.ArrayList;

@RestController
public class Controller {

    //-----------------------------------get semplici-------------------------------
    @GetMapping("/articoli")
    public static ArrayList<Articolo> getAllArticoli() {
        return ArticoliRepository.getAllArticoli();
    }

    @GetMapping("/tariffe")
    public static ArrayList<TariffaCorriere> getAllTariffe() {
        return TariffeRepository.getAllTariffe();
    }

    @GetMapping("/ordini")
    public static ArrayList<Ordine> getAllOrdini() {
        return OrdiniRepository.getAllOrdini();
    }



    //-------------------------------------gia filtrate---------------------------

    @GetMapping("/articoliOrdine")
    public static ArrayList<OrdineConPreventivo> getBetterRaceOfThisOrder(Ordine ordine) {
        //avendo l'id dell'ordine mi recupero tutti gli articoli associati
        ArrayList<Articolo> articoliDiQuestoOrdine = ArticoliRepository.getAllArticoliByOrder(ordine.getId());
        //una volta ottenuti tutti gli articoli mi calcolo il totale del peso dell'ordina
        double totalePesoOrdine = summWeightsOfArticles(articoliDiQuestoOrdine);
        //mi controllo fra tutti qual'è il preventivo migliore per questo ordine
        TariffaCorriere preventivomigliore = ;
    }






    public static double summWeightsOfArticles(ArrayList<Articolo> articles) {
        double sumOfAllArticles = 0;
        for (Articolo weightArticles: articles) {
            sumOfAllArticles = sumOfAllArticles + weightArticles.getPeso();
        }
        return sumOfAllArticles;
    }

    public static TariffaCorriere searchBetterRaceOfThisOrder(double pesoOrdine) {
        ArrayList<TariffaCorriere> tutteLeTariffe = TariffeRepository.getAllTariffe();
        ArrayList<TariffaCorriere> tutteLeTariffeValide = new ArrayList<>();
        ArrayList<Integer> tmpTariffeValidePrezzo = new ArrayList<>();

        //mi recupero tutte le tariffe valide (cioè che il peso ci sta)
        for (TariffaCorriere rate: tutteLeTariffe) {
            if(pesoOrdine < rate.getPeso_max()){
                tutteLeTariffeValide.add(rate);
            }
        }

        //cerco quella con costo minore
//        for (TariffaCorriere validRate: tutteLeTariffeValide) {
//
//            TariffaCorriere min = tutteLeTariffeValide.get(0);
//
//            for(int i=1; i<tutteLeTariffeValide.size(); i++) {
//
//                if(min.getCosto() > tutteLeTariffeValide[i]. ) {
//                    min = array[i];
//                }
//            }
//
//        }



        return min;


        }

        //la tariffa migliore





}
