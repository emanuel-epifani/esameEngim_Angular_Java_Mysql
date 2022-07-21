package com.example.be_java_esamefinale;

import com.example.be_java_esamefinale.repository.ArticoliRepository;
import com.example.be_java_esamefinale.repository.OrdiniRepository;

import java.util.ArrayList;

import static com.example.be_java_esamefinale.controller.Controller.getAllOrderWithTheirBetterRate;

public class Debug {


    public static void main(String[] args) {
//        ArticoliRepository.getAllArticoliByOrder(1);
        //OrdiniRepository.getAllOrdini();


        getAllOrderWithTheirBetterRate();

    }
}
