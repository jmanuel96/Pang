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
        
        // Elementos del borde de la pantalla del juego
        Rectangle ContornoVertical = new Rectangle(0, 0, 15, 600);
        ContornoVertical.setFill(Color.GREENYELLOW);
        Rectangle ContornoVertical2 = new Rectangle(1349,0,1366,600);
        ContornoVertical2.setFill(Color.GREENYELLOW);
        Rectangle ContornoHorizontal = new Rectangle(0,0,1366,15);
        ContornoHorizontal.setFill(Color.GREENYELLOW);
        Rectangle ContornoHorizontal2 = new Rectangle(0,600,1366,15);
        ContornoHorizontal2.setFill(Color.GREENYELLOW);
        
        // Elementos del Cielo del juego
        Rectangle Cielo = new Rectangle(15,15,1334,585);
        Cielo.setFill(Color.LIGHTSKYBLUE);
        
        // Elementos del Cajetin del juego
        Rectangle Cajetin = new Rectangle (0,615,1366,110);
        Cajetin.setFill(Color.SLATEGRAY); 
        
        // Elementos de la montaña del juego
        Polygon poligonomontaña = new Polygon (new double[]{
            15.0, 600.0,
            1349.0, 600.0,
            600.0, 150.0,
            450.0, 150.0});
        
        Polygon nievemontaña = new Polygon (new double[]{
            600.0, 150.0,
            450.0, 150.0,
            363.0, 240.0,
            751.0, 240.0});
        
        // Elementos para la creación de las nubes del juego
        Circle elementonube1 = new Circle (200,150,25);
        Circle elementonube2 = new Circle (225,150,20);
        Circle elementonube3 = new Circle (175,150,18);
        
        // Colores de la Montaña
        nievemontaña.setFill(Color.WHITE);
        poligonomontaña.setFill(Color.DARKSLATEGREY);
        
        // Colores de las nubes
        elementonube1.setFill(Color.WHITE);
        elementonube2.setFill(Color.WHITE);
        elementonube3.setFill(Color.WHITE);
        
        
        
        Pane root = new Pane();
        root.getChildren().add(ContornoVertical);
        root.getChildren().add(ContornoVertical2);
        root.getChildren().add(ContornoHorizontal);
        root.getChildren().add(ContornoHorizontal2);
        root.getChildren().add(Cielo);
        root.getChildren().add(Cajetin);
        root.getChildren().add(poligonomontaña);
        root.getChildren().add(nievemontaña);
        root.getChildren().add(elementonube1);
        root.getChildren().add(elementonube2);
        root.getChildren().add(elementonube3);
        
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
