/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unicam.cs.pa.giocoScacchiera.app;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * main del progetto
 */
public class App extends Application {
    @Override
    public void start(Stage primo) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/menuIniziale.fxml")));
        primo.setTitle("SCACCHIERA APP");
        primo.setScene(new Scene(root,360,200));
        primo.setResizable(false);
        primo.show();
    }

    /**
     * main
     * @param args argomenti main
     */
    public static void main(String[] args) {
        launch(args);
    }
}
