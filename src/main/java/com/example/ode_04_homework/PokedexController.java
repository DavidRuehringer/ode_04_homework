package com.example.ode_04_homework;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PokedexController {

    @FXML
    private TextField name;

    @FXML
    private TextField level;

    @FXML
    private TextField hp;

    @FXML
    private TextField exp;

    @FXML
    private ListView<String> list_pokedex;

    @FXML
    private TextArea log;

    @FXML
    private void pokemonAdd() {
        log.appendText("Button add clicked\n");
        String pokemonName = name.getText();

        try {
            int pokemonLevel = Integer.parseInt(level.getText());
            int pokemonHp = Integer.parseInt(hp.getText());
            int pokemonExp = Integer.parseInt(exp.getText());

            Pokemon p = new Pokemon(
                    pokemonName,
                    pokemonLevel,
                    pokemonHp,
                    pokemonExp
            );

            PokedexData.pokedex.add(p.toString());

        } catch (NumberFormatException e) {
            log.appendText("Invalid integer input! (Level, EXP and/or HP)\n");
        }
    }


    @FXML
    private void pokemonRemove() {
        String selectedPokemon =
                list_pokedex.getSelectionModel().getSelectedItem();

        if (PokedexData.pokedex.remove(selectedPokemon)) {
            log.appendText("Pokemon ki... ahem .. released\n");
        }
    }


    @FXML
    private void pokedexClear() {
        if (!PokedexData.pokedex.isEmpty()) {
            PokedexData.pokedex.clear();
            log.appendText("Pokedex cleared\n");
        }
    }

    @FXML
    public void initialize() {
        list_pokedex.setItems(PokedexData.pokedex);
    }
}