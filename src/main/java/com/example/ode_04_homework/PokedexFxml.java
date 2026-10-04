package com.example.ode_04_homework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PokedexFxml extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                PokedexFxml.class.getResource("hello-view.fxml")
        );

        Scene scene = loader.load();

        stage.setTitle("Pokedex");
        stage.setScene(scene);
        stage.show();
    }
}