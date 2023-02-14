/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec;

import static br.com.fatec.Cliente.setStage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ricardinojr
 */
public class Consulta {
   
    public static Stage tela;

    public void start(Stage tela) throws Exception {
        setStage(tela);
        
        Parent root = FXMLLoader.load(getClass().getResource("ViewConsulta.fxml"));
        
        Scene scene = new Scene(root);
        
        tela.setScene(scene);
        tela.setTitle("Consulta");
        tela.show();        
    }
    
    public static void setStage(Stage t) {
        tela = t;
    }
    
}