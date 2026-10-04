package com.example.ode_04_homework;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PokedexFxml {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
