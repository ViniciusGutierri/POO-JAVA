/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fatec;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Vinicim
 */
public class Cliente extends Application {
    
    public static Stage tela;

    @Override
    public void start(Stage tela) throws Exception {
        setStage(tela);
        
        Parent root = FXMLLoader.load(getClass().getResource("ViewCliente.fxml"));
        
        Scene scene = new Scene(root);
        
        tela.setScene(scene);
        tela.setTitle("Cadastro de Cliente");
        tela.show();        
    }
    
    
    public static void setStage(Stage t) {
        tela = t;
    }
}
