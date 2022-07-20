package com.example.be_java_esamefinale.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {

    public static String bob = "BOB";


    @GetMapping("/bob")
    public static String getBob() {
        return bob;
    }

}
