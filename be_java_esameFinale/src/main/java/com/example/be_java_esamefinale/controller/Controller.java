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
import java.util.Collections;

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
        //prendo tutti gli ordini
        return OrdiniRepository.getAllOrdini();
    }

    @GetMapping("/ordinConPreventivo")
    public static ArrayList<OrdineConPreventivo> getAllOrderWithTheirBetterRate() {
        ArrayList elencoOrdiniConPreventivo = new ArrayList();
        //prendo tutti gli ordini
        ArrayList<Ordine> ordini = OrdiniRepository.getAllOrdini();
        //per ogni ordine mi trovo la tariffa migliore
        for (Ordine ordine: ordini) {
            //mi cerco il preventivo migliore
            TariffaCorriere migliorPreventivoPerQuestordine = getBetterRaceOfThisOrder(ordine);
            //creo l'oggetta aggiungendoci il preventivo
            OrdineConPreventivo ordineConPreventivo = new OrdineConPreventivo(
                    ordine.getId(),
                    ordine.getNumero(),
                    ordine.getData(),
                    migliorPreventivoPerQuestordine);
            //e lo aggiungo all'array
            elencoOrdiniConPreventivo.add(ordineConPreventivo);
            }
        return  elencoOrdiniConPreventivo;
    }


    //-------------------------------------gia filtrate---------------------------

    @GetMapping("/articoliOrdine")
    public static TariffaCorriere getBetterRaceOfThisOrder(Ordine ordine) {
        //avendo l'id dell'ordine mi recupero tutti gli articoli associati
        ArrayList<Articolo> articoliDiQuestoOrdine = ArticoliRepository.getAllArticoliByOrder(ordine.getId());
        //una volta ottenuti tutti gli articoli mi calcolo il totale del peso dell'ordina
        double totalePesoOrdine = summWeightsOfArticles(articoliDiQuestoOrdine);
        //mi controllo fra tutti qual'è il preventivo migliore per questo ordine
        return searchBetterRaceOfThisOrder(totalePesoOrdine);
    }


    public static double summWeightsOfArticles(ArrayList<Articolo> articles) {
        double sumOfAllArticles = 0;
        for (Articolo weightArticles: articles) {
            sumOfAllArticles = sumOfAllArticles + weightArticles.getPeso();
        }
        return sumOfAllArticles;
    }


    public static TariffaCorriere searchBetterRaceOfThisOrder(double pesoTotaleOrdine) {

        ArrayList<TariffaCorriere> tutteLeTariffe = TariffeRepository.getAllTariffe();
        ArrayList<TariffaCorriere> tutteLeTariffeValide = new ArrayList<>();

        //mi recupero tutte le tariffe valide (cioè che il peso ci sta)
        for (TariffaCorriere rate: tutteLeTariffe) {
            if(pesoTotaleOrdine < rate.getPeso_max()){
                tutteLeTariffeValide.add(rate);
            }
        }

        //guardo tra tutte quelle valide quella con costo minore
        TariffaCorriere betterRate = tutteLeTariffeValide.get(0);

        for (TariffaCorriere rate: tutteLeTariffe) {
            if(betterRate.getCosto() > rate.getCosto() ) {
                betterRate = rate;
            }
        }
        return betterRate;
        }




}
