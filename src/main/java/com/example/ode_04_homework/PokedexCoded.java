package com.example.ode_04_homework;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PokedexCoded extends Application {
    TextArea txt_log = new TextArea();

    @Override
    public void start(Stage primaryStage) throws Exception{
        ObservableList<String> pokedex = PokedexData.pokedex;
        VBox topvbox = new VBox();
        topvbox.setPadding(new Insets(10));
        topvbox.setSpacing(10);
        BorderPane borderpane = new BorderPane();
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(0,10,0,0));
        ListView<String> list_pokedex = new ListView<>();

        TextField txt_name = new TextField();
        txt_name.setPromptText("Name");
        TextField txt_level = new TextField();
        txt_level.setPromptText("Level");
        TextField txt_hp= new TextField();
        txt_hp.setPromptText("Health Points");
        TextField txt_exp = new TextField();
        txt_exp.setPromptText("Experience");

        Button btn_add = new Button("Add");
        btn_add.setPrefWidth(200);
        Button btn_remove = new Button("Remove");
        btn_remove.setPrefWidth(200);
        Button btn_clear = new Button("Clear Pokedex");
        btn_clear.setPrefWidth(200);

        list_pokedex.setItems(pokedex);
        btn_add.setOnAction(e -> {
            log("Button add clicked");
            String name = txt_name.getText();

            try {
                int level = Integer.parseInt(txt_level.getText());
                int int_hp = Integer.parseInt(txt_hp.getText());
                int int_exp = Integer.parseInt(txt_exp.getText());
                Pokemon p = new Pokemon(name, level, int_hp, int_exp);
                pokedex.add(p.toString());
            } catch (NumberFormatException e1) {
                log("Invalid integer input! (Level, EXP and/or HP)");
            }

        });
        btn_remove.setOnAction(e -> {
            if (pokedex.remove(list_pokedex.getSelectionModel().getSelectedItem())){
                log("Pokemon ki... ahem .. released");
            }

        });
        btn_clear.setOnAction(event -> {
            if (pokedex.removeAll(list_pokedex.getItems())){
                log("Pokedex cleared");
            }
        });
        topvbox.getChildren().addAll(txt_log, borderpane);
        borderpane.setLeft(vbox);
        borderpane.setCenter(list_pokedex);
        vbox.getChildren().addAll(
                txt_name, txt_level, txt_hp, txt_exp,
                btn_add, btn_remove, btn_clear
        );
        Scene scene = new Scene(topvbox, 500, 300);
        primaryStage.setTitle("Pokedex");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void log (String s){
        txt_log.appendText(s + "\n");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Pokemon{
    String n;
    int l;
    int exp;
    int hp;

    public Pokemon(String n, int l, int hp, int exp) {
        this.n = n;
        this.l = l;
        this.hp = hp;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return n + " (" + l + ") HP: " + hp + " EXP: " + exp;
    }
}