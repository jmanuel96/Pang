/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.josemanuelcarrasco.pangfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author josemanuel
 */
public class PangFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        int ancho = 1366;
        int alto = 768;
        Rectangle ContornoVertical = new Rectangle(0, 0, 15, 1500);
        ContornoVertical.setFill(Color.GREENYELLOW);
        Rectangle ContornoVertical2 = new Rectangle(1349,0,1366,780);
        ContornoVertical2.setFill(Color.GREENYELLOW);
        Rectangle ContornoHorizontal = new Rectangle(0,0,1366,15);
        ContornoHorizontal.setFill(Color.GREENYELLOW);
        Rectangle ContornoHorizontal2 = new Rectangle(0,703,1366,15);
        ContornoHorizontal2.setFill(Color.GREENYELLOW);
        Rectangle Cielo = new Rectangle(15,15,1334,500);
        Cielo.setFill(Color.LIGHTSKYBLUE);
        
        Pane root = new Pane();
        root.getChildren().add(ContornoVertical);
        root.getChildren().add(ContornoVertical2);
        root.getChildren().add(ContornoHorizontal);
        root.getChildren().add(ContornoHorizontal2);
        root.getChildren().add(Cielo);
        
        Scene scene = new Scene (root, ancho, alto);
        
        primaryStage.setTitle("SombreroFX");
        primaryStage.setScene(scene);
        primaryStage.show();

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
