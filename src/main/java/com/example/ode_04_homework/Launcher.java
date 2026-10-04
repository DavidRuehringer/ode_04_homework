package com.example.ode_04_homework;

import javafx.application.Application;


public class Launcher {
    public static void main(String[] args) {

        char mode = 'c';


        if (mode == 'c'){
            Application.launch(PokedexCoded.class, args);
        } else if (mode == 'f') {
            Application.launch(PokedexFxml.class, args);
        }
    }
}
